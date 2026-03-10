package TechRental.tabs;

import TechRental.TechRentalApp;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class RentTab extends Tab {

    public static class Items {
        private String name;
        private double price;
        private String category;

        public Items(String name, double price, String category) {
            this.name = name;
            this.price = price;
            this.category = category;
        }

        public String getName() { return name; }
        public double getPrice() { return price; }
        public String getCategory() { return category; }

    }

    private TableView<Items> tableView = new TableView<>();
    private ObservableList<Items> inventory;

    public RentTab() {

        tableView = new TableView<>();

        ArrayList<Items> dataItems = new ArrayList<>();
        dataItems.add(new Items("NA", 0.00, "NA"));
        dataItems.add(new Items("NA", 0.00, "NA"));
        dataItems.add(new Items("NA", 0.00, "NA"));

        ObservableList<Items> inventory = FXCollections.observableArrayList(dataItems);
        tableView.setItems(inventory);

        TableColumn<Items, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));

        TableColumn<Items, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().getPrice()).asObject());

        TableColumn<Items, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getCategory()));

        tableView.getColumns().addAll(nameCol, priceCol, categoryCol);

        VBox layout = new VBox(tableView);
        this.setContent(layout);

    }

    public ObservableList<Items> getInventory() {
        return inventory;
    }

    public TableView<Items> getTableView() {
        return tableView;
    }
}
