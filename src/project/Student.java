package project;

public class Student extends UniversityPerson {
   String department,GPA,graduate;


public Student(String name, String surname, String mail, String id,String department,String GPA) {
	super(name, surname, mail, id);
	this.department=department;
	this.GPA=GPA;
	
}

public String getDepartment() {
	return department;
}

public void setDepartment(String department) {
	this.department = department;
}

public String getGPA() {
	return GPA;
}

public void setGPA(String gPA) {
	GPA = gPA;
}

public String getGraduate() {
	return graduate;
}

public void setGraduate(String graduate) {
	this.graduate = graduate;
}
   


}
