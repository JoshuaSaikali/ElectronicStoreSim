//Base class for all products the store will sell
public abstract class Product implements Comparable<Product> {
    private final double price;
    private int stockQuantity;
    private int soldQuantity;
    private int cartAmount;//the amount of this product is in the cart

    public Product(double initPrice, int initQuantity) {
        price = initPrice;
        stockQuantity = initQuantity;
        cartAmount = 0;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public double getPrice() {
        return price;
    }

    public int getCartAmount() {
        return cartAmount;
    }

    public void resetCartAmount() {
        cartAmount = 0;
    }

    public void sellUnits(int amount) {
        soldQuantity += amount;
    }

    public void adjustStock(int amount) { //if adding to cart amount is -1, if removing from cart amount is 1
        stockQuantity += amount;
        cartAmount -= amount;
    }

    //Compares sold quantity's of both objects
    public int compareTo(Product p) {
        return (p.soldQuantity - this.soldQuantity);
    }

}