package es.upm.grise.profundizacion.mocking_ejercicio_2;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

/*@SuppressWarnings("deprecation")
@RunWith(MockitoJUnitRunner.class)*/
public class SmokeTest {
	
	  CustomerReader customerReader; // class to be tested EntityManager
	  EntityManager entityManager; // dependency 
	
	  @Before 
	  public void setup() { 
		  entityManager = mock(EntityManager.class);
		  customerReader = new CustomerReader(entityManager); 
	  }
	 
	/*
	 * @Mock EntityManager entityManager; // dependency
	 * 
	 * @InjectMocks CustomerReader customerReader; // class to be tested
	 * EntityManager
	 */
	@Test
	public void elClienteTieneDosApellidos() throws Exception {
		Customer customerDosApe = new Customer();
		customerDosApe.setFirstName("Susan");
		customerDosApe.setLastName1("Ivanova");
		customerDosApe.setLastName2("Ape2");

		System.out.print(customerDosApe.getFirstName());
		
		when(entityManager.find(1L)).thenReturn(customerDosApe);

		String fullName = customerReader.findFullName(1L);
		assertEquals("Susan Ivanova Ape2", fullName);
	}
	
	@Test
	public void elClienteTieneSoloPrimerApellido() throws Exception {
		Customer customerUnApe = new Customer();
		customerUnApe.setFirstName("Susan");
		customerUnApe.setLastName1("Ivanova");
		
		when(entityManager.find(1L)).thenReturn(customerUnApe);

		String fullName = customerReader.findFullName(1L);
		assertEquals("Susan Ivanova ", fullName);
	}
	
	@Test
	(expected = Exception.class)
	public void elClienteNoTienePrimerApellido() throws Exception {
		//Customer customerSinPrimerApe = new Customer();
		//customerSinPrimerApe.setFirstName("Susan");
		
		//doThrow(new Exception("Customer first name empty")).when(entityManager.find(1L)).find(1L);
		when(entityManager.find(1L)).thenThrow(new Exception("Customer last name 1 empty"));

		customerReader.findFullName(1L);
	}

	@Test
	(expected = Exception.class)
	public void elClienteNoTieneNombre() throws Exception {

		when(entityManager.find(1L)).thenThrow(new Exception("Customer first name empty"));

		customerReader.findFullName(1L);
	}

	@Test
	(expected = Exception.class)
	public void elClienteNoExiste() throws Exception {

		when(entityManager.find(1L)).thenThrow(new Exception("Customer not found"));

		customerReader.findFullName(1L);
	}
	
	
}
