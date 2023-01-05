import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    private ElectronicStore model;
    private ElectronicStoreView view;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);

        Button add = view.getStoreButtons().getAdd();
        Button remove = view.getStoreButtons().getRemove();
        Button purchase = view.getStoreButtons().getPurchase();
        Button reset = view.getStoreButtons().getReset();

        view.getStoreLists().getStock().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                add.setDisable(view.getStoreLists().getStock().getSelectionModel().getSelectedIndex() < 0);
            }
        });

        add.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (view.getStoreLists().getStock().getSelectionModel().getSelectedIndex() >= 0) {
                    model.addToCart(model.getStock().get(view.getStoreLists().getStock().getSelectionModel().getSelectedIndex()));
                }
                view.update();
                add.setDisable(view.getStoreLists().getStock().getSelectionModel().getSelectedIndex() < 0);
            }
        });

        view.getStoreLists().getCart().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                remove.setDisable(view.getStoreLists().getCart().getSelectionModel().getSelectedIndex() < 0);
            }
        });

        remove.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (view.getStoreLists().getCart().getSelectionModel().getSelectedIndex() >= 0) {
                    model.removeFromCart(model.getCurrentCart().get(view.getStoreLists().getCart().getSelectionModel().getSelectedIndex()));
                    view.update();
                }
                remove.setDisable(view.getStoreLists().getCart().getSelectionModel().getSelectedIndex() < 0);
            }
        });

        purchase.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.completePurchase();
                view.update();
            }
        });

        reset.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model = ElectronicStore.createStore();
                view.resetModel(model);
                view.update();
            }
        });

        primaryStage.setTitle("Electronic Store Application - " + model.getName());
        primaryStage.setScene(new Scene(view, 700, 350));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
