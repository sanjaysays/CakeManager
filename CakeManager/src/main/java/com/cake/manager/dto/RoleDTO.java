package com.cake.manager.dto;

import java.util.Set;

import lombok.Data;

@Data
public class RoleDTO {

	 public static final String USER = "USER";
	    public static final String ROLE_USER = "ROLE_USER";
	 
	    private int roleId;
	 
	    private String name;
	 
	     @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + ((name == null) ? 0 : name.hashCode());
	        return result;
	    }
	 
	    @Override
	    public boolean equals(final Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final RoleDTO role = (RoleDTO) obj;
	        if (!role.equals(role.name)) {
	            return false;
	        }
	        return true;
	    }
	 
	    @Override
	    public String toString() {
	        final StringBuilder builder = new StringBuilder();
	        builder.append("Role [name=").append(name).append("]").append("[id=").append(roleId).append("]");
	        return builder.toString();
	    }
	    
}
