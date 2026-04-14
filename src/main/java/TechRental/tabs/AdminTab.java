package TechRental.tabs;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.VBox;

public class AdminTab extends Tab {
    public AdminTab(RentTab rentTab, AddItemTab addItemTab, RemoveItemTab removeItemTab) {
        VBox itemPane = new VBox(10);

        Button addItemButton = new Button("Add Item");
        addItemButton.setOnAction(e -> {


        });

        Button removeItemButton = new Button("Remove Item");
        removeItemButton.setOnAction(e -> {

        });

        itemPane.getChildren().addAll(addItemButton, removeItemButton);
        setContent(itemPane);
    }
}
