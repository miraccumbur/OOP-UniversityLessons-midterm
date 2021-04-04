package project;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Scanner;
import project.Staff;

public class Main {
	public  static Scanner scan=new Scanner(System.in);
	
	public static String sha256(String base) {
	    try{
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hash = digest.digest(base.getBytes("UTF-8"));
	        StringBuffer hexString = new StringBuffer();

	        for (int i = 0; i < hash.length; i++) {
	            String hex = Integer.toHexString(0xff & hash[i]);
	            if(hex.length() == 1) hexString.append('0');
	            hexString.append(hex);
	        }

	        return hexString.toString();
	    } catch(Exception ex){
	       throw new RuntimeException(ex);
	    }
	}
	
	
	public static void login(){
		System.out.println("\n\n*****************************************************************************");
		System.out.println("- - - - - - - - - - - - - - - - LOGIN PAGE - - - - - - - - - - - - - - - - - ");
		System.out.println("*****************************************************************************\n\n");
		try {
			
			String profile_information="";
			Scanner scanfile = new Scanner(new FileReader("profiles.txt"));
			System.out.print("Please enter your username:");
			String username=scan.nextLine();
			System.out.print("Please enter your password:");
			String password=scan.nextLine();
			
			while (scanfile.hasNextLine()) {
	               profile_information = scanfile.nextLine();
	               String[] profile_array = profile_information.split(",");
	               String profile_username = profile_array[0];
	               String profile_password = profile_array[1];
	               
	               String hash_password = sha256(password);
	                
	               if(username.equals(profile_username)&&hash_password.equals(profile_password)) {
	            	   
	            	   menu();
	            	   
	            	   
	            	   }
	               }
			
		
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}

	
			

		
		
		
	}
	
	public static void register() {
		System.out.println("\n\n*****************************************************************************");
		System.out.println("- - - - - - - - - - - - - - - REGISTER PAGE - - - - - - - - - - - - - - - - - ");
		System.out.println("*****************************************************************************\n\n");
		
		try {
			System.out.print("Please enter your username:");
			String username=scan.nextLine();
			System.out.print("Please enter your password:");
			String password=scan.nextLine();
			String hash_password = sha256(password);
			FileOutputStream fos=new FileOutputStream("profiles.txt",true);
			String information = ""+username+","
								+hash_password+"\n";
			byte[] b = information.getBytes(Charset.forName("UTF-8"));
			fos.write(b);
			
			System.out.println("Succesful...\n");
			login();
			
								
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERROR...\n");
		}
		
	}
	
	public static void student_operations() {
		
		System.out.println("\n\n*****************************************************************************\n");
		System.out.println("- - - - - - - - - - - - - - - - STUDENT OPERATIONS - - - - - - - - - - - - - -\n");
		System.out.println("*****************************************************************************\n\n");
		
		String operation="Degree = 1\n"+
				"Master degree = 2\n\n"+
				"Back to menu = b";
		System.out.println(operation);
		String choose=scan.nextLine();

		switch(choose) {
		case "1":
			student_degree();
			
			break;
		case "2":
			student_masterdegree();
			break;
		case "b":
			menu();
			break;
		default:
			System.out.println("Wrong Choice,Please try again..");
			student_operations();
			break;
			
		
		}
		
		
		
		
	}
	
	public static void student_degree() {
		
		String operation="Look the degree student information list = 1\n"+
				"Add new degree student information to list = 2\n\n"+
				"Back to menu = b";
		System.out.println(operation);
		String choose=scan.nextLine();
		
switch(choose) {
		
		case"1":
			Degree degree=new Degree(null, null, null, null, null, null, null);
			System.out.println(degree.read());
			student_degree();
			break;
		case"2":
			System.out.print("Please enter student name:");
			String name=scan.nextLine();
			System.out.print("\nPlesae enter student surname:");
			String surname=scan.nextLine();
			System.out.print("\nPlease enter student mail:");
			String mail=scan.nextLine();
			System.out.print("\nPlease enter student id:");
			String id=scan.nextLine();
			System.out.print("\nPlease enter student department:");
			String department=scan.nextLine();
			System.out.print("\nPlease enter student GPA:");
			String GPA=scan.nextLine();
			System.out.print("\nPlease enter student class:");
			String classdepartment=scan.nextLine();
			Degree degree2=new Degree(name,surname,mail,id,department,GPA,classdepartment);
			degree2.write();
			student_degree();

			
			break;
		case"b":
			student_operations();
			break;
		default:
			System.out.println("Wrong Choice, Please try again...");
			student_masterdegree();
			break;
		}
		
	}
	
	public static void student_masterdegree() {
		String operation="Look the master degree student information list = 1\n"+
				"Add new master degree student information to list = 2\n\n"+
				"Back to menu = b";
		System.out.println(operation);
		String choose=scan.nextLine();
		
		switch(choose) {
		
		case"1":
			MasterDegree masterdegree=new MasterDegree(null, null, null, null, null, null);
			System.out.println(masterdegree.read());
			student_masterdegree();
			break;
		case"2":
			System.out.print("Please enter student name:");
			String name=scan.nextLine();
			System.out.print("\nPlesae enter student surname:");
			String surname=scan.nextLine();
			System.out.print("\nPlease enter student mail:");
			String mail=scan.nextLine();
			System.out.print("\nPlease enter student id:");
			String id=scan.nextLine();
			System.out.print("\nPlease enter student department:");
			String department=scan.nextLine();
			System.out.print("\nPlease enter student GPA:");
			String GPA=scan.nextLine();
			MasterDegree masterdegree2=new MasterDegree(name,surname,mail,id,department,GPA);
			masterdegree2.write();
			student_masterdegree();

			
			break;
		case"b":
			student_operations();
			break;
		default:
			System.out.println("Wrong Choice, Please try again...");
			student_masterdegree();
			break;
		}
		
	}
	
	public static void staff_operations() {
		System.out.println("\n\n*****************************************************************************\n");
		System.out.println("- - - - - - - - - - - - - - - - - STAFF OPERATIONS - - - - - - - - - - - - - -\n");
		System.out.println("*****************************************************************************\n\n");
		
		String operation="Look the staff information list = 1\n"+
						"Add new staff information to list = 2\n\n"+
						"Back to menu = b";
		System.out.println(operation);
		String choose=scan.nextLine();
		
		switch(choose) {
		case "1":
			Staff staff=new Staff(null, null, null, null, null);
			System.out.println(staff.read());
			staff_operations();
			break;
		case "2":
			System.out.print("Please enter staff name:");
			String name=scan.nextLine();
			System.out.print("\nPlesae enter staff surname:");
			String surname=scan.nextLine();
			System.out.print("\nPlease enter staff mail:");
			String mail=scan.nextLine();
			System.out.print("\nPlease enter staff id:");
			String id=scan.nextLine();
			System.out.print("\nPlease enter staff mission:");
			String mission=scan.nextLine();
			Staff staff2=new Staff(name,surname,mail,id,mission);
			staff2.write();
			staff_operations();
			break;
		case "b":
			menu();
			break;
		default:
			System.out.println("Wrong choice, Please try again...");
			staff_operations();
			break;
			
		}
		
		
		
		
		
	}
	
	public static void faculty_operations() {
		System.out.println("\n\n*****************************************************************************");
		System.out.println("- - - - - - - - - - - - - - - - FACULTY OPERATIONS - - - - - - - - - - - - - -\n");
		System.out.println("*****************************************************************************\n\n");
		
			String operation="Look the faculty information list = 1\n"+
					"Add new faculty information to list = 2\n\n"+
					"Back to menu = b";
			System.out.println(operation);
			String choose=scan.nextLine();

			switch(choose) {
			case "1":
				Faculty faculty=new Faculty(null, null, null, null, null,null);
				System.out.println(faculty.read());
				faculty_operations();
				break;
			case "2":
				System.out.print("Please enter faculty staff name:");
				String name=scan.nextLine();
				System.out.print("\nPlesae enter faculty staff surname:");
				String surname=scan.nextLine();
				System.out.print("\nPlease enter faculty staff mail:");
				String mail=scan.nextLine();
				System.out.print("\nPlease enter faculty staff id:");
				String id=scan.nextLine();
				System.out.print("\nPlease enter faculty staff office number:");
				String officenumber=scan.nextLine();
				System.out.print("\nPlease enter faculty staff phone number:");
				String phone=scan.nextLine();
				Faculty faculty2=new Faculty(name,surname,mail,id,officenumber,phone);
				faculty2.write();
				faculty_operations();
				break;
			case "b":
				menu();
				break;
			default:
				System.out.println("Wrong choice, Please try again...");
				faculty_operations();
				break;
	
			}
		
	}
	
	
	public static void menu(){
		
		System.out.println("\n\n*****************************************************************************");
		System.out.println("- - - - - - - - - - - - WELCOME TO MENU - - - - - - - - - - - - - - - - - - -");
		System.out.println("*****************************************************************************\n\n");
		
		String operation_string="Student Operations = 1\n"+
								"Staff Operations = 2\n"+
								"Faculty Operations = 3\n"+
								"QUIT = q";
		
		System.out.println(operation_string);
		System.out.println("\nPlease choose...");
		String choose=scan.nextLine();
		
		switch(choose) {
			case "1":
				System.out.println("Redirecting to the Student Operations page...");
				student_operations();
				break;
			case "2":
				System.out.println("Redirecting to the Staff Operations page...");
				staff_operations();
				break;
			case "3":
				System.out.println("Redirecting to the Faculty Operations page...");
				faculty_operations();
				break;
			case "q":
				System.out.println("GOODBYE...");
				System.exit(0);
				break;
			default:
				break;
			
		}
		
		
	}

    


    public static void main(String[] args) {
    	
    	System.out.println("\n\n*****************************************************************************");
    	System.out.println("- - - - - - - - - - - - - - - WELCOME- - - - - - - - - - - - - - - - - - - - ");
    	System.out.println("*****************************************************************************\n\n");
    	
    	System.out.println("LOG IN = 1\nREGISTER = 2\nQUIT = q");
		String choose=scan.nextLine();
		switch(choose) {
		
		
		case "1":
			login();
			break;
		
		case "2":
			register();
			
			
			
			break;
			
			
		case "q":
			System.out.println("GOODBYE...");
			System.exit(0);
			break;
		default:
			System.out.println("Wrong choice, Please try again...");
			
			break;
		}
		
		
    	 
    	
    	
        

    }

    
}