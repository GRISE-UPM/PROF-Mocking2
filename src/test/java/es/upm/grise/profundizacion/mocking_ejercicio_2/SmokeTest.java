package es.upm.grise.profundizacion.mocking_ejercicio_2;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Test;


class SmokeTest {

	@Test
	public void dosApellidos() throws Exception {
		//Creamos el usuario de prueba
		Customer customerEjemplo = new Customer();
		customerEjemplo.setFirstName("Omar");
		customerEjemplo.setLastName1("Mokrani");
		customerEjemplo.setLastName2("Gallego");
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
		CustomerReader customerReader = new CustomerReader(entityManager);
		assertEquals("Omar Mokrani Gallego",customerReader.findFullName(1L));
		}
	
	@Test
	public void soloPrimerApellido() throws Exception {// No funciona pq customerReader pone null en el segundo apellido
		//Creamos el usuario de prueba
		Customer customerEjemplo = new Customer();
		customerEjemplo.setFirstName("Omar");
		customerEjemplo.setLastName1("Mokrani");
		
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
		CustomerReader customerReader = new CustomerReader(entityManager);
		assertEquals("Omar Mokrani",customerReader.findFullName(1L));
		}

	@Test
	public void noPrimerApellido() throws Exception { //Como declarar que se espera una excepcion
		//Creamos el usuario de prueba
		Customer customerEjemplo = new Customer();
		customerEjemplo.setFirstName("Omar");

		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
		
		
		}
	
	@Test
	public void sinNombre() throws Exception {//Como declarar que se espera una excepcion
		//Creamos el usuario de prueba
		Customer customerEjemplo = new Customer();
		customerEjemplo.setFirstName("");

		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
				
		}
	
	@Test
	public void noExiste() throws Exception {//Como declarar que se espera una excepcion

		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(null);
						
		}
}
