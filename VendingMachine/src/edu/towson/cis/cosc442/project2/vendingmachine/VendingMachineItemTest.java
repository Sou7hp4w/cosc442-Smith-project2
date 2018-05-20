/**
 * 
 */
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jeffrey
 *
 */
public class VendingMachineItemTest {

	/** Declaring test objects for (@link VendingMachineIten) */
	VendingMachineItem item1, item2;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		item1 = new VendingMachineItem("snacc", 1.50);
	}


	/**
	 * Testing for proper creation of object
	 * 
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public void testVendingMachineItem() {
		assertEquals("snacc", item1.getName());
		assertEquals(1.50, item1.getPrice(), .0001);
	}

	/**
	 * Testing for thrown exception
	 * 
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#VendingMachineItem(java.lang.String, double)}.
	 */
	@Test
	public void testVendingMachineItem2() {
		try {
			item2 = new VendingMachineItem("item2", -1.30);
		}catch(Exception e) {
			String expMessage = "Price cannot be less than zero";
			assertEquals(expMessage, e.getMessage());
		}
	}
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getName()}.
	 * 
	 */
	@Test
	public void testGetName() {
		assertEquals("snacc", item1.getName());
	}

	/**
	 * Test method for 
	 * {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem#getPrice()}.
	 */
	@Test
	public void testGetPrice() {
		assertEquals(1.50, item1.getPrice(), .0001);
	}

	/**
	 * @throws java.lang.Exception
	 * Empties test variables after test
	 */
	@After
	public void tearDown() throws Exception {
		item1 = null;
	}
}
