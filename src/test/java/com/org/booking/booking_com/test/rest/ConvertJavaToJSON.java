package com.org.booking.booking_com.test.rest;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJavaToJSON {
	

	
	public void convertjavaToJson() throws JsonProcessingException{
		ObjectMapper mapper = new ObjectMapper();
		Employee obj = new Employee("Rajiv", "Mirpuri");

		//Object to JSON in file
		//mapper.writeValue(new File("c:\\file.json"), obj);

		//Object to JSON in String
		try {
			mapper.writeValue(new File("result.json"), obj);
			System.out.println(mapper.writeValueAsString(obj));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//Plain JSON
        //mapper.writerWithDefaultPrettyPrinter().writeValue(new File("result.json"), carFleet);//Prettified JSON
    
		//System.out.println(jsonInString);
	}

}
