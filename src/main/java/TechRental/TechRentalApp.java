package TechRental;
import TechRental.tabs.*;
import javafx.application.Application;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import TechRental.tabs.AddItemTab;
import TechRental.tabs.RemoveItemTab;

import java.io.IOException;

public class TechRentalApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        BorderPane root = new BorderPane();

        MenuBar menuBar = new MenuBar();

        Menu menuFile = new Menu("File");
        Menu menuCredits = new Menu("Credits");
        MenuItem menuExit = new MenuItem("Exit");
        menuFile.getItems().add(menuExit);

        menuBar.getMenus().addAll(menuFile, menuCredits);
        menuExit.setOnAction(e-> System.exit(0));

        // Fixing for issue to be closed, better tab styling
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
        tabPane.setSide(Side.LEFT);
        tabPane.getStylesheets().add(getClass().getResource("/css/styles.css").toExternalForm());

        AddItemTab addItemTab = new AddItemTab();
        RemoveItemTab removeItemTab = new RemoveItemTab();


        HomeTab homeTab = new HomeTab();
        ImageView homeImage = new ImageView(new Image(getClass().getResourceAsStream("/images/home.png"))); // Image
        homeImage.setFitHeight(24);
        homeImage.setFitWidth(24);
        homeTab.setGraphic(homeImage);

        RentTab rentTab = new RentTab();
        ImageView rentImage = new ImageView(new Image(getClass().getResourceAsStream("/images/rent.png"))); // Image
        rentImage.setFitHeight(24);
        rentImage.setFitWidth(24);
        rentTab.setGraphic(rentImage);

        AdminTab adminTab = new AdminTab(rentTab, addItemTab, removeItemTab);
        ImageView adminImage = new ImageView(new Image(getClass().getResourceAsStream("/images/admin.png"))); // Image
        adminImage.setFitHeight(24);
        adminImage.setFitWidth(24);
        adminTab.setGraphic(adminImage);

        AnalyticTab analyticTab = new AnalyticTab();
        ImageView analyticImage = new ImageView(new Image(getClass().getResourceAsStream("/images/analytic.png"))); // Image
        analyticImage.setFitHeight(24);
        analyticImage.setFitWidth(24);
        analyticTab.setGraphic(analyticImage);

        tabPane.getTabs().addAll(
                homeTab,
                rentTab,
                adminTab,
                analyticTab
        );
        root.setTop(menuBar);
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
