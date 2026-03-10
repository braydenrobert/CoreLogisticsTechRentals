package TechRental;
import TechRental.tabs.*;
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
        ImageView homeImage = new ImageView(new Image(getClass().getResourceAsStream("/images/home.png")));
        homeImage.setFitHeight(24);
        homeImage.setFitWidth(24);
        homeTab.setGraphic(homeImage);

        RentTab rentTab = new RentTab();
        ImageView rentImage = new ImageView(new Image(getClass().getResourceAsStream("/images/rent.png")));
        rentImage.setFitHeight(24);
        rentImage.setFitWidth(24);
        rentTab.setGraphic(rentImage);

        AdminTab adminTab = new AdminTab();
        ImageView adminImage = new ImageView(new Image(getClass().getResourceAsStream("/images/admin.png")));
        adminImage.setFitHeight(24);
        adminImage.setFitWidth(24);
        adminTab.setGraphic(adminImage);

        AnalyticTab analyticTab = new AnalyticTab();
        ImageView analyticImage = new ImageView(new Image(getClass().getResourceAsStream("/images/analytic.png")));
        analyticImage.setFitHeight(24);
        analyticImage.setFitWidth(24);
        analyticTab.setGraphic(analyticImage);

        tabPane.getTabs().addAll(
                homeTab,
                rentTab,
                adminTab,
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
