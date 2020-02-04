package com.mastek.training.linkedIn;

public class Profile {
	private String Email;
	private String profileName; 
	private String qualifications;
	private String skills;
	private String certifications;
	private String jobDetails;
	
	public String getProfileName() {
		return profileName;
	}
	public void setProfileName(String profileName) {
		
		this.profileName = profileName;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getCertifications() {
		return certifications;
	}
	public void setCertifications(String certifications) {
		this.certifications = certifications;
	}
	public String getJobDetails() {
		return jobDetails;
	}
	public void setJobDetails(String jobDetails) {
		this.jobDetails = jobDetails;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	
	

}
