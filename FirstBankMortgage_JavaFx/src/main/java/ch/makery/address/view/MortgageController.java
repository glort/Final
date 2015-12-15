package ch.makery.address.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.UUID;

import org.apache.poi.ss.formula.functions.FinanceLib;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;


public class MortgageController {
	
	public ComboBox TERM;
	public Label PAYMENT;
	public TextField INCOME;
	public TextField EXPENSES;
	public TextField CREDITSCORE;
	public TextField HOUSECOST;


    // Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public MortgageController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	
    	TERM.getItems().addAll(
    		"15 Years",
    		"30 Years"
    	);
    	
    	

    }

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    public void handleCalculate(){
    	double income = Double.parseDouble(INCOME.getText()); 
    	double monthlyIncome = income/12;
    	double expenses = Double.parseDouble(EXPENSES.getText());
    	double monthlyExpenses = expenses;
    	int creditScore = Integer.parseInt(CREDITSCORE.getText());
    	double houseCost = Double.parseDouble(HOUSECOST.getText());
    	double rate = 0.01*RateDAL.getRate(creditScore);
    	int term = 0;
    	if (TERM.getValue() == "15 Years")
    		term = 15;
    	else
    		term = 30;
    	double payment = MortgageController.calcPayment(rate, houseCost, term);
    	
    	if (creditScore < 600)
    		PAYMENT.setText("Credit Score Too Low");
    	
    	else if (payment > .36*monthlyIncome||payment > .28*(monthlyIncome + monthlyExpenses)|| payment > (monthlyIncome - monthlyExpenses)){
    		//Added stipulation that payment must be less than monthly income minus monthly expense.  It just makes sense.
    		PAYMENT.setText("House Cost Too High");
    	}
    	else 
    		PAYMENT.setText("$" + payment);
    	
    		
    	
    }
    
    public static double calcPayment(double rt, double cst, int trm){
    	double payment = 0;
    	DecimalFormat df = new DecimalFormat("#.##");      
    	

    	
    	double rate = rt/12;
    	double cost = cst;
    	double term = trm*12;
    	
    	payment = Math.abs(FinanceLib.pmt(rate, term, cost, 0, false));
    	payment = Double.valueOf(df.format(payment));
    	return payment;
    }
    
   
}
