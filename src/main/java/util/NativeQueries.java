package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.*;;



public class NativeQueries {
public static SessionFactory sf = HibernateUtil.getSessionfactory();
	public static void main(String[] args) {
		query1();
	
		sf.close();
		
	}
	
	public static void query1() {
		Session session = null;

		try {
			session = sf.openSession();
			NativeQuery query = session.createNativeQuery("select * from invoice");
			List<Object[]> list = query.list();
			for (Object[] objarr : list) {
				System.out.println(Arrays.toString(objarr));
			}
		} catch (Exception e) {

			System.out.println("Exception " + e);
		} finally {
			session.close();
		}
	}
	
	
	}

