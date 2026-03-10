package TechRental.tabs;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;

public class AdminTab extends Tab {
    public AdminTab(RentTab rentTab, AddItemTab addItemTab, RemoveItemTab removeItemTab) {
        Button addItemButton = new Button("Add Item");
        addItemButton.setOnAction(e -> {


        });

        Button removeItemButton = new Button("Remove Item");
        removeItemButton.setOnAction(e -> {
            
        });
    }
}
