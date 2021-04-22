package es.upm.grise.profundizacion.mocking_ejercicio_2;


import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.BDDMockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class SmokeTest {

	@Test
	public void dosApellidos() throws Exception {
		
		Customer customerEjemplo = mock(Customer.class);
		when(customerEjemplo.getFirstName()).thenReturn("Omar");
		when(customerEjemplo.getLastName1()).thenReturn("Mokrani");
		when(customerEjemplo.getLastName2()).thenReturn("Gallego");
		
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
		CustomerReader customerReader = new CustomerReader(entityManager);
		assertEquals("Omar Mokrani Gallego",customerReader.findFullName(1L));
		
		}
	
	@Test
	public void soloPrimerApellido() throws Exception {// No funciona pq customerReader pone null en el segundo apellido
		
		Customer customerEjemplo = mock(Customer.class);
		when(customerEjemplo.getFirstName()).thenReturn("Omar");
		when(customerEjemplo.getLastName1()).thenReturn("Mokrani");
		when(customerEjemplo.getLastName2()).thenReturn("null");
		
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
		CustomerReader customerReader = new CustomerReader(entityManager);
		assertEquals("Omar Mokrani null",customerReader.findFullName(1L));
		
		}

	@Test
	public void noPrimerApellido() throws Exception { //Como declarar que se espera una excepcion
		
		Customer customerEjemplo = mock(Customer.class);
		when(customerEjemplo.getFirstName()).thenReturn("Omar");
		
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
		
		CustomerReader customerReader = new CustomerReader(entityManager);
		Assertions.assertThrows(Exception.class, () -> {customerReader.findFullName(1L);});
		
		}
	
	@Test
	public void sinNombre() throws Exception {//Como declarar que se espera una excepcion
		
		Customer customerEjemplo = mock(Customer.class);
		
		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(customerEjemplo); //Cuando se llame al método find se retorna el customer
		
		CustomerReader customerReader = new CustomerReader(entityManager);
		Assertions.assertThrows(Exception.class, () -> {customerReader.findFullName(1L);});
		
		}
	
	@Test
	public void noExiste() throws Exception {//Como declarar que se espera una excepcion

		EntityManager entityManager = mock(EntityManager.class);
		when(entityManager.find(Customer.class,1L)).thenReturn(null); //Cuando se llame al método find se retorna el customer
		
		CustomerReader customerReader = new CustomerReader(entityManager);
		Assertions.assertThrows(Exception.class, () -> {customerReader.findFullName(1L);});
				
		}
}
