import javafx.collections.FXCollections;
import javafx.scene.layout.Pane;

public class ElectronicStoreView extends Pane {
    private final ListViewPane storeLists;
    private final TextFieldPane storeText;
    private final ButtonPane storeButtons;
    private ElectronicStore model;

    public ElectronicStoreView(ElectronicStore m) {
        model = m;
        storeLists = new ListViewPane();
        storeText = new TextFieldPane();
        storeButtons = new ButtonPane();
        storeButtons.getAdd().setDisable(true);
        storeButtons.getPurchase().setDisable(true);
        storeButtons.getRemove().setDisable(true);
        update();
        getChildren().addAll(storeButtons, storeLists, storeText);

    }

    public void update() {
        //Updates the components of the GUI that need updating
        storeText.getSalesT().setText("" + model.getNumOfSales());
        storeText.getPersaleT().setText(model.getPersale());
        storeText.getRevenueT().setText(String.format("%.2f", model.getRevenue()));
        storeLists.getCartT().setText("Current Cart ($" + String.format("%.2f", model.getCartAmount()) + "):");
        storeLists.getStock().setItems(FXCollections.observableList(model.getStock()));
        storeLists.getMpitems().setItems(FXCollections.observableList(model.getMostPopular()));
        storeLists.getCart().setItems(FXCollections.observableList(model.getCurrentCartString()));
        storeButtons.getPurchase().setDisable(model.getCurrentCart().isEmpty());
        storeButtons.getRemove().setDisable(true);
    }

    public void resetModel(ElectronicStore m) {
        //Resets model to initial state
        model = m;
        storeButtons.getAdd().setDisable(true);
    }

    public ButtonPane getStoreButtons() {
        return storeButtons;
    }

    public ListViewPane getStoreLists() {
        return storeLists;
    }
}
