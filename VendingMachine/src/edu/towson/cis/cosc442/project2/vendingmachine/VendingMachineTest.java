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
public class VendingMachineTest {

	/**Test object for vending machine class tests	 */
	VendingMachine machine1;
	VendingMachineItem item1 = new VendingMachineItem("Cookie", 1.25);
	VendingMachineItem item2 = new VendingMachineItem("Snacc", 1.00);
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		machine1 = new VendingMachine();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		machine1 = null;	
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testAddItem() {
		machine1.addItem(item1, "B");
		assertEquals(item1.toString(), machine1.getItem("B").toString());
		// proves item was added to correct spot if retrieved item matches input item
	}
	
	/**
	 * Testing thrown exception condition 1
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testAddItem2() {
		machine1.addItem(item1, "B");
		try {
			machine1.addItem(item2,  "B");
			
			fail();	// this should not be executed, if it is we missed exception
		}catch(Exception e) {
			String expMessage = "Slot B already occupied";
			assertEquals(expMessage, e.getMessage());
		}
	}
	
	/**
	 * Testing thrown exception condtion 2
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#addItem(edu.towson.cis.cosc442.project2.vendingmachine.VendingMachineItem, java.lang.String)}.
	 */
	@Test
	public void testAddItem3() {
		//machine1.addItem(item1, "B");
		try {
			machine1.addItem(item2, "G");
			
			fail(); // should not be executed, if it is we missed exception
		}catch(Exception e) {
			String expectedMessage = "Invalid code for vending machine item";
			assertEquals(expectedMessage, e.getMessage());
		}
		// proves item was added to correct spot if retrieved item matches input item
	}
	
	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getItem(java.lang.String)}.
	 *
	@Test
	public void testGetItem() {
		fail("Not yet implemented");
	}*/

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#removeItem(java.lang.String)}.
	 */
	@Test
	public void testRemoveItem() {
		machine1.addItem(item1,  "B");
		assertEquals(item1.toString(), machine1.removeItem("B").toString());
		
		// if item removed equals item that should be in machine, pass
		// else should fail
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#insertMoney(double)}.
	 */
	@Test
	public void testInsertMoney() {
		double oldBal = machine1.balance;
		machine1.insertMoney(2.00);
		assertEquals((2.00 + oldBal), (machine1.balance + oldBal), .0001);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		assertEquals(machine1.balance, machine1.getBalance(), .0001);
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#makePurchase(java.lang.String)}.
	 */
	@Test
	public void testMakePurchase() {
		machine1.addItem(item1, "B");
		machine1.insertMoney(2.00);
		assertEquals(true, machine1.makePurchase("B"));
		assertEquals(.75, machine1.getBalance(), .001);
		assertEquals(null, machine1.getItem("B"));
	}

	/**
	 * Test method for {@link edu.towson.cis.cosc442.project2.vendingmachine.VendingMachine#returnChange()}.
	 */
	@Test
	public void testReturnChange() {
		machine1.addItem(item1, "B");
		machine1.insertMoney(2.00);
		machine1.makePurchase("B");
		assertEquals(.75, machine1.returnChange(), .001);
		assertEquals(0, machine1.getBalance(), .001);
	}

}
