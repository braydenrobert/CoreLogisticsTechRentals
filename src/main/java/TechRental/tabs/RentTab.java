package TechRental.tabs;

import TechRental.TechRentalApp;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class RentTab extends Tab {

    // class for item data
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

        // sample data
        ArrayList<Items> dataItems = new ArrayList<>();
        dataItems.add(new Items("lappy", 4.00, "NA"));
        dataItems.add(new Items("cell", 4.500, "NA"));
        dataItems.add(new Items("headset", 7.00, "NA"));

        // convert list to observable list
        inventory = FXCollections.observableArrayList(dataItems);
        tableView.setItems(inventory);

        // name column
        TableColumn<Items, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));

        // price column
        TableColumn<Items, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().getPrice()).asObject());

        // category column
        TableColumn<Items, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getCategory()));

        // add columns to table
        tableView.getColumns().addAll(nameCol, priceCol, categoryCol);

        // search field
        TextField searchName = new TextField();
        searchName.setPromptText("Item Name");

        // filter table when typing
        searchName.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null || newValue.isEmpty()) {
                tableView.setItems(inventory);
                return;
            }

            ObservableList<Items> nameFilter = FXCollections.observableArrayList();
            for (Items item : inventory) {
                if (item.getName().toLowerCase().contains(newValue.toLowerCase())) {
                    nameFilter.add(item);
                }
            }
            tableView.setItems(nameFilter);
        });

        // layout
        VBox layout = new VBox(tableView, searchName);
        this.setContent(layout);

    }

    public ObservableList<Items> getInventory() {
        return inventory;
    }

    public TableView<Items> getTableView() {
        return tableView;
    }
}