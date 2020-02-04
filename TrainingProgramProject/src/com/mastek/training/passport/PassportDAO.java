package com.mastek.training.passport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.mastek.training.hrapp.Designations;
import com.mastek.training.hrapp.Employee;
import com.mastek.training.hrapp.Grades;
import com.mysql.jdbc.Driver;

public class PassportDAO implements DataAccessObject<PassportApplication> {

	Connection conMysql;
	
	public PassportDAO() {
		try {
			//1. load the data base driver 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. open the connection to MYSQL
			conMysql= DriverManager.getConnection(
					//connection string to identify the database
					"jdbc:mysql://localhost:3306/graduate_2020_masteknet",
					"root", //User name
					"root" //password
					);
			System.out.println("connection successfull");
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		;
		
	}
	
	
	
	@Override
	public PassportApplication add(PassportApplication newpass) {
		//1. define the query in sql format with the parameters if required 
		String sqlInsert=" Insert into passport_application" + 
				" (passport_id,first_name,surname,date_of_birth,nationality,place_of_birth,sex) " +
				" values(?,?,?,?,?,?,?)";
		//2. prepare the statement object for the query
		try (PreparedStatement psInsert = conMysql.prepareStatement(sqlInsert)){
			//set all the parameters required in the query 
			psInsert.setInt(1, newpass.getPassportID());
			psInsert.setString(2,newpass.getFirstName());
			psInsert.setString(3, newpass.getSurName());
			psInsert.setString(4, newpass.getDateOfBirth());
			psInsert.setString(5, newpass.getNationality());
			psInsert.setString(6, newpass.getPlacOfBirth());
			psInsert.setString(7, newpass.getSex().toString());
			
			//4. execute the query on the database table, returns the rows affected 
			int recordAffected = psInsert.executeUpdate();  //used for insert, update and delete command 
			
			System.out.println(recordAffected + "Employee Inserted");			
		} catch (Exception e) {
			e.printStackTrace();
			newpass= null; //return null in the case of failure of query
		}
		
		return newpass;
	}

	@Override
	public Collection<PassportApplication> listAll() {
		String sqlSelectAll = "select * from passport_application";
		List<PassportApplication> passport = new LinkedList<PassportApplication>();
		try(Statement stSelectAll= conMysql.createStatement()){
			ResultSet rsPassport = stSelectAll.executeQuery(sqlSelectAll);
			while(rsPassport.next()) { //loops until resultset has next record 
				//create object for each record in database
				PassportApplication p = new PassportApplication();
				
				//read the data from current row using resultset
				p.setPassportID(rsPassport.getInt("passport_id"));
				p.setFirstName(rsPassport.getString("firstname"));
				p.setSurName(rsPassport.getString("surname"));
				p.setDateOfBirth(rsPassport.getString("dateofbirth"));
				p.setNationality(rsPassport.getString("nationality"));
				p.setPlacOfBirth(rsPassport.getString("placeOfBirth"));
				p.setSex(Sex.valueOf(rsPassport.getString("designation")));
				
				//add the data to collection 
				passport.add(p);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return passport; //return the collection with employees fetched from db
	}

	@Override
	public PassportApplication find(int key) {
		String findSQL= "Select * from passport_application where passport_id=?";
		PassportApplication newpass=null;
		
		try (PreparedStatement psFind= conMysql.prepareStatement(findSQL)){
			psFind.setInt(1, key);//set the empno for search 
			
			ResultSet rsFindResult = psFind.executeQuery();
			
			
			if (rsFindResult.next()) {
				newpass= new PassportApplication();				
				newpass.setPassportID(rsFindResult.getInt("passport_id"));
				newpass.setFirstName(rsFindResult.getString("firstname"));
				newpass.setSurName(rsFindResult.getString("surname"));
				newpass.setDateOfBirth(rsFindResult.getString("dateofbirth"));
				newpass.setNationality(rsFindResult.getString("nationality"));
				newpass.setPlacOfBirth(rsFindResult.getString("placeOfBirth"));
				newpass.setSex(Sex.valueOf(rsFindResult.getString("designation")));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return newpass;
	}

	@Override
	public PassportApplication remove(int key) {
		PassportApplication passToBeRemoved= find(key);
		if(passToBeRemoved!=null) {
			String sqlDelete= "delete from passport_application where passport_id=?";
			
			try (PreparedStatement psDelete = conMysql.prepareStatement(sqlDelete)){
				psDelete.setInt(1, key);
				
				int rowsDeleted = psDelete.executeUpdate();
				System.out.println(rowsDeleted+ " Passort Deleted");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return passToBeRemoved;
	}

}
