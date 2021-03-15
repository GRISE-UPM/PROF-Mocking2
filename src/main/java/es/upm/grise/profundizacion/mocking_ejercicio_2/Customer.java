package es.upm.grise.profundizacion.mocking_ejercicio_2;


public class Customer {
	
	private long id;
	private String firstName="";
	private String lastName1="";
	private String lastName2="";
	
	public long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName1() {
		return lastName1;
	}
	
	public String getLastName2() {
		return lastName2;
	}
	
	public void setFirstName(String name) {
		this.firstName = name;
	}

	public void setLastName1(String lastName) {
		this.lastName1 =lastName;
	}
	
	public void setLastName2(String lastName) {
		this.lastName2 =lastName;
	}	

}