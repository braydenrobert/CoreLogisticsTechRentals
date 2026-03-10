package TechRental;
import TechRental.tabs.AddItemTab;
import TechRental.tabs.AnalyticTab;
import TechRental.tabs.HomeTab;
import TechRental.tabs.RentTab;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TechRentalApp extends Application {

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

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");
        Menu menuCredits = new Menu("Credits");

        MenuItem menuExit = new MenuItem("Exit");
        menuFile.getItems().add(menuExit);

        menuBar.getMenus().addAll(menuFile, menuCredits);
        menuExit.setOnAction(e->{
            System.exit(0);
        });

        TabPane tabPane = new TabPane();

        HomeTab homeTab = new HomeTab();
        RentTab rentTab = new RentTab();
        AddItemTab addItemTab = new AddItemTab();
        AnalyticTab analyticTab = new AnalyticTab();

        tabPane.getTabs().addAll(
                homeTab,
                rentTab,
                addItemTab,
                analyticTab
        );

        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        root.setTop(menuBar);

        tabPane.setSide(Side.LEFT);
        root.setCenter(tabPane);


        HBox searchBox = new HBox(10);
        TextField searchName = new TextField();
        searchName.setPromptText("Search");
        searchBox.getChildren().add(searchName);
        root.setTop(searchBox);


        TableView<Items> tableView = new TableView<>();
        ArrayList<Items> dataItems = new ArrayList<>();

        dataItems.add(new Items("NA", 0.00, "NA"));
        dataItems.add(new Items("NA", 0.00, "NA"));
        dataItems.add(new Items("NA", 0.00, "NA"));

        /*
        https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html
         */

        ObservableList<Items> inventory = FXCollections.observableArrayList(dataItems);
        tableView.setItems(inventory);

        TableColumn<Items, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getName()));

        TableColumn<Items, Double> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(p -> new SimpleDoubleProperty(p.getValue().getPrice()).asObject());

        TableColumn<Items, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(p -> new SimpleStringProperty(p.getValue().getCategory()));

        tableView.getColumns().addAll(nameCol, priceCol, categoryCol);
        root.setCenter(tableView);

        Scene scene = new Scene (root, 500, 300);
        stage.setTitle("Tech Rental");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
