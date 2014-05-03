package com.example.spring.di04;

public class Car {
	private String name;
	private String color;
	private int price;
	private Tire tire;

	public Car(String name) {
		super();
		this.name = name;
	}

	public Car(String name, Tire tire) {
		this.name = name;
		this.tire = tire;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", price=" + price
				+ ", tire=" + tire + "]";
	}

	public Tire getTire() {
		return tire;
	}

	public void setTire(Tire tire) {
		this.tire = tire;
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
