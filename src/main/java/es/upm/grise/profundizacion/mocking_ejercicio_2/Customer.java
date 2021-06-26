package es.upm.grise.profundizacion.mocking_ejercicio_2;


public class Customer {
	
	private long id;
	private String firstName;
	private String lastName1;
	private String lastName2;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
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

}