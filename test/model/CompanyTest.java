package model;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import customException.DoubleRegistrationException;
import customException.EmptyDataException;

public class CompanyTest {

	private Company company;
	private Admin admin;
	private Dealer dealer;
	
	public void setup1() {
		company = new Company("concesionario la 9na", 123456789, 
				new Admin("Carlos", "Perea", "carlosPera@gmail.com", 123456987, 374456985, 8000000));
		company.addCarDealer(new CarDealer("testDealer", admin, "calle 2 #23-2"));
		
	}
	
	public void setup2() throws DoubleRegistrationException, EmptyDataException {
		company = new Company("car inc", 1235, admin);
		Vehicle newV = new Vehicle("1234", 342, "mercedez", 342, 234, false, 4);
		dealer.addVehicle(newV);
	}
	
	public void setup3() {
		company = new Company("car inc", 1235, admin);
		company.addCarDealer(new CarDealer("one dealer", admin, "calle 2 #23-2"));
	}
	
	@Test
	public void test1() {
		setup1();
		
		assertEquals(1, company.getDealers().size(), "the new dealer was not registered");
		assertEquals("testDealer", company.getDealers().get(0).getName(), "threre was a registrarion but the desired one");
		
	}

	@Test
	public void test2() throws DoubleRegistrationException, EmptyDataException {
		setup2();
		assertEquals(1,dealer.getVehicles().size());
	}
	
	@Test
	public void test3() throws DoubleRegistrationException, EmptyDataException {
		setup3();
		assertEquals(1,company.getDealers().size());
	}
}
