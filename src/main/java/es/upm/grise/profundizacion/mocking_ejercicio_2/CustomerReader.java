package es.upm.grise.profundizacion.mocking_ejercicio_2;

public class CustomerReader { //esta es la clase que tiene la business logic y sobre la cual quiero hacer el test
	
	private EntityManager entityManager;
	
	public CustomerReader(EntityManager entityManager) { //entity manager es la interface sobre la que voy a hacer el mock
		this.entityManager = entityManager;
	}

	public String findFullName(Long customerID) throws Exception{
		
		Customer customer = entityManager.find(customerID);
		
		if(customer == null)
			throw new Exception("Customer not found");
		
		if( customer.getFirstName() == null || customer.getFirstName().isEmpty()) 
			throw new Exception("Customer first name empty");
		
		if(customer.getLastName1() == null || customer.getLastName1().isEmpty()) 
			throw new Exception("Customer last name 1 empty");
		
		return customer.getFirstName() + " " + customer.getLastName1() + " " + customer.getLastName2();
	}

}
