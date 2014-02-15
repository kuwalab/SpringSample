package com.example.spring;

import jp.sf.amateras.mirage.annotation.PrimaryKey;
import jp.sf.amateras.mirage.annotation.PrimaryKey.GenerationType;

public class Emp {
	@PrimaryKey(generationType = GenerationType.APPLICATION)
	private int empNo;
	private String name;
	private int age;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Test [emp_no=" + empNo + ", name=" + name + ", age=" + age
				+ "]";
	}

}
