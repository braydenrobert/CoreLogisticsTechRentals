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

    ArrayList<DisplayTechItem> getPrettyItems(); // Way teacher shows inside powerpoint
}