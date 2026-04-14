module TechRentals {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.graphics;

    opens TechRental to javafx.fxml;
    exports TechRental;
}