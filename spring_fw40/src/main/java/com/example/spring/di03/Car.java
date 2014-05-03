package com.example.spring.di03;

public class Car {
	private String name;
	private String color;
	private int price;

	public Car(String name) {
		this.name = name;
	}

	public Car(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", price=" + price
				+ "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
