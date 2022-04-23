package domain;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
	 private String firstName;
	 private String lastName;
	 private String middleName;
	 private String username;
	 private String password;
	 private Timestamp dateOfBirth;
	 private Timestamp created;
	 private Roles role;

	 public User() {
	  super();
	 }

	 public User(String firstName, String lastName, String middleName, String username, String password,
	   Timestamp dateOfBirth, Timestamp created, Roles role) {
	  super();
	  this.firstName = firstName;
	  this.lastName = lastName;
	  this.middleName = middleName;
	  this.username = username;
	  this.password = password;
	  this.dateOfBirth = dateOfBirth;
	  this.created = created;
	  this.role = role;
	 }

	 public String getFirstName() {
	  return firstName;
	 }

	 public void setFirstName(String firstName) {
	  this.firstName = firstName;
	 }

	 public String getLastName() {
	  return lastName;
	 }

	 public void setLastName(String lastName) {
	  this.lastName = lastName;
	 }

	 public String getMiddleName() {
	  return middleName;
	 }

	 public void setMiddleName(String middleName) {
	  this.middleName = middleName;
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

	 public Timestamp getDateOfBirth() {
	  return dateOfBirth;
	 }

	 public void setDateOfBirth(Timestamp dateOfBirth) {
	  this.dateOfBirth = dateOfBirth;
	 }

	 public Timestamp getCreated() {
	  return created;
	 }

	 public void setCreated(Timestamp created) {
	  this.created = created;
	 }

	 public Roles getRole() {
	  return role;
	 }

	 public void setRole(Roles role) {
	  this.role = role;
	 }

	 @Override
	 public int hashCode() {
	  return Objects.hash(created, dateOfBirth, firstName, lastName, middleName, password, role, username);
	 }

	 @Override
	 public boolean equals(Object obj) {
	  if (this == obj)
	   return true;
	  if (obj == null)
	   return false;
	  if (getClass() != obj.getClass())
	   return false;
	  User other = (User) obj;
	  return Objects.equals(created, other.created) && Objects.equals(dateOfBirth, other.dateOfBirth)
	    && Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
	    && Objects.equals(middleName, other.middleName) && Objects.equals(password, other.password)
	    && role == other.role && Objects.equals(username, other.username);
	 }

	 @Override
	 public String toString() {
	  return "User [firstName=" + firstName + ", lastName=" + lastName + ", middleName=" + middleName + ", username="
	    + username + ", password=" + password + ", dateOfBirth=" + dateOfBirth + ", created=" + created
	    + ", role=" + role + "]";
	 }
	 

	}
