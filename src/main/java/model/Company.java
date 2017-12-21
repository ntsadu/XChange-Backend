package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="company")
public class Company implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="companyID")
	private int companyId;
	
	@Column(name="exchange")
	private String exchange;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="name")
	private String name;

	@Column(name="sector")
	private String sector;
	
	@Column(name="industry")
	private String industry;

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getExchange() {
		return exchange;
	}

	public void setExchange(String exchange) {
		this.exchange = exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", exchange=" + exchange + ", symbol=" + symbol + ", name=" + name
				+ ", sector=" + sector + ", industry=" + industry + "]";
	}
}