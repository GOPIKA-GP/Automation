package utilities;

import com.github.javafaker.Faker;

public class FakerUtility 
{
	
	Faker faker=new Faker();
	public String firstName() 
	{
		return faker.name().firstName();
	}
	
	public String generateFullName() 
	{
		return faker.name().fullName();    
    }
	
	public String generateAddress()
	{
		return faker.address().fullAddress();
	}
	
	public String generatePhoneNumber()
	{
		return faker.phoneNumber().toString();
	}
	
	public String company() 
    {
	return faker.company().name();
    }
	
	public String emailId() 
	{
	return faker.internet().emailAddress();
	}
	
	public String dateOfBirth() 
	{
	return faker.date().birthday().toString();
	}
}