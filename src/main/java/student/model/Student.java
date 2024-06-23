package student.model;

import java.util.ArrayList;
import java.util.List;


public class Student {
private int id;
private String name;
private String birthday;
private String phone;
private String gender;
private String education;

List<Course>courses=new ArrayList<>();

public Student() {
	
}



public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getBirthday() {
	return birthday;
}


public void setBirthday(String birthday) {
	this.birthday = birthday;
}


public String getPhone() {
	return phone;
}


public void setPhone(String phone) {
	this.phone = phone;
}


public String getGender() {
	return gender;
}


public void setGender(String gender) {
	this.gender = gender;
}


public String getEducation() {
	return education;
}


public void setEducation(String education) {
	this.education = education;
}






}
