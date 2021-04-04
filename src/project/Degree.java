package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Degree extends Student {

	String departmentClass;
	
	public Degree(String name, String surname, String mail, String id, String department, String GPA,String departmentClass) {
		super(name, surname, mail, id, department, GPA);
		this.departmentClass=departmentClass;
		
	}
	
	public ArrayList<String> read(){
		
		ArrayList <String> degree_person = new ArrayList <String>();
		
		
		
		
		FileInputStream fis1=null;
		
		
		try {
			String s="";
			
			int value;

			
			fis1=new FileInputStream("degree.txt");
			
			while ((value =  fis1.read()) != -1) {
             
                 s+=(char) value;
             }
			
			
			
			degree_person.add(s);
			
			
		
			
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
			
		
		return degree_person;
		
	}
	
	
	public void write(){
		try {
			FileOutputStream fos=new FileOutputStream("degree.txt",true);
			String information = name+" , "
								+surname+" , " 
								+mail+" , "
								+id+" , "
								+department+" , "
								+GPA+" , "
								+departmentClass+"\n";
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
