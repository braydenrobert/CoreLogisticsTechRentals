package TechRental.table;

import TechRental.dao.TechItemDAO;
import TechRental.database.Database;
import TechRental.database.DBConst;
import TechRental.pojo.DisplayTechItem;
import TechRental.pojo.TechItem;

import java.sql.*;
import java.util.ArrayList;

import static TechRental.database.DBConst.*;

public class TechItemTable implements TechItemDAO {

    private static TechItemTable instance;
    private final Database database = Database.getInstance();

    public static TechItemTable getInstance() {
        if (instance == null) {
            instance = new TechItemTable();
        }
        return instance;
    }

    @Override
    public ArrayList<TechItem> getAllItems() {
        ArrayList<TechItem> items = new ArrayList<>();
        String query = "SELECT * FROM " + TABLE_ITEM;

        try (Statement statement = database.getConnection().createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                items.add(new TechItem(
                        result.getInt(ITEM_COLUMN_ID),
                        result.getString(ITEM_COLUMN_NAME),
                        result.getInt(ITEM_COLUMN_CATEGORY),
                        result.getString(ITEM_COLUMN_SPEC),
                        result.getDouble(ITEM_COLUMN_RATE),
                        result.getString(ITEM_COLUMN_STATUS)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public TechItem getItem(int id) {
        String query = "SELECT * FROM " + TABLE_ITEM + " WHERE " + ITEM_COLUMN_ID + " = " + id;

        try (Statement statement = database.getConnection().createStatement();
             ResultSet result = statement.executeQuery(query)) {

            if (result.next()) {
                return new TechItem(
                        result.getInt(ITEM_COLUMN_ID),
                        result.getString(ITEM_COLUMN_NAME),
                        result.getInt(ITEM_COLUMN_CATEGORY),
                        result.getString(ITEM_COLUMN_SPEC),
                        result.getDouble(ITEM_COLUMN_RATE),
                        result.getString(ITEM_COLUMN_STATUS)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void createItem(TechItem item) {
        String query = "INSERT INTO " + TABLE_ITEM + " (" +
                ITEM_COLUMN_NAME + ", " + ITEM_COLUMN_CATEGORY + ", " +
                ITEM_COLUMN_SPEC + ", " + ITEM_COLUMN_RATE + ", " + ITEM_COLUMN_STATUS +
                ") VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement prep = database.getConnection().prepareStatement(query)) {
            prep.setString(1, item.getName());
            prep.setInt(2, item.getCategory());
            prep.setString(3, item.getSpecification());
            prep.setDouble(4, item.getDailyRate());
            prep.setString(5, item.getStatus());
            prep.executeUpdate();
            System.out.println("Item added to database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(TechItem item) {
        String query = "UPDATE " + TABLE_ITEM + " SET " +
                ITEM_COLUMN_NAME + " = ?, " +
                ITEM_COLUMN_CATEGORY + " = ?, " +
                ITEM_COLUMN_SPEC + " = ?, " +
                ITEM_COLUMN_RATE + " = ?, " +
                ITEM_COLUMN_STATUS + " = ? " +
                "WHERE " + ITEM_COLUMN_ID + " = ?";

        try (PreparedStatement prep = database.getConnection().prepareStatement(query)) {
            prep.setString(1, item.getName());
            prep.setInt(2, item.getCategory());
            prep.setString(3, item.getSpecification());
            prep.setDouble(4, item.getDailyRate());
            prep.setString(5, item.getStatus());
            prep.setInt(6, item.getId());
            prep.executeUpdate();
            System.out.println("Item updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteItem(int id) {
        String query = "DELETE FROM " + TABLE_ITEM + " WHERE " + ITEM_COLUMN_ID + " = " + id;

        try (Statement statement = database.getConnection().createStatement()) {
            statement.execute(query);
            System.out.println("Item deleted");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<DisplayTechItem> getPrettyItems() {
        ArrayList<DisplayTechItem> displayList = new ArrayList<>();

        String query = """
                SELECT
                    tech.id,
                    tech.name,
                    cat.name AS category_name,
                    tech.specification,
                    tech.daily_rate,
                    tech.status
                FROM tech_item AS tech
                JOIN category AS cat ON tech.category = cat.id
                ORDER BY tech.id
                """;

        try (Statement statement = database.getConnection().createStatement();
             ResultSet result = statement.executeQuery(query)) {

            while (result.next()) {
                displayList.add(new DisplayTechItem(
                        result.getInt("id"),
                        result.getString("name"),
                        result.getString("category_name"),
                        result.getString("specification"),
                        result.getDouble("daily_rate"),
                        result.getString("status")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayList;
    }
}