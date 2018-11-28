package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.*;;



public class Queries {
public static SessionFactory sf = HibernateUtil.getSessionfactory();
	public static void main(String[] args) {
		query1();
		query2();
		sf.close();
		
	}
	
	public static void query1() {
		Session session = null;

		try {
			session = sf.openSession();
			//Query<Invoice> query  =session..createQuery("select i from Invoice i where i.company = :comp");
			//query.setString("comp" , "Oracle");
			Query<Invoice> query  = session.createQuery
					("select i from Invoice i where i.amount "
							+ "between :min and :max");
		
			query.setDouble("min", 0.01);
			query.setDouble("max", 1.31);
			List<Invoice> list = query.list();
			for (Invoice invoice : list) {
				System.out.println(invoice);
				
			}
		} catch (Exception e) {

			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
	
	public static void query2() {
		Session session = null;

		try {
			session = sf.openSession();
			Query q = session.getNamedQuery("myq" );
			q.setParameter("min", 1.00);
			q.setParameter("max", 30.300);
			List<Invoice> list = q.list();
			for (Invoice invoice : list) {
				System.out.println(invoice);
				
			}
		} catch (Exception e) {

			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
}
