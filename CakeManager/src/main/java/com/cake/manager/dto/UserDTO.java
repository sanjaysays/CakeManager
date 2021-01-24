package com.cake.manager.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UserDTO {

	 	private long id;
	 	
	 	private String providerUserId;
	 
	    private String email;
	 
	    private boolean enabled;
	 
	    private String displayName;
	 
	    protected Date createdDate;
	 
	    protected Date modifiedDate;
	 
	    private String password;
	 
	    private String provider;
	    
	    private int roleId;
}
