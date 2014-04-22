package com.example.spring.sample04;

public class Tire {
	String size;

	public Tire(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Tire [size=" + size + "]";
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
