package project;

public abstract class UniversityPerson {

   String name,surname,mail,id;

public UniversityPerson(String name, String surname, String mail, String id) {
	super();
	this.name = name;
	this.surname = surname;
	this.mail = mail;
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getSurname() {
	return surname;
}

public void setSurname(String surname) {
	this.surname = surname;
}

public String getMail() {
	return mail;
}

public void setMail(String mail) {
	this.mail = mail;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

}

