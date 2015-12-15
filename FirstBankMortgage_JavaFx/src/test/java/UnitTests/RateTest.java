package UnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import base.RateDAL;
import ch.makery.address.view.MortgageController;

public class RateTest {

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
	public void test() {
		double income = 150000;
    	double monthlyIncome = income/12;
    	double expenses = 8000;
    	double monthlyExpenses = expenses;
    	int creditScore = 800;
    	double houseCost = 300000;
    	double rate = .01*RateDAL.getRate(creditScore);
    	
    	int term = 30;
    	
    	double payment = MortgageController.calcPayment(rate, houseCost, term);
    	System.out.println();
    	System.out.println(payment);
    	
    	if (creditScore < 600){
    		System.out.println("Credit Score Too Low");
    		fail();
    	}
    	else if (payment > 0.36*monthlyIncome||payment > 0.28*(monthlyIncome + monthlyExpenses)|| payment > (monthlyIncome - monthlyExpenses)){
    		System.out.println("House Cost Too High");
    		fail();
    	}
    	else {
    		System.out.println("$" + payment);
    		assertTrue(1 == 1);//pass
    	}
    	
    	
    		
    	
	}

}
