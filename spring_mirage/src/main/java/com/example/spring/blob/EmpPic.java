package com.example.spring.blob;

import java.util.Arrays;

import jp.sf.amateras.mirage.annotation.PrimaryKey;
import jp.sf.amateras.mirage.annotation.PrimaryKey.GenerationType;

public class EmpPic {
	@PrimaryKey(generationType = GenerationType.APPLICATION)
	private int empNo;

	private byte[] empPic;

	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public byte[] getEmpPic() {
		return empPic;
	}

	public void setEmpPic(byte[] empPic) {
		this.empPic = empPic;
	}

	@Override
	public String toString() {
		return "EmpPic [empNo=" + empNo + ", empPic=" + Arrays.toString(empPic)
				+ "]";
	}
}
