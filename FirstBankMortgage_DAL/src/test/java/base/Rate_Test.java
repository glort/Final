package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Rate_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRate1() {
		assertTrue(RateDAL.getRate(601) == 5);
		System.out.println(RateDAL.getRate(601));
	}
	
	@Test
	public void testRate2() {
		assertTrue(RateDAL.getRate(651) == 4.5);
		System.out.println(RateDAL.getRate(651));
	}
	
	@Test
	public void testRate3() {
		assertTrue(RateDAL.getRate(701) == 4);
		System.out.println(RateDAL.getRate(701));
	}
	
	@Test
	public void testRate4() {
		assertTrue(RateDAL.getRate(751) == 3.75);
		System.out.println(RateDAL.getRate(751));
	}
	
	@Test
	public void testRate5() {
		assertTrue(RateDAL.getRate(801) == 3.5);
		System.out.println(RateDAL.getRate(801));
	}
	
	@Test
	public void testRate6() {
		assertTrue(RateDAL.getRate(600) == 5);
	
		System.out.println(RateDAL.getRate(600));
	}

}
