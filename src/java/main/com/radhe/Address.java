package com.radhe;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class Address {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private int zipcode;
	private String country;
	
}
