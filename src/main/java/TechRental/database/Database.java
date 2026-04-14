package TechRental.database;

import static TechRental.database.Const.*;
import java.sql.*;

/*
Milestone Database
*/

public class Database {
    private static Database instance;
    private Connection connection;

    private Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Check if connection to php.scweb.ca is actually working
            connection = DriverManager.getConnection(
                    "jdbc:mysql://php.scweb.ca/?useSSL=false",
                    DB_USER, DB_PASS);
            System.out.println("Connected to MySQL server");

            createDatabaseIfNotExists();

            //Ensure db name is created and connected
            connection = DriverManager.
                    getConnection(
                            "jdbc:mysql://php.scweb.ca/" + DB_NAME + "?useSSL=false",
                            // switched over to scweb from local
                            DB_USER, DB_PASS);
            System.out.println("Connected to database: " + DB_NAME);

            createTable(DBConst.TABLE_CATEGORY, DBConst.CREATE_TABLE_CATEGORY, connection);
            createTable(DBConst.TABLE_ITEM, DBConst.CREATE_TABLE_ITEM, connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName, String tableQuery, Connection connection) throws SQLException {
        Statement createTable;
        DatabaseMetaData md = connection.getMetaData();
        ResultSet resultSet = md.getTables(DB_NAME, null, tableName, null);
        if (resultSet.next()) {
            System.out.println(tableName + " table already exists");
        } else {
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
            // need to add default records
        }
    }

    private void createDatabaseIfNotExists() throws SQLException {
        String query = "CREATE DATABASE IF NOT EXISTS " + DB_NAME;
        try (Statement createDB = connection.createStatement()) {
            createDB.executeUpdate(query);
            System.out.println("Database '" + DB_NAME + "' is ready");
        }
    }

    public void createTable(String tableQuery, Connection connection) throws SQLException {
        connection.createStatement().execute(tableQuery);
    }

    public Connection getConnection() {
        return connection;
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}