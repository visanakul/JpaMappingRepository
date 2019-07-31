package com.mapping.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Result {
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSub1() {
		return sub1;
	}

	public void setSub1(Integer sub1) {
		this.sub1 = sub1;
	}

	public Integer getSub2() {
		return sub2;
	}

	public void setSub2(Integer sub2) {
		this.sub2 = sub2;
	}

	public Integer getSub3() {
		return sub3;
	}

	public void setSub3(Integer sub3) {
		this.sub3 = sub3;
	}

	public Student getStd() {
		return std;
	}

	public void setStd(Student std) {
		this.std = std;
	}

	@Id
	private Integer id;
	private Integer sub1;
	private Integer sub2;
	private Integer sub3;
	private Integer total;
	private Double per;
	@OneToOne
	@JoinColumn(name = "roll")
	private Student std;

	public void findResult() {
		total = sub1 + sub2 + sub3;
		setPer((double) total / 3);
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}

	public String getData() {
		return "Result [id=" + id + ", sub1=" + sub1 + ", sub2=" + sub2 + ", sub3=" + sub3 + ", total=" + total
				+ ", per=" + per + ", std=" + std.getRoll() +","+std.getName()+","+std.getMobile() +"]";
	}
	
	
}
