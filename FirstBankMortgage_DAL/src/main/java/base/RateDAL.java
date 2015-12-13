package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.RateDomainModel;
import util.HibernateUtil;


public class RateDAL {


	public static double getRate(int GivenCreditScore) {
		double interestRate = 100;
		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
			
		ArrayList<RateDomainModel> rts = new ArrayList<RateDomainModel>();

		try {
			tx = session.beginTransaction();	

			List rates = session.createQuery("FROM RateDomainModel").list();
			for (Iterator iterator = rates.iterator(); iterator.hasNext();) {
				RateDomainModel rt = (RateDomainModel) iterator.next();
				rts.add(rt);

			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		for (RateDomainModel rdm: rts){
			if (GivenCreditScore >= rdm.getMinCreditScore()){
				if (interestRate > rdm.getInterestRate()){
					interestRate = rdm.getInterestRate();
				}
			}
		}



		//FinalExam - obviously change the return value
		return interestRate;
	}

}