package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Scanner;

public class Staff extends UniversityPerson {
    String mission;
    
    

	public Staff(String name, String surname, String mail, String id,String mission) {
		super(name, surname, mail, id);
		this.mission=mission;
	}

	public String getMission() {
		return mission;
	}

	public void setMission(String mission) {
		this.mission = mission;
	}
	
	
	
	
	
	
	public  ArrayList<String> read() {
		ArrayList <String> staff_person = new ArrayList <String>();
		
		
		
		
		FileInputStream fis1=null;
		
		
		try {
			String s="";
			
			int value;

			
			fis1=new FileInputStream("staff.txt");
			
			while ((value =  fis1.read()) != -1) {
             
                 s+=(char) value;
             }
			
			
			
			staff_person.add(s);
			
			
		
			
		}
			
		
		
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR...");
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR...");
		}
		finally {
			try {
                if (fis1 != null ){
                    fis1.close();
                    
                    
                }
                
                
            } catch (IOException ex) {
                System.out.println("ERROR...");
            }
			
			
		}
			
		
		
	
		

		return staff_person;
	}
	
	public void write() {
		try {
			FileOutputStream fos=new FileOutputStream("staff.txt",true);
			String information = name+" , "
								+surname+" , " 
								+mail+" , "
								+id+" , "
								+mission+"\n";
			byte[] b = information.getBytes(Charset.forName("UTF-8"));
			fos.write(b);
			
			System.out.println("Succesful...\n");
			
								
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR...\n");
		}
		
	}
}


