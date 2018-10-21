package com.revature.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ERS_REIMBURSEMENTS")
public class Reimbursement {
	@Id
	@Column(name = "R_ID")
	String id = "auto.nextval";
	
	@Column(name = "R_AMOUNT")
	double ammount;
	
	@Column(name = "R_DESCRIPTION")
	String description;
	
	@Column(name = "R_RECEIPT")
	byte[] Receipt;
	
	@Column(name = "R_SUBMITTED")
	String submitted = "CURRENT_TIMESTAMP";
	
	@Column(name = "R_RESOLVED")
	String resolved;
	
	@Column(name = "U_ID_AUTHOR")
	Integer author;
	
	@Column(name = "U_ID_RESOLVER")
	Integer resolver;
	
	@Column(name = "RT_TYPE")
	Integer type = 0;
	
	@Column(name = "RT_STATUS")
	Integer status = 0;

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", ammount=" + ammount + ", description=" + description + ", Receipt="
				+ Arrays.toString(Receipt) + ", submitted=" + submitted + ", resolved=" + resolved + ", author="
				+ author + ", resolver=" + resolver + ", type=" + type + ", status=" + status + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getAmmount() {
		return ammount;
	}

	public void setAmmount(double ammount) {
		this.ammount = ammount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getReceipt() {
		return Receipt;
	}

	public void setReceipt(byte[] receipt) {
		Receipt = receipt;
	}

	public String getSubmitted() {
		return submitted;
	}

	public void setSubmitted(String submitted) {
		this.submitted = submitted;
	}

	public String getResolved() {
		return resolved;
	}

	public void setResolved(String resolved) {
		this.resolved = resolved;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getResolver() {
		return resolver;
	}

	public void setResolver(int resolver) {
		this.resolver = resolver;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
