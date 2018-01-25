package wfc.demo.ps.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Volunteer {
	
    private Long id;
	
	private String firstname;
	
	private String lastname;
	
	private String userid;
	
	
	private Set<String>  services = new HashSet<String>();


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getUserid() {
		return userid;
	}


	public void setUserid(String userid) {
		this.userid = userid;
	}


	public Set<String> getServices() {
		return services;
	}


	public void setServices(Set<String> services) {
		this.services = services;
	}
	public void addService(String servicename) {
		this.services.add(servicename); 
	}
	
}
