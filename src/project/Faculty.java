package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Faculty extends UniversityPerson {
	
	String officenumber,phone;

	public Faculty(String name,String surname,String mail,String id,String officenumber,String phone) {
		super(name,surname,mail,id);
		this.officenumber = officenumber;
		this.phone=phone;
	}

	public String getLecture() {
		return officenumber;
	}

	public void setLecture(String lecture) {
		this.officenumber = lecture;
	}

	
	public ArrayList<String> read(){
		
		ArrayList <String> faculty_person = new ArrayList <String>();
		
		
		
		
		FileInputStream fis1=null;
		
		
		try {
			String s="";
			
			int value;

			
			fis1=new FileInputStream("faculty.txt");
			
			while ((value =  fis1.read()) != -1) {
             
                 s+=(char) value;
             }
			
			
			
			faculty_person.add(s);
			
			
		
			
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
			
		
		return faculty_person;
		
	}
	
	
	public void write(){
		try {
			FileOutputStream fos=new FileOutputStream("faculty.txt",true);
			String information = name+" , "
								+surname+" , " 
								+mail+" , "
								+id+" , "
								+officenumber+" , "
								+phone+"\n";
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
