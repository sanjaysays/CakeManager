package com.cake.manager.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CakeDTO {

	 	private long id;
	 	
	 	@NotNull
	    private String cakeName;
	 	
	 	@NotNull
	    private String cakeDescription;
	 	 
	 	@NotNull
	    private BigDecimal cakePrice;
	 	
	 	public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getCakeName() {
			return cakeName;
		}

		public void setCakeName(String cakeName) {
			this.cakeName = cakeName;
		}

		public String getCakeDescription() {
			return cakeDescription;
		}

		public void setCakeDescription(String cakeDescription) {
			this.cakeDescription = cakeDescription;
		}

		public BigDecimal getCakePrice() {
			return cakePrice;
		}

		public void setCakePrice(BigDecimal cakePrice) {
			this.cakePrice = cakePrice;
		}

		
}
