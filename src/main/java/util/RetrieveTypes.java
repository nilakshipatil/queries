package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class RetrieveTypes {
public static SessionFactory sf = HibernateUtil.getSessionfactory();
	public static void main(String[] args) {
		//insert();
		getdata();
		sf.close();
		
	}
	public static void getdata() {
		Session session = null;

		try {
			session = sf.openSession();
			Query<Invoice> query  =session.createQuery("select i.invno, i.amount from Invoice i");
			ScrollableResults sr = query.scroll(ScrollMode.FORWARD_ONLY);
			while(sr.next())
			{
				System.out.println(sr.get(0) + " \t\t" + sr.get(1));
			}
		} catch (Exception e) {

			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
	public static void list() {
		Session session = null;

		try {
			session = sf.openSession();
			Query<Invoice> query  =session.createQuery("select i from Invoice i");
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
	

}
