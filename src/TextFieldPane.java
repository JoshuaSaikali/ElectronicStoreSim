import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class TextFieldPane extends Pane {
    private final TextField salesT;
    private final TextField revenueT;
    private final TextField persaleT;
//Pane for all the text-fields
    public TextFieldPane() {
        salesT = new TextField();
        revenueT = new TextField();
        persaleT = new TextField();
        Label title = new Label("Store Summary:");
        Label salesL = new Label("# Sales:");
        Label revenueL = new Label("Revenue:");
        Label persaleL = new Label("$ / Sale:");

        title.relocate(40, 15);
        title.setPrefSize(100, 10);
        salesL.relocate(30, 40);
        salesL.setPrefSize(50, 10);
        revenueL.relocate(22, 70);
        revenueL.setPrefSize(50, 10);
        persaleL.relocate(28, 100);
        persaleL.setPrefSize(50, 10);
        salesT.relocate(75, 35);
        salesT.setPrefSize(80, 25);
        revenueT.relocate(75, 65);
        revenueT.setPrefSize(80, 25);
        persaleT.relocate(75, 95);
        persaleT.setPrefSize(80, 25);

        salesT.setEditable(false);
        revenueT.setEditable(false);
        persaleT.setEditable(false);

        getChildren().addAll(title, salesL, revenueL, persaleL, salesT, revenueT, persaleT);
    }

    public TextField getPersaleT() {
        return persaleT;
    }

    public TextField getRevenueT() {
        return revenueT;
    }

    public TextField getSalesT() {
        return salesT;
    }
}
