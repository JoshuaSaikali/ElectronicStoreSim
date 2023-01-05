import java.util.*;

public class ElectronicStore {
    public final int MAX_PRODUCTS = 10; //Maximum number of products the store can have
    private final String name;
    private final ArrayList<Product> stock; //Array to hold all products
    private final HashMap<Product, Integer> currentCart;
    private int curProducts;
    private float revenue;
    private int numOfSales;
    private String persale;
    private float cartAmount;

    public ElectronicStore(String initName) {
        revenue = 0.00f;
        numOfSales = 0;
        persale = "N/A";
        cartAmount = 0.00f;
        name = initName;
        stock = new ArrayList<Product>();
        currentCart = new HashMap<Product, Integer>();
        curProducts = 0;
    }

    public static ElectronicStore createStore() {
        ElectronicStore store1 = new ElectronicStore("Watts Up Electronics");
        Desktop d1 = new Desktop(100, 10, 3.0, 16, false, 250, "Compact");
        Desktop d2 = new Desktop(200, 10, 4.0, 32, true, 500, "Server");
        Laptop l1 = new Laptop(150, 10, 2.5, 16, true, 250, 15);
        Laptop l2 = new Laptop(250, 10, 3.5, 24, true, 500, 16);
        Fridge f1 = new Fridge(500, 10, 250, "White", "Sub Zero", false);
        Fridge f2 = new Fridge(750, 10, 125, "Stainless Steel", "Sub Zero", true);
        ToasterOven t1 = new ToasterOven(25, 10, 50, "Black", "Danby", false);
        ToasterOven t2 = new ToasterOven(75, 10, 50, "Silver", "Toasty", true);
        store1.addProduct(d1);
        store1.addProduct(d2);
        store1.addProduct(l1);
        store1.addProduct(l2);
        store1.addProduct(f1);
        store1.addProduct(f2);
        store1.addProduct(t1);
        store1.addProduct(t2);
        return store1;
    }

    public String getName() {
        return name;
    }

    public List<Product> getStock() {
        ArrayList<Product> copy = new ArrayList<Product>();
        for (Product p : stock)
            if (p.getStockQuantity() > 0)
                copy.add(p);
        return copy;
    }

    public double getRevenue() {
        return revenue;
    }

    public int getNumOfSales() {
        return numOfSales;
    }

    public String getPersale() {
        return persale;
    }

    public float getCartAmount() {
        return cartAmount;
    }

    public List<String> getCurrentCartString() {
        //Returns string with proper format to display in the cart
        ArrayList<String> stringList = new ArrayList<String>();
        for (Product p : currentCart.keySet()) {
            stringList.add(currentCart.get(p) + " x " + p);
        }
        return stringList;
    }

    public ArrayList<Product> getCurrentCart() {
        return new ArrayList<Product>(currentCart.keySet());
    }

    public List<Product> getMostPopular() {
        ArrayList<Product> copyOfStock = new ArrayList<>(stock);
        Collections.sort(copyOfStock);
        return copyOfStock.subList(0, 3);
    }

    public boolean addProduct(Product newProduct) {
        if (curProducts < MAX_PRODUCTS) {
            stock.add(newProduct);
            curProducts++;
            return true;
        }
        return false;
    }

    public void addToCart(Product p) {
        //adds product to cart list
        p.adjustStock(-1);
        if (p.getStockQuantity() >= 0) {
            currentCart.put(p, p.getCartAmount());
            cartAmount += p.getPrice();
        }
    }

    public void removeFromCart(Product p) {
        //removes product from cart
        p.adjustStock(1);
        currentCart.put(p, p.getCartAmount());
        cartAmount -= p.getPrice();
        if (p.getCartAmount() == 0)
            currentCart.remove(p);
    }

    public void completePurchase() {
        //Adjust values accordingly and clear the cart
        numOfSales++;
        revenue += cartAmount;
        persale = String.format("%.2f", revenue / numOfSales);
        for (Product p : currentCart.keySet()) {
            p.sellUnits(p.getCartAmount());
            p.resetCartAmount();
        }
        currentCart.clear();
        cartAmount = 0.00f;
    }
}
