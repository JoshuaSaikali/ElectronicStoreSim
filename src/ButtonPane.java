import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
//Pane for all the buttons
public class ButtonPane extends Pane {
    private final Button reset;
    private final Button add;
    private final Button remove;
    private final Button purchase;

    public ButtonPane() {
        reset = new Button("Reset Store");
        add = new Button("Add To Cart");
        remove = new Button("Remove From Cart");
        purchase = new Button("Complete Sale");

        reset.relocate(22.5, 295);
        reset.setPrefSize(125, 40);
        add.relocate(232.5, 295);
        add.setPrefSize(125, 40);
        remove.relocate(430, 295);
        remove.setPrefSize(125, 40);
        purchase.relocate(555, 295);
        purchase.setPrefSize(125, 40);

        getChildren().addAll(reset, add, remove, purchase);
    }

    public Button getReset() {
        return reset;
    }

    public Button getAdd() {
        return add;
    }

    public Button getPurchase() {
        return purchase;
    }

    public Button getRemove() {
        return remove;
    }
}
