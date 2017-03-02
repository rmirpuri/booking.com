package com.org.booking.booking_com.test.rest;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TestJavaToJSON {
	
	public static void main(String[] args){
		
		ConvertJavaToJSON con = new ConvertJavaToJSON();
		
		try {
			con.convertjavaToJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
