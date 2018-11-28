package util;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.QueryProducer;

public class StatelessDemo {
	public static SessionFactory sf = HibernateUtil.getSessionfactory();
	
	public static void main(String[] args) {
		list();
		insert();

	}
	public static void list() {
		StatelessSession session = null;
		Transaction tx = null;
		try {
			session = sf.openStatelessSession();
			tx = session.beginTransaction();
			
			List<Invoice> list = session.createQuery("select i from Invoice i where i.invno < 40").list();
			for (Invoice invoice : list) {
				System.out.println(invoice);
			//  modifications would not be reflected 
				invoice.setIdate(new Date());
			}
			tx.commit();
		} catch (Exception e) {

			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
	
	public static void insert() {
		StatelessSession session = null;
		Transaction tx = null;
		try {
			session = sf.openStatelessSession();
			tx = session.beginTransaction();
			Invoice i = new Invoice();
			i.setInvno(0);i.setCompany("XXXXXX" );
			session.insert(i);
			i.setAmount(2222);
			tx.commit();
		} catch (Exception e) {

			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
}
