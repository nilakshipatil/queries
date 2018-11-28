package util;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name="myq" , query="select i from Invoice i where i.amount "
							+ "between :min and :max")
public class Invoice {
	@Id
	private int invno;
	private Date idate;
	private String company;
	private String type;
	private double amount;
	public int getInvno() {
		return invno;
	}
	public void setInvno(int invno) {
		this.invno = invno;
	}
	public Date getIdate() {
		return idate;
	}
	public void setIdate(Date idate) {
		this.idate = idate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Invoice [invno=" + invno + ", idate=" + idate + ", company=" + company + ", type=" + type + ", amount="
				+ amount + "]";
	}
	
}
