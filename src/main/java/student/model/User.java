 package student.model;

import java.util.Objects;

import javax.validation.constraints.NotEmpty;



public class User {
private int id;
@NotEmpty
private String username;
@NotEmpty
private String password;
@NotEmpty
private String email;
@NotEmpty
private String userrole;
@NotEmpty
private String confirmpassword;
@NotEmpty



public User() {
	}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getUsername() {
	return username;
}


public void setUsername(String username) {
	this.username = username;
}


public String getPassword() {
	return password;
}


public void setPassword(String password) {
	this.password = password;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getUserrole() {
	return userrole;
}


public void setUserrole(String userrole) {
	this.userrole = userrole;
}


public String getConfirmpassword() {
	return confirmpassword;
}


public void setConfirmpassword(String confirmpassword) {
	this.confirmpassword = confirmpassword;
}

@Override
public int hashCode() {
	return Objects.hash(id,username);
}
@Override
public boolean equals(Object obj) {
	if(this==obj) {
		return true;
	}
	if(obj==null) {
		return false;
	}
	if(getClass()!=obj.getClass()) {
		return false;
		
	}
	User other=(User)obj;
	return Objects.equals(id, other.getId())&& Objects.equals(username, other.getUsername());
	
}







}
