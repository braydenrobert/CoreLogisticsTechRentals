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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class TechRentalApp extends Application {

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

        HBox searchBox = new HBox(10);
        TextField searchName = new TextField();
        searchName.setPromptText("Search");
        searchBox.getChildren().add(searchName);
        root.setTop(searchBox);

        TabPane tabPane = new TabPane();

        HomeTab homeTab = new HomeTab();

        AddItemTab addItemTab = new AddItemTab();
        AnalyticTab analyticTab = new AnalyticTab();


        RentTab rentTab = new RentTab();
        ImageView rentImage = new ImageView(new Image(getClass().getResourceAsStream("/resources/images/rent.png")));
        rentImage.setFitHeight(12);
        rentImage.setFitWidth(12);
        rentTab.setGraphic(rentImage);


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




        Scene scene = new Scene (root, 500, 300);
        stage.setTitle("Tech Rental");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
