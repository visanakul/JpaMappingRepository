package com.mapping.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Student {

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Id
	private Integer roll;
	private String name;
	private String mobile;
	@OneToOne(mappedBy = "std",fetch = FetchType.EAGER)
	private Result result;

	public String getData() {
		return "Student [roll=" + roll + ", name=" + name + ", mobile=" + mobile + ", result=" + result.getSub1() + ","
				+ result.getSub2() + "," + result.getSub3() + "," + result.getPer() + "]";
	}

}
