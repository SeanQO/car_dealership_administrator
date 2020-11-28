package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import customException.EmptyDataException;

class CompanyTest {

	private Company company;
	private Admin admin;
	
	public void setup1() {
		company = new Company("salesCars", 1231, admin);
	}
	
	public void setup2() {
		company = new Company("salesCars", 1231, admin);
		company.	}
	
	@Test
	void test() {
		setup2();
		assertEquals(1,company.getDealers().size());
	}

}
