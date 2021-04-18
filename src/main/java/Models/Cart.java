package Models;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Cart {

	private int cart_id;
	private double discount;
	private String sub_total;
	private int project_project_id;

	public Cart() {
	}

	public Cart(int cart_id) {
		this.cart_id = cart_id;
	}

	public Cart(int cart_id, double discount, String sub_total, int project_project_id) {
		this.cart_id = cart_id;
		this.discount = discount;
		this.sub_total = sub_total;
		this.project_project_id = project_project_id;
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public String getSub_total() {
		return sub_total;
	}

	public void setSub_total(String sub_total) {
		this.sub_total = sub_total;
	}

	public int getProject_project_id() {
		return project_project_id;
	}

	public void setProject_project_id(int project_project_id) {
		this.project_project_id = project_project_id;
	}

}