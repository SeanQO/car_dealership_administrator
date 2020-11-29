package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customException.DoubleRegistrationException;
import customException.EmptyDataException;

public class CompanyTest {

	private Company company;
	private Admin admin;
	
	public void setup1() {
		company = new Company("car inc", 1235, admin);
	}
	
	public void setup2() throws DoubleRegistrationException, EmptyDataException {
		company = new Company("car inc", 1235, admin);
		company.addVehicle("1234", 1234, "mercedez", 214, "aspirado", 200, 0, false);
	}
	
	public void setup3() {
		company = new Company("car inc", 1235, admin);
		company.addCarDealer(new CarDealer("one dealer", admin, "calle 2 #23-2"));
	}
	@Test
	public void test1() {
		setup1();
		assertEquals(0,company.getVehicles().size());
	}

	@Test
	public void test2() throws DoubleRegistrationException, EmptyDataException {
		setup2();
		assertEquals(1,company.getVehicles().size());
	}
	
	@Test
	public void test3() throws DoubleRegistrationException, EmptyDataException {
		setup3();
		assertEquals(1,company.getDealers().size());
	}
}
