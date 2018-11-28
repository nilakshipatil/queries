package util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class InsertClient {
public static SessionFactory sf = HibernateUtil.getSessionfactory();
	public static void main(String[] args) {
		//insert();
		list();
		sf.close();
		
	}
	public static void list() {
		Session session = null;

		try {
			session = sf.openSession();
			Query<Invoice> query  =session.createQuery("select i from Invoice i");
			query.setMaxResults(5);
			query.setFirstResult(2000);
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
	public static void insert() {
		List<String> comps = new ArrayList<String>();
		comps.add("IBM");
		comps.add("Oracle");
		comps.add("Bea");
		comps.add("Amazon");
		
		
		Session session = null;
		Transaction tx = null;
		try {
			session = sf.openSession();
			tx = session.beginTransaction();
			for(int i = 1;i<3000;i++){
				Invoice inv = new Invoice();
				inv.setInvno(i);
				inv.setCompany(comps.get(i % 4));
				inv.setIdate(new Date());
				if ((i % 2)==0)
						inv.setType("Man");
				else
						inv.setType("Auto");
				inv.setAmount(i * Math.random());
				session.save(inv);
				if (( i % 1000==0))
				{
					session.flush();
				}
			}
			
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}

}
