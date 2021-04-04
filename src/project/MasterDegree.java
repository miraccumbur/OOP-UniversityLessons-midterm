package project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class MasterDegree extends Student {

	
	public MasterDegree(String name, String surname, String mail, String id, String department, String GPA) {
		super(name, surname, mail, id, department, GPA);
		// TODO Auto-generated constructor stub
	}
	
public ArrayList<String> read(){
		
		ArrayList <String> masterdegree_person = new ArrayList <String>();
		
		
		
		
		FileInputStream fis1=null;
		
		
		try {
			String s="";
			
			int value;

			
			fis1=new FileInputStream("masterdegree.txt");
			
			while ((value =  fis1.read()) != -1) {
             
                 s+=(char) value;
             }
			
			
			
			masterdegree_person.add(s);
			
			
		
			
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
			
		
		return masterdegree_person;
		
	}
	
	
	public void write(){
		try {
			FileOutputStream fos=new FileOutputStream("masterdegree.txt",true);
			String information = name+" , "
								+surname+" , " 
								+mail+" , "
								+id+" , "
								+department+" , "
								+GPA+"\n";
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
