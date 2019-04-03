package com.DBTransactions;

public class UserParser {

	UserDetails parser(String s) {
	
	
	UserDetails user= new UserDetails();
	String S1[] =s.split(",");
	for(int i=1;i<S1.length;i++)
	{
		String [] s2=S1[i].split("=");
		System.out.println("s2[0]"+s2[0]);
		
		if(s2[0].trim().equals("name"))
		{
			user.setName(s2[1]);
		}
		
		else if(s2[0].trim().equals("phoneNumber"))
		{
			user.setPhoneNumber(s2[1]);
		}
		else if(s2[0].trim().equals("emailID"))
		{
			user.setEmailID(s2[1]);
		}
		else if(s2[0].trim().equals("age"))
		{
			user.setAge(s2[1]);
		}
		else if(s2[0].trim().equals("sex"))
		{
			user.setSex(s2[1]);
		}
		else if(s2[0].trim().equals("rating"))
		{
			user.setRating(s2[1].substring(0,s2[1].length()-2));
		}
		
	}
	return user;
	}
}
