package com.mastek.hrapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mastek.hrapp.entities.Project;

@Repository //declare the DAO layer as repository
public interface ProjectJPADAO extends CrudRepository<Project, Integer> {  //crud repository <class,primarykeytype>
	
	

}

