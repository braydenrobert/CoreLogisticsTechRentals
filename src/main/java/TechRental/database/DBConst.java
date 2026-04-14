package TechRental.database;

/*
Milestone Database
 */

public class DBConst {
    public static final String TABLE_ITEM = "tech_item";
    public static final String ITEM_COLUMN_ID = "id";
    public static final String ITEM_COLUMN_NAME = "name";
    public static final String ITEM_COLUMN_CATEGORY = "category";
    public static final String ITEM_COLUMN_SPEC = "specification";
    public static final String ITEM_COLUMN_RATE = "daily_rate";
    public static final String ITEM_COLUMN_STATUS = "status";

    public static final String TABLE_CATEGORY = "category";
    public static final String CATEGORY_COLUMN_ID = "id";
    public static final String CATEGORY_COLUMN_NAME = "name";

    public static final String CREATE_TABLE_CATEGORY =
            "CREATE TABLE IF NOT EXISTS " + TABLE_CATEGORY + " (" +
                    CATEGORY_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    CATEGORY_COLUMN_NAME + " VARCHAR(50), " +
                    "PRIMARY KEY(" + CATEGORY_COLUMN_ID + "))";

    public static final String CREATE_TABLE_ITEM =
            "CREATE TABLE IF NOT EXISTS " + TABLE_ITEM + " (" +
                    ITEM_COLUMN_ID + " int NOT NULL AUTO_INCREMENT, " +
                    ITEM_COLUMN_NAME + " VARCHAR(100), " +
                    ITEM_COLUMN_CATEGORY + " int, " +
                    ITEM_COLUMN_SPEC + " VARCHAR(200), " +
                    ITEM_COLUMN_RATE + " DECIMAL(10,2), " +
                    ITEM_COLUMN_STATUS + " VARCHAR(20), " +
                    "FOREIGN KEY(" + ITEM_COLUMN_CATEGORY + ") REFERENCES " +
                    TABLE_CATEGORY + "(" + CATEGORY_COLUMN_ID + "), " +
                    "PRIMARY KEY(" + ITEM_COLUMN_ID + "))";
}
