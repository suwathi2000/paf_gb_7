package Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Funding {

	private int funding_id;
	private String name;
	private String description;
	private int loyalty;
	private String date_time;

	public Funding() {
	}

	public Funding(int funding_id) {
		this.funding_id = funding_id;
	}

	public Funding(int funding_id, String name, String description, int loyalty, String date_time) {
		this.funding_id = funding_id;
		this.name = name;
		this.description = description;
		this.loyalty = loyalty;
		this.date_time = date_time;
	}

	public int getFunding_id() {
		return funding_id;
	}

	public void setFunding_id(int funding_id) {
		this.funding_id = funding_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getLoyalty() {
		return loyalty;
	}

	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}

	public String getDate_time() {
		return date_time;
	}

	public void setDate_time(String date_time) {
		this.date_time = date_time;
	}

}