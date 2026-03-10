module TechRentals {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens TechRental to javafx.fxml;
    exports TechRental;
}