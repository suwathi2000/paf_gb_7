package Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Purchase {

	private int purchase_id;
	private double discount;
	private String date_time;
	private int user_user_id;
	private int product_id;
	private int cart_id;

	public Purchase() {
	}

	public Purchase(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public Purchase(int purchase_id, double discount, String date_time, int user_user_id,int product_id,int cart_id) {
		this.purchase_id = purchase_id;
		this.discount = discount;
		this.date_time = date_time;
		this.user_user_id = user_user_id;
		this.product_id = product_id;
		this.cart_id=cart_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public int getPurchase_id() {
		return purchase_id;
	}

	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

	public int getUser_user_id() {
		return user_user_id;
	}

	public void setUser_user_id(int user_user_id) {
		this.user_user_id = user_user_id;
	}

}