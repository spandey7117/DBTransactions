package com.DBTransactions;

public class Helper {

	String saaa="{_id=5c9bbef9facc0117c2908626, endLatitude=10.5, endLongitude=11.5, myPlanName=daily1, id=qq@gmail.com, startLatitude=10.1, status=Pending, startLongitude=11.1, time=20:18:11, preferedMode=car, preferedSex=male, type=MyPlan, startLoc=abc, endLoc=xyz}";
	
public 	MyPlan myplanConerter(String s)
	{MyPlan myPlan= new MyPlan();
		String S1[] =s.split(",");
		for(int i=1;i<S1.length;i++)
		{
			String [] s2=S1[i].split("=");
			System.out.println("s2[0]"+s2[0]);
			
			if(s2[0].trim().equals("endLatitude"))
			{
				
				System.out.println("endLatitude"+s2[1]);
				myPlan.setEndLat(s2[1]);
			}
			else if(s2[0].trim().equals("endLongitude"))
			{System.out.println(s2[1]);
				myPlan.setEndLong(s2[1]);
			}
			else if(s2[0].trim().equals("myPlanName"))
			{System.out.println(s2[1]);
				myPlan.setMyPlanName(s2[1]);
			}
			else if(s2[0].trim().equals("id"))
			{System.out.println(s2[1]);
				myPlan.setId(s2[1]);
			}
			else if(s2[0].trim().equals("startLatitude"))
			{System.out.println(s2[1]);
				myPlan.setStartLat(s2[1]);
			}
			else if(s2[0].trim().equals("status"))
			{System.out.println(s2[1]);
				System.out.println("plan status:"+s2[1]);
			}
			else if(s2[0].trim().equals("startLongitude"))
			{System.out.println(s2[1]);
				myPlan.setStartLong(s2[1]);
			}


			else if(s2[0].trim().equals("time"))
			{System.out.println(s2[1]);
				myPlan.setTime(s2[1]);
			}
			else if(s2[0].trim().equals("preferedMode"))
			{System.out.println(s2[1]);
				myPlan.setPreferedMode(s2[1]);
			}
			else if(s2[0].trim().equals("preferedSex"))
			{System.out.println(s2[1]);
				myPlan.setPreferedSex(s2[1]);
			}
			else if(s2[0].trim().equals("type"))
			{System.out.println(s2[1]);
				System.out.println("plan type:"+s2[1]);
			}
			else if(s2[0].trim().equals("startLoc"))
			{System.out.println(s2[1]);
				myPlan.setStartLoc(s2[1]);
			}
			else if(s2[0].trim().equals("endLoc"))
			{System.out.println(s2[1]);
				myPlan.setEndLoc(s2[1].substring(0, s2[1].length()-2));
			}
			
		}
		
		
		
		
		return myPlan;
	}
}
