package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.*;;



public class CritQueries {
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
			List<Invoice> list = session.
					createCriteria(Invoice.class)
					.add(Restrictions.eq("company", "IBM")).list();
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
			Criteria q = session.createCriteria(Invoice.class);
			q.add(Restrictions.between("amount", 1.00, 30.30));
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
