package org.example.InterviewCodes.Acko;

import java.util.ArrayList;
import java.util.List;

/*Tesco has a fleet of vehicles to deliver orders to the customer. Assigning the right set of orders to different sized vehicles is crucial for efficient delivery of orders. Different vehicle can fit different container sizes.

        Given c containers, along with their volumes [l,b,h], catalogue of product with its volume requirement (l,b,h) and an order with p products and its quantity.

        Example:
        Containers:
        SMALL -> id=1, length=10, breadth=20, height=30
        MEDIUM -> id=2, length=50, breadth=60, height=70
        LARGE -> id=3, length=100, breadth=200, height=300

        Product:
        productId=1, length=2, breadth=4, height=10
        productId=2, length=10, breadth=30, height=4
        productId=3, length=5, breadth=6, height=7

        Order:
        productId=1, quantity=3
        productId=3, quantity=7


        Determine if that order fits in any of the given c containers and return the ID of the container that can be used.
        Given n orders, determine the maximum number of orders that can be fit into a particular container.*/
public class Container {
    int id;
    int length;;
    int breadth;
    int height;

    public Container(int id, int length, int breadth, int height) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.height = height;

    }

    public boolean canOrderFit(Product product) {
        if (length >= product.length && breadth >= product.breadth && height >= product.height) {
            return true;
        }
        return false;
    }
}

class Product {
    int id;
    int length;;
    int breadth;
    int height;
    int quantity;

    public Product(int id, int length, int breadth, int height, int quantity) {
        this.id = id;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.quantity = quantity;
    }
}

class Order {

    List<Product> products;

    public Order() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return products;
    }
}

class TescoDelieveryService {
    public static int determineContainersForOrders(Container[] containers, Order order) {
        for(Container container : containers) {

            boolean fitsInContainer = true;
            for (Product product : order.getProducts()) {
                if (!container.canOrderFit(product)) {
                    fitsInContainer = false;
                    break;
                }
            }
            if (fitsInContainer) {
                return container.id;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Container[] containers = {
                new Container(1,10,20,30),
                new Container(2,50,60,70)};

        Order order = new Order();
        order.addProduct(new Product(1,2,4,10,3));
        order.addProduct(new Product(2,10,30,4,2));


        int containerId = determineContainersForOrders(containers, order);

        if (containerId != -1) {
            System.out.println("Order fits in container " + containerId);

        } else {
            System.out.println("Not suitable");
        }

    }
}
