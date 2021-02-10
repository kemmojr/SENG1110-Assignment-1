//Newcastle University
//SENG1110
//Authors: Tim Kemmis & Lee Whittaker
//Assignment 1 2019


//things to test
//add two products and delete the first one
//see how the program behaves when editing/printing stuff
//make sure program does all the things in the marking criteria
import java.util.*;

public class Interface {
    private int depotNumber = 0; //number of depots
    private int capacity = 2;
    private Depot d1 = new Depot();
    private Depot d2 = new Depot();


    public void setDepot(int depot, String s) {
        switch (depot) {
            case 1:
                d1.setName(s);
                break;
            case 2:
                d2.setName(s);
                break;
        }
        depotNumber++;
    }
    //returns the string name of the depot
    public String getDepot(int depot){
        String out = "";
        switch (depot) {
            case 1:
                out += d1.getName();
                break;
            case 2:
                out += d2.getName();
                break;
        }
        return out;
    }
    //returns what number the depot is
    public int getDepotNumber(){
        return depotNumber;
    }

    public void makeProduct(int depot, String name, double price, double weight, int quantity){
        switch (depot){
            case 1: d1.setProduct(name, price, weight, quantity); break;
            case 2: d2.setProduct(name, price, weight, quantity); break;
        }
    }
    public int getDepotCapacity(int depot){
        int out = 0;
        switch (depot){
            case 1: out = d1.getCapacity(); break;
            case 2: out = d2.getCapacity(); break;
        }
        return out;
    }
    //returns the list of depots as a string using the overridden toString method
    public String listDepots(int depNum){
        String out = "";
        switch (depNum){
            case 1: out += d1.toString(); break;
            case 2: out += d2.toString(); break;
        }
        return out;
    }
    public String getProductName(int depotNum, int productNum){
        String out = "";
        switch (depotNum){
            case 1: out = d1.getProductName(productNum); break;
            case 2: out = d2.getProductName(productNum); break;
        }
        return out;
    }
    public double getProductPrice(int depot, int prod){
        double out = 0;
        switch (depot){
            case 1: out = d1.getProductPrice(prod); break;
            case 2: out = d2.getProductPrice(prod); break;
        }
        return out;
    }
    public double getProductWeight(int depot, int prod){
        double out = 0;
        switch (depot){
            case 1: out = d1.getProductWeight(prod); break;
            case 2: out = d2.getProductWeight(prod); break;
        }
        return out;
    }

    public String getListedProduct(int depot, int product){//returns the full list for a specific product in a depot
        String out = "";
        switch (depot){
            case 1: switch (product){
                case 1: d1.listProduct(1); break;
                case 2: d1.listProduct(2); break;
                case 3: d1.listProduct(3); break;
                }
            case 2: switch (product){
                case 1: d2.listProduct(1); break;
                case 2: d2.listProduct(2); break;
                case 3: d2.listProduct(3); break;
            }
        }
        return out;
    }

    public int checkProductMatch(int depot, String name){
        int out;
        switch (depot){
            case 1:
                out = d1.checkProductMatch(name); break;
            case 2:
                out = d2.checkProductMatch(name); break;
            default: out = 0; break;
        }
        return out;
    }

    public void deleteProduct(int depotnum, String name) {
        switch (depotnum) {
            case 1:
                d1.deleteProduct(name);
                break;
            case 2:
                d2.deleteProduct(name);
                break;
        }
    }

    public void clearDepot(int depotnumber) {
        switch (depotnumber) {
            case 1:
                d1.setName("");
                d1.deleteAllProducts();
                capacity--;
                break;
            case 2:
                d2.setName("");
                d2.deleteAllProducts();
                capacity--;
                break;
        }
    }

    public boolean isInterfaceEmpty(int d){
        boolean out = false;
        String check = "There are currently no depots";
        if (isDepotEmpty(1)&&isDepotEmpty(2)){
            out = true;
        }
        return out;
    }

    public boolean isInterfaceFull(){
        boolean out = false;
        if (depotNumber>=capacity){
            out = true;
        }
        return out;
    }

    //This returns a boolean value for if the whole depot is empty of all products
    public boolean isDepotEmpty(int depotNum){
        boolean out = false;
        int depotCapacity = 0;
        String p1Name, p2Name, p3Name;

        switch (depotNum){
            case 1:depotCapacity = d1.getCapacity();
                p1Name = d1.getProductName(1);
                p2Name = d1.getProductName(2);
                p3Name = d1.getProductName(3);
                if (depotCapacity==0&&p1Name.equalsIgnoreCase("")&&
                    p2Name.equalsIgnoreCase("")&&
                    p3Name.equalsIgnoreCase("")){ out = true; }break;

            case 2: depotCapacity = d2.getCapacity();
                p1Name = d2.getProductName(1);
                p2Name = d2.getProductName(2);
                p3Name = d2.getProductName(3);
                if (depotCapacity==0&&p1Name.equalsIgnoreCase("")&&
                        p2Name.equalsIgnoreCase("")&&
                        p3Name.equalsIgnoreCase("")){ out = true; }break;
        }
        return out;
    }

    //this method will control the flow of the program
    public void runMainMenu(){
        //This is the main menu of the program and what the user will see when they start the program
        String depotList = "";
        if (!isDepotEmpty(1)&&!isDepotEmpty(2)){
            depotList = listDepots(1);
            depotList += listDepots(2);
        } else if (isDepotEmpty(1)||isDepotEmpty(2)){
            if (isDepotEmpty(1)){
                if (!isDepotEmpty(2)){
                    depotList = listDepots(2);
                } else {
                    depotList = "There are currently no depots";
                }
            } else if (isDepotEmpty(2)){
                if (!isDepotEmpty(1)){
                    depotList = listDepots(1);
                } else {
                    depotList = "There are currently no depots";
                }
            }
        }

        System.out.println("--------------------------------------------------------------------------------\n");
        System.out.println("                     Welcome to the ALCOLWORTHS SUPERMARKETS\n");
        System.out.println("                        What would you like to do today?\n");
        System.out.println("                       You are currently in the main menu");
        System.out.println("                        There are currently "+ depotNumber+ "/2 depots.");
        System.out.println(depotList);
        System.out.println("Add a depot (a) Delete a Depot (d) List current depots (l) Open a depot's menu (o)");
        System.out.println("\n");
        System.out.println("                                        Exit (e)                                ");
        System.out.println("\n");
        System.out.println("--------------------------------------------------------------------------------");
    }
    public void runDepot(int i){
        //This is what the user should see when they enter a depot
        String depotName, productList ;
        int depotCapacity;
        String p1Name, p2Name, p3Name;
        double depotTotal;

        switch (i){
            //case 0: depotName = "There are currently no depots";
            case 1: depotName = d1.getName();
                depotCapacity = d1.getCapacity();
                p1Name = d1.getProductName(1);
                p2Name = d1.getProductName(2);
                p3Name = d1.getProductName(3);
                depotTotal = d1.getProductPriceTotal();

                if (isDepotEmpty(1)){
                    productList = d1.listProducts();
                } else {
                    productList = d1.listProducts();
                }

                break;
            case 2: depotName = d2.getName();
                depotCapacity = d2.getCapacity();
                p1Name = d2.getProductName(1);
                p2Name = d2.getProductName(2);
                p3Name = d2.getProductName(3);
                depotTotal = d2.getProductPriceTotal();

                if (isDepotEmpty(2)){
                    productList = d2.listProducts();
                } else {
                    productList = d2.listProducts();
                }
                break;
            default:
                return; //error
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("\n");
        System.out.println("                             you are currently in depot "+depotName+"\n");
        System.out.println("There are currently "+depotCapacity+" Products in this depot. Products:\n");
        System.out.println(productList);
        System.out.println("The total price for this depot is: "+depotTotal);
        System.out.println("        Add a product (a) Delete a product (d) CheckProducts (c) Exit (e)\n");
        System.out.println("--------------------------------------------------------------------------------");

    }
    public static void main(String args[]){
        Interface intFace = new Interface(); //initialising a new interface variable
        boolean running = true;//This variable will keep the loop running after the initial do
        boolean depotStart = false; //This controls the starting of the depot menu
        int currentDepotNumber = 0; //This controls which depot the program is currently working with
        boolean depotRunning = false; //This controls the running in depot menu
        String input = "";//This variable will be used to do things with the users input
        Scanner console = new Scanner(System.in);//initialising a new scanner object


        do {
            intFace.runMainMenu();
            int numOfDepots = intFace.getDepotNumber();
            input = console.nextLine();
            //A loop for opening a depot
            if(input.equalsIgnoreCase("o")&& numOfDepots >= 1) {

                System.out.println("What Depot would you like to enter?");
                input = console.nextLine();
                if (input.equalsIgnoreCase(intFace.getDepot(1))){
                    depotStart = true;
                    depotRunning = true;
                    currentDepotNumber = 1;
                } else if (input.equalsIgnoreCase(intFace.getDepot(2))){
                    depotStart = true;
                    depotRunning = true;
                    currentDepotNumber = 2;
                }
                //loop here
                while (depotRunning){//Start of the depot loop for all of the depots
                    intFace.runDepot(currentDepotNumber);
                    int capacity = 1;
                    boolean productMade = false;
                    String d1p1 = "", d1p2 = "", d1p3 = "";
                    String d1p1List = "", d1p2List = "", d1p3List = "";
                    String d2p1 = "", d2p2 = "", d2p3 = "";
                    String d2p1List = "", d2p2List = "", d2p3List = "";

                    for (int i = 1; i<=2; i++) {
                        switch (i) {
                            case 1:
                                capacity = intFace.getDepotCapacity(1);
                                switch (capacity) {
                                    case 1:
                                        d1p1 += intFace.getProductName(1, 1);
                                        break;
                                    case 2:
                                        d1p1 += intFace.getProductName(1, 1);
                                        d1p2 += intFace.getProductName(1, 2);
                                        break;
                                    case 3:
                                        d1p1 += intFace.getProductName(1, 1);
                                        d1p2 += intFace.getProductName(1, 2);
                                        d1p3 += intFace.getProductName(1, 3);
                                        break;
                                }
                                capacity = intFace.getDepotCapacity(currentDepotNumber);
                                break;
                            case 2:
                                capacity = intFace.getDepotCapacity(2);
                                switch (capacity) {
                                    case 1:
                                        d2p1 += intFace.getProductName(2, 1);
                                        break;
                                    case 2:
                                        d1p1 += intFace.getProductName(2, 1);
                                        d2p2 += intFace.getProductName(2, 2);
                                        break;
                                    case 3:
                                        d2p1 += intFace.getProductName(2, 1);
                                        d2p2 += intFace.getProductName(2, 2);
                                        d2p3 += intFace.getProductName(2, 3);
                                        break;
                                }
                                capacity = intFace.getDepotCapacity(currentDepotNumber);
                                break;
                        }
                    }


                    input = console.nextLine();
                    if (input.equalsIgnoreCase("a")&&capacity<3){
                        System.out.println("Please enter the name of the product: ");
                        String name = console.nextLine();
                        while (intFace.checkProductMatch(1, name)!=0||intFace.checkProductMatch(2, name)!=0){
                            //A loop for assigning the values of an already existing product if the product is another depot
                            if (currentDepotNumber == 1 && intFace.checkProductMatch(1, name)!=0){
                                System.out.println("A product with that name already exists, in this depot. Please enter a product name again");
                                name = console.nextLine();
                            } else if (currentDepotNumber == 2 && intFace.checkProductMatch(2, name)!=0){
                                System.out.println("A product with that name already exists, in this depot. Please enter a product name again");
                                name = console.nextLine();
                            } else {
                                if (currentDepotNumber == 1 && intFace.checkProductMatch(2, name)>=0){
                                    int oldProdNum = intFace.checkProductMatch(2, name);
                                    System.out.println("A product of that name already exists in another depot, what quantity of that product do you want?");
                                    int quantity = console.nextInt();
                                    if (oldProdNum == 1){//get the price and weight of the existing product and apply them to the new product
                                        double p = intFace.getProductPrice(2, 1);
                                        double w = intFace.getProductWeight(2, 1);
                                        intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                        productMade = true;
                                        break;
                                    } else if (oldProdNum == 2){//get the price and weight of the existing product and apply them to the new product
                                        double p = intFace.getProductPrice(2, 2);
                                        double w = intFace.getProductWeight(2, 2);
                                        intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                        productMade = true;
                                        break;
                                    } else if (oldProdNum == 3){//get the price and weight of the existing product and apply them to the new product
                                        double p = intFace.getProductPrice(2, 3);
                                        double w = intFace.getProductWeight(2, 3);
                                        intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                        productMade = true;
                                        break;
                                    }
                                } else if (currentDepotNumber == 2 && intFace.checkProductMatch(1, name)>=0){
                                    int oldProdNum = intFace.checkProductMatch(1, name);
                                    System.out.println("A product of that name already exists in another depot, what quantity of that product do you want?");
                                    int quantity = console.nextInt();
                                    if (oldProdNum == 1){//get the price and weight of the existing product and apply them to the new product
                                        double p = intFace.getProductPrice(1, 1);
                                        double w = intFace.getProductWeight(1, 1);
                                        intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                        productMade = true;
                                        break;
                                    } else if (oldProdNum == 2){//get the price and weight of the existing product and apply them to the new product
                                        double p = intFace.getProductPrice(1, 2);
                                        double w = intFace.getProductWeight(1, 2);
                                        intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                        productMade = true;
                                        break;
                                    } else if (oldProdNum == 3){//get the price and weight of the existing product and apply them to the new product
                                        double p = intFace.getProductPrice(1, 3);
                                        double w = intFace.getProductWeight(1, 3);
                                        intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                        productMade = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if (productMade){
                            continue;
                        }
                        System.out.println("Please enter the price of the product: ");
                        double price = console.nextDouble(); //Double.parseDouble(console.nextDouble());
                        while (price<=0){
                            System.out.println("Price must be a positive value. Please enter again");
                            price = console.nextDouble();
                        }
                        System.out.println("Please enter the weight of the product: ");
                        double weight = console.nextDouble();
                        while (weight<=0){
                            System.out.println("Weight must be more than 0. Please enter again.");
                            weight = console.nextDouble();
                        }
                        System.out.println("Please enter the quantity of the product: ");
                        int quantity = console.nextInt();
                        while (quantity<=0){
                            System.out.println("Quantity cant be less than Zero. Please enter again.");
                            quantity = console.nextInt();
                        }
                        intFace.makeProduct(currentDepotNumber,name, price, weight, quantity);
                    } else if (input.equalsIgnoreCase("d")){
                        //add a check for which depot is currently being used and then have the user be able to delete the products in that depot
                        System.out.println("Which product would you like to delete? Please enter product's name: ");
                        input = console.nextLine();
                        if (currentDepotNumber == 1 && intFace.checkProductMatch(1, input)==1){
                            System.out.println("Are you sure you want to delete "+d1p1+"? y to confirm, n to cancel. ");
                            input = console.nextLine();
                            if (input.equalsIgnoreCase("y"))
                                intFace.deleteProduct(1,d1p1);
                            else if (input.equalsIgnoreCase("n"))
                                break;
                        } else if (currentDepotNumber ==1 && intFace.checkProductMatch(1, input)==2){
                            System.out.println("Are you sure you want to delete "+d1p2+"? y to confirm, n to cancel. ");
                            input = console.nextLine();
                            if (input.equalsIgnoreCase("y"))
                                intFace.deleteProduct(1,d1p2);
                            else if (input.equalsIgnoreCase("n"))
                                break;
                        } else if (currentDepotNumber ==1 && intFace.checkProductMatch(1, input)==3){
                            System.out.println("Are you sure you want to delete "+d1p3+"? y to confirm, n to cancel. ");
                            input = console.nextLine();
                            if (input.equalsIgnoreCase("y"))
                                intFace.deleteProduct(1,d1p3);
                            else if (input.equalsIgnoreCase("n"))
                                break;
                        }


                    } else if (input.equalsIgnoreCase("c")){
                        //make this work with the same code for both depots using currentDepotNumber
                        System.out.println("What product would you like to check the presence of? Enter it's name: ");
                        String name = console.nextLine();
                        if (intFace.checkProductMatch(1,name)>0){
                            if (intFace.checkProductMatch(1, name)==1){
                                System.out.println("There is a product of name "+d1p1+".");
                                System.out.println(intFace.getListedProduct(1,1));
                                break;
                            } else if (intFace.checkProductMatch(1, name)==2){
                                System.out.println("There is a product of name "+d1p2+".");
                                System.out.println(intFace.getListedProduct(1,2));
                                break;
                            } else if (intFace.checkProductMatch(1, name)==3){
                                System.out.println("There is a product of name "+d1p3+".");
                                System.out.println(intFace.getListedProduct(1,3));
                                break;
                            }else if (intFace.checkProductMatch(2, name)==1){
                                System.out.println("There is a product of name "+d2p1+".");
                                System.out.println(intFace.getListedProduct(2,1));
                                break;
                            } else if (intFace.checkProductMatch(2, name)==2){
                                System.out.println("There is a product of name "+d2p2+".");
                                System.out.println(intFace.getListedProduct(2,2));
                                break;
                            } else if (intFace.checkProductMatch(2, name)==3){
                                System.out.println("There is a product of name "+d2p3+".");
                                System.out.println(intFace.getListedProduct(2,3));
                                break;
                            }
                        }
                    } else if (input.equalsIgnoreCase("e")){
                        depotRunning = false;
                    }

                }
            } else if (input.equalsIgnoreCase("e")) {
                running = false;
            } else if (input.equalsIgnoreCase("a") && numOfDepots < 2 && !intFace.isInterfaceFull()) {

                if (numOfDepots == 0) {
                    //Creates the first Depot by querying the user for it's name and then assigning that name to the variable
                    System.out.println("Enter name of depot " + (numOfDepots + 1) + ": ");
                    String depotName = console.nextLine();
                    intFace.setDepot(1, depotName);
                    depotStart = true;
                    depotRunning = true;
                    numOfDepots++;
                    currentDepotNumber = 1; //loop here
                    while (depotRunning){//Start of the depot loop for all of the depots
                        intFace.runDepot(currentDepotNumber);
                        int capacity = 1;
                        boolean productMade = false;
                        String d1p1 = "", d1p2 = "", d1p3 = "";
                        String d1p1List = "", d1p2List = "", d1p3List = "";
                        String d2p1 = "", d2p2 = "", d2p3 = "";
                        String d2p1List = "", d2p2List = "", d2p3List = "";

                        for (int i = 1; i<=2; i++) {
                            switch (i) {
                                case 1:
                                    capacity = intFace.getDepotCapacity(1);
                                    switch (capacity) {
                                        case 1:
                                            d1p1 += intFace.getProductName(1, 1);
                                            break;
                                        case 2:
                                            d1p1 += intFace.getProductName(1, 1);
                                            d1p2 += intFace.getProductName(1, 2);
                                            break;
                                        case 3:
                                            d1p1 += intFace.getProductName(1, 1);
                                            d1p2 += intFace.getProductName(1, 2);
                                            d1p3 += intFace.getProductName(1, 3);
                                            break;
                                    }
                                    capacity = intFace.getDepotCapacity(currentDepotNumber);
                                    break;
                                case 2:
                                    capacity = intFace.getDepotCapacity(2);
                                    switch (capacity) {
                                        case 1:
                                            d2p1 += intFace.getProductName(2, 1);
                                            break;
                                        case 2:
                                            d1p1 += intFace.getProductName(2, 1);
                                            d2p2 += intFace.getProductName(2, 2);
                                            break;
                                        case 3:
                                            d2p1 += intFace.getProductName(2, 1);
                                            d2p2 += intFace.getProductName(2, 2);
                                            d2p3 += intFace.getProductName(2, 3);
                                            break;
                                    }
                                    capacity = intFace.getDepotCapacity(currentDepotNumber);
                                    break;
                            }
                        }


                        input = console.nextLine();
                        if (input.equalsIgnoreCase("a")&&capacity<3){
                            System.out.println("Please enter the name of the product: ");
                            String name = console.nextLine();
                            while (intFace.checkProductMatch(1, name)!=0||intFace.checkProductMatch(2, name)!=0){
                                //A loop for assigning the values of an already existing product if the product is another depot
                                if (currentDepotNumber == 1 && intFace.checkProductMatch(1, name)!=0){
                                    System.out.println("A product with that name already exists, in this depot. Please enter a product name again");
                                    name = console.nextLine();
                                } else if (currentDepotNumber == 2 && intFace.checkProductMatch(2, name)!=0){
                                    System.out.println("A product with that name already exists, in this depot. Please enter a product name again");
                                    name = console.nextLine();
                                } else {
                                    if (currentDepotNumber == 1 && intFace.checkProductMatch(2, name)>=0){
                                        int oldProdNum = intFace.checkProductMatch(2, name);
                                        System.out.println("A product of that name already exists in another depot, what quantity of that product do you want?");
                                        int quantity = console.nextInt();
                                        if (oldProdNum == 1){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(2, 1);
                                            double w = intFace.getProductWeight(2, 1);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 2){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(2, 2);
                                            double w = intFace.getProductWeight(2, 2);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 3){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(2, 3);
                                            double w = intFace.getProductWeight(2, 3);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        }
                                    } else if (currentDepotNumber == 2 && intFace.checkProductMatch(1, name)>=0){
                                        int oldProdNum = intFace.checkProductMatch(1, name);
                                        System.out.println("A product of that name already exists in another depot, what quantity of that product do you want?");
                                        int quantity = console.nextInt();
                                        if (oldProdNum == 1){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(1, 1);
                                            double w = intFace.getProductWeight(1, 1);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 2){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(1, 2);
                                            double w = intFace.getProductWeight(1, 2);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 3){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(1, 3);
                                            double w = intFace.getProductWeight(1, 3);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (productMade){
                                continue;
                            }
                            System.out.println("Please enter the price of the product: ");
                            double price = console.nextDouble(); //Double.parseDouble(console.nextDouble());
                            while (price<=0){
                                System.out.println("Price must be a positive value. Please enter again");
                                price = console.nextDouble();
                            }
                            System.out.println("Please enter the weight of the product: ");
                            double weight = console.nextDouble();
                            while (weight<=0){
                                System.out.println("Weight must be more than 0. Please enter again.");
                                weight = console.nextDouble();
                            }
                            System.out.println("Please enter the quantity of the product: ");
                            int quantity = console.nextInt();
                            while (quantity<=0){
                                System.out.println("Quantity cant be less than Zero. Please enter again.");
                                quantity = console.nextInt();
                            }
                            intFace.makeProduct(currentDepotNumber,name, price, weight, quantity);
                        } else if (input.equalsIgnoreCase("d")){
                            //add a check for which depot is currently being used and then have the user be able to delete the products in that depot
                            System.out.println("Which product would you like to delete? Please enter product's name: ");
                            input = console.nextLine();
                            if (currentDepotNumber == 1 && intFace.checkProductMatch(1, input)==1){
                                System.out.println("Are you sure you want to delete "+d1p1+"? y to confirm, n to cancel. ");
                                input = console.nextLine();
                                if (input.equalsIgnoreCase("y"))
                                    intFace.deleteProduct(1,d1p1);
                                else if (input.equalsIgnoreCase("n"))
                                    break;
                            } else if (currentDepotNumber ==1 && intFace.checkProductMatch(1, input)==2){
                                System.out.println("Are you sure you want to delete "+d1p2+"? y to confirm, n to cancel. ");
                                input = console.nextLine();
                                if (input.equalsIgnoreCase("y"))
                                    intFace.deleteProduct(1,d1p2);
                                else if (input.equalsIgnoreCase("n"))
                                    break;
                            } else if (currentDepotNumber ==1 && intFace.checkProductMatch(1, input)==3){
                                System.out.println("Are you sure you want to delete "+d1p3+"? y to confirm, n to cancel. ");
                                input = console.nextLine();
                                if (input.equalsIgnoreCase("y"))
                                    intFace.deleteProduct(1,d1p3);
                                else if (input.equalsIgnoreCase("n"))
                                    break;
                            }


                        } else if (input.equalsIgnoreCase("c")){
                            //make this work with the same code for both depots using currentDepotNumber
                            System.out.println("What product would you like to check the presence of? Enter it's name: ");
                            String name = console.nextLine();
                            if (intFace.checkProductMatch(1,name)>0){
                                if (intFace.checkProductMatch(1, name)==1){
                                    System.out.println("There is a product of name "+d1p1+".");
                                    System.out.println(intFace.getListedProduct(1,1));
                                    break;
                                } else if (intFace.checkProductMatch(1, name)==2){
                                    System.out.println("There is a product of name "+d1p2+".");
                                    System.out.println(intFace.getListedProduct(1,2));
                                    break;
                                } else if (intFace.checkProductMatch(1, name)==3){
                                    System.out.println("There is a product of name "+d1p3+".");
                                    System.out.println(intFace.getListedProduct(1,3));
                                    break;
                                }else if (intFace.checkProductMatch(2, name)==1){
                                    System.out.println("There is a product of name "+d2p1+".");
                                    System.out.println(intFace.getListedProduct(2,1));
                                    break;
                                } else if (intFace.checkProductMatch(2, name)==2){
                                    System.out.println("There is a product of name "+d2p2+".");
                                    System.out.println(intFace.getListedProduct(2,2));
                                    break;
                                } else if (intFace.checkProductMatch(2, name)==3){
                                    System.out.println("There is a product of name "+d2p3+".");
                                    System.out.println(intFace.getListedProduct(2,3));
                                    break;
                                }
                            }
                        } else if (input.equalsIgnoreCase("e")){
                            depotRunning = false;
                        }

                    }
                } else if (numOfDepots == 1) {
                    System.out.println("Enter name of depot " + (numOfDepots + 1) + ": ");
                    String depotName = console.nextLine();
                    intFace.setDepot(2, depotName);
                    while (depotName.equalsIgnoreCase(intFace.getDepot(1))){
                        //This while loop is for checking that the name entered is not the same as the first depot name
                        System.out.println("There is already a depot with the name '"+(intFace.getDepot(1))+"'" +
                                ". Please enter a new name for Depot 2");
                        depotName = console.nextLine();
                        intFace.setDepot(2, depotName);
                    }
                    depotStart = true;
                    depotRunning = true;
                    numOfDepots++;
                    currentDepotNumber = 2; //loop here
                    while (depotRunning){//Start of the depot loop for all of the depots
                        intFace.runDepot(currentDepotNumber);
                        int capacity = 1;
                        boolean productMade = false;
                        String d1p1 = "", d1p2 = "", d1p3 = "";
                        String d1p1List = "", d1p2List = "", d1p3List = "";
                        String d2p1 = "", d2p2 = "", d2p3 = "";
                        String d2p1List = "", d2p2List = "", d2p3List = "";

                        for (int i = 1; i<=2; i++) {
                            switch (i) {
                                case 1:
                                    capacity = intFace.getDepotCapacity(1);
                                    switch (capacity) {
                                        case 1:
                                            d1p1 += intFace.getProductName(1, 1);
                                            break;
                                        case 2:
                                            d1p1 += intFace.getProductName(1, 1);
                                            d1p2 += intFace.getProductName(1, 2);
                                            break;
                                        case 3:
                                            d1p1 += intFace.getProductName(1, 1);
                                            d1p2 += intFace.getProductName(1, 2);
                                            d1p3 += intFace.getProductName(1, 3);
                                            break;
                                    }
                                    capacity = intFace.getDepotCapacity(currentDepotNumber);
                                    break;
                                case 2:
                                    capacity = intFace.getDepotCapacity(2);
                                    switch (capacity) {
                                        case 1:
                                            d2p1 += intFace.getProductName(2, 1);
                                            break;
                                        case 2:
                                            d1p1 += intFace.getProductName(2, 1);
                                            d2p2 += intFace.getProductName(2, 2);
                                            break;
                                        case 3:
                                            d2p1 += intFace.getProductName(2, 1);
                                            d2p2 += intFace.getProductName(2, 2);
                                            d2p3 += intFace.getProductName(2, 3);
                                            break;
                                    }
                                    capacity = intFace.getDepotCapacity(currentDepotNumber);
                                    break;
                            }
                        }


                        input = console.nextLine();
                        if (input.equalsIgnoreCase("a")&&capacity<3){
                            System.out.println("Please enter the name of the product: ");
                            String name = console.nextLine();
                            while (intFace.checkProductMatch(1, name)!=0||intFace.checkProductMatch(2, name)!=0){
                                //A loop for assigning the values of an already existing product if the product is another depot
                                if (currentDepotNumber == 1 && intFace.checkProductMatch(1, name)!=0){
                                    System.out.println("A product with that name already exists, in this depot. Please enter a product name again");
                                    name = console.nextLine();
                                } else if (currentDepotNumber == 2 && intFace.checkProductMatch(2, name)!=0){
                                    System.out.println("A product with that name already exists, in this depot. Please enter a product name again");
                                    name = console.nextLine();
                                } else {
                                    if (currentDepotNumber == 1 && intFace.checkProductMatch(2, name)>=0){
                                        int oldProdNum = intFace.checkProductMatch(2, name);
                                        System.out.println("A product of that name already exists in another depot, what quantity of that product do you want?");
                                        int quantity = console.nextInt();
                                        if (oldProdNum == 1){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(2, 1);
                                            double w = intFace.getProductWeight(2, 1);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 2){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(2, 2);
                                            double w = intFace.getProductWeight(2, 2);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 3){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(2, 3);
                                            double w = intFace.getProductWeight(2, 3);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        }
                                    } else if (currentDepotNumber == 2 && intFace.checkProductMatch(1, name)>=0){
                                        int oldProdNum = intFace.checkProductMatch(1, name);
                                        System.out.println("A product of that name already exists in another depot, what quantity of that product do you want?");
                                        int quantity = console.nextInt();
                                        if (oldProdNum == 1){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(1, 1);
                                            double w = intFace.getProductWeight(1, 1);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 2){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(1, 2);
                                            double w = intFace.getProductWeight(1, 2);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        } else if (oldProdNum == 3){//get the price and weight of the existing product and apply them to the new product
                                            double p = intFace.getProductPrice(1, 3);
                                            double w = intFace.getProductWeight(1, 3);
                                            intFace.makeProduct(currentDepotNumber,name, p, w, quantity);
                                            productMade = true;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (productMade){
                                continue;
                            }
                            System.out.println("Please enter the price of the product: ");
                            double price = console.nextDouble(); //Double.parseDouble(console.nextDouble());
                            while (price<=0){
                                System.out.println("Price must be a positive value. Please enter again");
                                price = console.nextDouble();
                            }
                            System.out.println("Please enter the weight of the product: ");
                            double weight = console.nextDouble();
                            while (weight<=0){
                                System.out.println("Weight must be more than 0. Please enter again.");
                                weight = console.nextDouble();
                            }
                            System.out.println("Please enter the quantity of the product: ");
                            int quantity = console.nextInt();
                            while (quantity<=0){
                                System.out.println("Quantity cant be less than Zero. Please enter again.");
                                quantity = console.nextInt();
                            }
                            intFace.makeProduct(currentDepotNumber,name, price, weight, quantity);
                        } else if (input.equalsIgnoreCase("d")){
                            //add a check for which depot is currently being used and then have the user be able to delete the products in that depot
                            System.out.println("Which product would you like to delete? Please enter product's name: ");
                            input = console.nextLine();
                            if (currentDepotNumber == 1 && intFace.checkProductMatch(1, input)==1){
                                System.out.println("Are you sure you want to delete "+d1p1+"? y to confirm, n to cancel. ");
                                input = console.nextLine();
                                if (input.equalsIgnoreCase("y"))
                                    intFace.deleteProduct(1,d1p1);
                                else if (input.equalsIgnoreCase("n"))
                                    break;
                            } else if (currentDepotNumber ==1 && intFace.checkProductMatch(1, input)==2){
                                System.out.println("Are you sure you want to delete "+d1p2+"? y to confirm, n to cancel. ");
                                input = console.nextLine();
                                if (input.equalsIgnoreCase("y"))
                                    intFace.deleteProduct(1,d1p2);
                                else if (input.equalsIgnoreCase("n"))
                                    break;
                            } else if (currentDepotNumber ==1 && intFace.checkProductMatch(1, input)==3){
                                System.out.println("Are you sure you want to delete "+d1p3+"? y to confirm, n to cancel. ");
                                input = console.nextLine();
                                if (input.equalsIgnoreCase("y"))
                                    intFace.deleteProduct(1,d1p3);
                                else if (input.equalsIgnoreCase("n"))
                                    break;
                            }


                        } else if (input.equalsIgnoreCase("c")){
                            //make this work with the same code for both depots using currentDepotNumber
                            System.out.println("What product would you like to check the presence of? Enter it's name: ");
                            String name = console.nextLine();
                            if (intFace.checkProductMatch(1,name)>0){
                                if (intFace.checkProductMatch(1, name)==1){
                                    System.out.println("There is a product of name "+d1p1+".");
                                    System.out.println(intFace.getListedProduct(1,1));
                                    break;
                                } else if (intFace.checkProductMatch(1, name)==2){
                                    System.out.println("There is a product of name "+d1p2+".");
                                    System.out.println(intFace.getListedProduct(1,2));
                                    break;
                                } else if (intFace.checkProductMatch(1, name)==3){
                                    System.out.println("There is a product of name "+d1p3+".");
                                    System.out.println(intFace.getListedProduct(1,3));
                                    break;
                                }else if (intFace.checkProductMatch(2, name)==1){
                                    System.out.println("There is a product of name "+d2p1+".");
                                    System.out.println(intFace.getListedProduct(2,1));
                                    break;
                                } else if (intFace.checkProductMatch(2, name)==2){
                                    System.out.println("There is a product of name "+d2p2+".");
                                    System.out.println(intFace.getListedProduct(2,2));
                                    break;
                                } else if (intFace.checkProductMatch(2, name)==3){
                                    System.out.println("There is a product of name "+d2p3+".");
                                    System.out.println(intFace.getListedProduct(2,3));
                                    break;
                                }
                            }
                        } else if (input.equalsIgnoreCase("e")){
                            depotRunning = false;
                        }

                    }
                } else {
                    System.out.println("You have reached the max number of depots");
                }


            } else if (input.equalsIgnoreCase("d")) {
                System.out.println("What do you want to delete?");
                input = console.nextLine();
                if (input.equalsIgnoreCase(intFace.getDepot(1))){
                    intFace.clearDepot(1);
                } else if (input.equalsIgnoreCase(intFace.getDepot(2))){
                    intFace.clearDepot(2);
                }
            } /*else if (input.equalsIgnoreCase("l")) {
                System.out.println(intFace.listDepots());
            } else if (depotStart){

                depotStart = false;
            }*/
        }while (running);

    }
}

