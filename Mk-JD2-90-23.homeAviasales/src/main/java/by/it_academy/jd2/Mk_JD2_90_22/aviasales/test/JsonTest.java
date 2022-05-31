package by.it_academy.jd2.Mk_JD2_90_22.aviasales.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		
		String json = "{"
				+ "	\"id\": 1,"
				+ "	\"firstName\": \"  \","
				+ "	\"lastName\": \"Vital\","
				+ "	\"age\": 2,"
				+ "	\"books\": ["
				+ "		{"
				+ "			\"name\": \"Max\","
				+ "			\"author\" : \"Dima\""
				+ "		},"
				+ "		{"
				+ "			\"name\": \"Max\","
				+ "			\"author\" : \"Dima\""
				+ "		}"
				+ "	]"
				+ "}";

		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(json, User.class);
	//	System.out.println(user);
		
	String s =	mapper.writeValueAsString(user);
	System.out.println(s);
		
	}
}
