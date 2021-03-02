package es.upm.grise.profundizacion.mocking_ejercicio_2;

public interface EntityManager {

	Customer find(Class<Customer> customerClass, Long customerID);

}
