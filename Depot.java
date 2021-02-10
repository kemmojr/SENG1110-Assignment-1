//Newcastle University
//SENG1110
//Authors: Tim Kemmis & Lee Whittaker
//Assignment 1 2019

public class Depot
{
	private String name;
	private int capacity = 0;
	private Product product1 = new Product();
	private Product product2 = new Product();
	private Product product3 = new Product();

	public void setName(String s){//sets depot name
		s.toLowerCase();
		name = s;
	}

	public String getName(){ //gets depot name
		return name;
	}

	public int getCapacity(){ //returns the capacity of the depot
		return capacity;
	}

	public void setProduct(String s, double p, double w, int q){
		//This method checks the current products to see if they are empty and then adds the entered properties to the first empty product
		//and increases the capacity by 1
		if (product1.getName().equalsIgnoreCase("")){
			product1.setName(s);
			product1.setPrice(p);
			product1.setWeight(w);
			product1.setQuantity(q);
			capacity++;
		} else if (product2.getName().equalsIgnoreCase("")){
			product2.setName(s);
			product2.setPrice(p);
			product2.setWeight(w);
			product2.setQuantity(q);
			capacity++;
		} else if (product3.getName().equalsIgnoreCase("")){
			product3.setName(s);
			product3.setPrice(p);
			product3.setWeight(w);
			product3.setQuantity(q);
			capacity++;
		} else {
			System.out.println("There are already 3 products, you cannot create anymore as 3 is the maximum");
		}
	}

	public String getProductName(int i){ //returns the product name of the product that corresponds to the number entered
		String out = "";
		switch (i){
			case 1: out += product1.getName(); break;
			case 2: out += product2.getName(); break;
			case 3: out += product3.getName(); break;
		}
		return out;
	}

	public void deleteProduct(String name) {
		//This sets all the values of the named product to empty by calling the delete method in product
		if (name.equalsIgnoreCase(product1.getName())) {
			product1.delete();
			capacity--;
		} else if (name.equalsIgnoreCase(product2.getName())) {
			product2.delete();
			capacity--;
		} else if (name.equalsIgnoreCase(product3.getName())) {
			product3.delete();
			capacity--;
		}
	}

	public void deleteAllProducts() {
	//This sets all the values of the every product to empty using the delete method in product and sets capacity to 0
		product1.delete();
		product2.delete();
		product3.delete();
		capacity = 0;
	}

	public double getProductPriceTotal(){ // add total quantity * price for each product
		//This adds the values of all the products multiplied by their quantity
		double out = 0.0;
		out += product1.getPrice()*product1.getQuantity() + product2.getPrice()*product2.getQuantity() + product3.getPrice()*product3.getQuantity();
		return out;
	}

	public double getProductPrice(int product){//returns the price for a specific product
		double out = 0;
		switch (product){
			case 1: out = product1.getPrice(); break;
			case 2: out = product2.getPrice(); break;
			case 3: out = product3.getPrice(); break;
		}
		return out;
	}

	public double getProductWeight(int product){//returns the weight for a specific product
		double out = 0;
		switch (product){
			case 1: out = product1.getWeight(); break;
			case 2: out = product2.getWeight(); break;
			case 3: out = product3.getWeight(); break;
		}
		return out;
	}

	public String listProduct(int prodNum){//Returns all the values of a given product as a string
		String out = "";
		switch (prodNum){
			case 1: out = product1.toString(); break;
			case 2: out = product2.toString(); break;
			case 3: out = product3.toString(); break;
		}
		return out;
	}

	public String listProducts(){//lists all the depots products as a string. If the depot is empty then that will be what is returned
		String out = "";
		if (capacity==0){
			out += "This depot is empty";
		}
		else {
			out += product1.toString();
			out += product2.toString();
			out += product3.toString();
		}
		return out;
	}

	public int checkProductMatch(String name){//checks if the given name matches any of the current product names
		//if the name matches the number corresponding to the product is returned. If it doesnt't match then 0 is returned
		int out;
		if (name.equalsIgnoreCase(product1.getName())){
				out = 1;
		} else if (name.equalsIgnoreCase(product2.getName())){
				out = 2;
		} else if (name.equalsIgnoreCase(product3.getName())){
				out = 3;
		} else {
				out = 0;
		}
		return out;
	}

	@Override
	public String toString() {
		//an override of the toString method built into Java. This means we can change the formatting of how we print the depot
		return "Depot {" +
				"name = '" + name + "'" +
				"capacity = " + capacity + "/3" +
				"}\n";

	}
}
