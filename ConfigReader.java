package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;



public class ConfigReader {
	
	private static Properties properties = new Properties();
	static String File_Path = "Config.properties";

    // Method to load the properties file
    public static void loadProperties() {
    	try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(File_Path)) {
            if (input == null) {
                throw new RuntimeException("❌ Unable to find " + File_Path + " in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("❌ Failed to load properties file: " + e.getMessage());
        }
    }
    
    	// Specific getter for browser
    	public static String getBrowser() {
    		return properties.getProperty("Browser").toLowerCase();
    	}

    	// Specific getter for base URL
    	public static String getBaseUrl() {
    		return properties.getProperty("BaseURL");
    	}

		
		//Reads the valid username from property file
		public static String getValidUsername() {
			
			return properties.getProperty("Login_Username1");			
	        
	    }		
		
		//Reads the valid password from property file
		public static String getValidPassword() {
			
			return properties.getProperty("Login_Password1");			
	        
	    }
		
		//Reads the invalid from property file		
		public static String getInvalidUsername() {
			
			return properties.getProperty("Login_Username2");			
	        
	    }
		
		//Reads the invalid password from property file		
		public static String getInvalidPassword() {
			
			return properties.getProperty("Login_Password2");			
	        
	    }
		
		public static List<String> getProducts(){
			
			String[] products = properties.getProperty("productsToAdd").split(",");
			List<String> productsList = Arrays.asList(products);
			return productsList;
			
			
		}	
		
		public static String getFirstName() {
			
			return properties.getProperty("FirstName");			
	        
	    }
		
		public static String getLastName() {
			
			return properties.getProperty("LastName");			
	        
	    }
		public static String getAddress() {
			
			return properties.getProperty("Address");			
	        
	    }
		public static String getState() {
			
			return properties.getProperty("State");			
	        
	    }
		public static String getPostalCode() {
			
			return properties.getProperty("PostalCode");			
	        
	    }
		
	}


