package TechRental;
import javafx.application.Application;
import javafx.stage.Stage;

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

    }

    public static void main(String[] args) {
        launch(args);
    }
}
