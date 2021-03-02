package es.upm.grise.profundizacion.mocking_ejercicio_2;

public class CustomerReader {
	
	private EntityManager entityManager;
	
	public CustomerReader(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public String findFullName(Long customerID) throws Exception{
		
		Customer customer = entityManager.find(Customer.class, customerID);
		
		if(customer == null)
			throw new Exception("Customer not found");
		
		if(customer.getFirstName().isEmpty() || customer.getFirstName() == null) 
			throw new Exception("Customer first name empty");
		
		if(customer.getLastName1().isEmpty() || customer.getLastName1() == null) 
			throw new Exception("Customer last name 1 empty");
		
		return customer.getFirstName() + " " + customer.getLastName1() + " " + customer.getLastName2();
	}

}
