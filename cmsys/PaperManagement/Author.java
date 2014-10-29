package cmsys.PaperManagement;

public class Author{
	private String firstName;
	private String lastName;
	
	public Author() {
		firstName = "";
		lastName = "";
	}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getName() {
		return lastName + ", " + firstName;
	}
	
	public int hashCode() {             
        String temp = firstName + lastName;
        return temp.hashCode();
    }
	
	@Override
	public boolean equals(Object o) {
		Author author = (Author)o;
		if (firstName.equals(author.firstName) && lastName.equals(author.lastName))
			return true;
		else
			return false;
	}
}
