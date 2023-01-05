import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
//Pane for all the ListViews
public class ListViewPane extends Pane {
    private final ListView<Product> mpitems;
    private final ListView<Product> stock;
    private final ListView<String> cart;
    private final Label cartT;

    public ListViewPane() {
        mpitems = new ListView<>();
        stock = new ListView<>();
        cart = new ListView<>();
        Label mpitemsT = new Label("Most Popular Items:");
        Label stockT = new Label("Store Stock:");
        cartT = new Label();

        mpitemsT.relocate(30, 130);
        mpitemsT.setPrefSize(150, 10);
        mpitems.relocate(10, 150);
        mpitems.setPrefSize(150, 140);
        stockT.relocate(260, 15);
        stockT.setPrefSize(100, 10);
        stock.relocate(170, 35);
        stock.setPrefSize(250, 255);
        cartT.relocate(515, 15);
        cartT.setPrefSize(300, 10);
        cart.relocate(430, 35);
        cart.setPrefSize(250, 255);

        getChildren().addAll(mpitemsT, mpitems, stockT, stock, cartT, cart);
    }

    public ListView<Product> getMpitems() {
        return mpitems;
    }

    public ListView<Product> getStock() {
        return stock;
    }

    public ListView<String> getCart() {
        return cart;
    }

    public Label getCartT() {
        return cartT;
    }
}
