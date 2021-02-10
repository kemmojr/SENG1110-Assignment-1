//Newcastle University
//SENG1110
//Authors: Tim Kemmis & Lee Whittaker
//Assignment 1 2019

public class Product
{
	private String name = "";
	private double price = 0;
	private double weight = 0;
	private int quantity = 0;

	public void setName(String s){
		s.toLowerCase(); //Sets name to lowerCase
		name = s; //sets name to the string entered
	}

	public String getName(){
		return name;
	}

	public void setPrice(double p){
		price = p; //sets price to the double entered
	}

	public double getPrice(){
		return price;
	}

	public void setWeight(double w){
		weight = w; //sets weight to the double entered
	}

	public double getWeight(){
		return weight;
	}

	public void setQuantity(int q){
		quantity = q; //sets quantity to the int entered
	}

	public int getQuantity(){
		return quantity; //gets the quantity
	}

	public void delete(){ //method to clear product data
		name = "";
		price = 0;
		weight = 0;
		quantity = 0;
	}

	@Override
	public String toString() {
		//an override of the toString method built into Java. This means we can change the formatting of how we print the product
		if (name.equals(""))
		{
			return "";
		}
		else {
			return "Product{" +
					"name: '" + name + "'" +
					", price:" + "$" + price +
					", weight: " + weight + "kg" +
					", quantity: " + quantity +
					"}\n";
		}
	}

}
