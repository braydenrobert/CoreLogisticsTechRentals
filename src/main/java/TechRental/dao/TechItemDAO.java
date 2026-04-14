package TechRental.dao;

import TechRental.pojo.DisplayTechItem;
import TechRental.pojo.TechItem;
import java.util.ArrayList;

public interface TechItemDAO {

    ArrayList<TechItem> getAllItems();

    TechItem getItem(int id);

    void createItem(TechItem item);

    void updateItem(TechItem item);

    void deleteItem(int id);

    ArrayList<DisplayTechItem> getPrettyItems(); // Went back to teachers default naming for this as shown in lecture
}