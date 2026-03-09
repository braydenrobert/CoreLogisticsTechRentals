package TechRental;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
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

        VBox sidetab = new VBox(10);
        sidetab.getChildren().addAll(
                new Button("Home"),
                new Button("Rent"),
                new Button("Admin"),
                new Button("Analytics")
        );
        root.setLeft(sidetab);

        TableView<Items> tableView = new TableView<>();
        ArrayList<Items> dataItems = new ArrayList<>();

        dataItems.add(new Items("NA", 0.0, "NA"));
        dataItems.add(new Items("NA", 0.0, "NA"));
        dataItems.add(new Items("NA", 0.0, "NA"));

        ObservableList<Items> inventory = FXCollections.observableArrayList(dataItems);
        tableView.setItems(inventory);

        Scene scene = new Scene (root, 600, 400);
        stage.setTitle("Tech Rental");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
