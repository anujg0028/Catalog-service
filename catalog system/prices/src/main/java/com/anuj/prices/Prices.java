package com.anuj.prices;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="price")
public class Prices {
	
	@Id
	@Column(name="PID")
	private int pid;
	
	@Column(name="PRICE")
	private int price;
	
	@Column(name="MKD")
	private String mkd;
	
	@Column(name="AVALABILITY")
	private String available;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getMkd() {
		return mkd;
	}

	public void setMkd(String mkd) {
		this.mkd = mkd;
	}

	public String getAvailable() {
		return available;
	}

	public void setAvailable(String available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Prices [pid=" + pid + ", price=" + price + ", mkd=" + mkd + ", available=" + available + "]";
	}
	
	
	
	
	
	
	
}