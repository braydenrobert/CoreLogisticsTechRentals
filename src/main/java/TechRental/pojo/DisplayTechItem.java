package TechRental.pojo;

/*
 * Displaying items in the TableView (RentTab, RemoveItemTab).
 * Joins category name instead of showing id.
 */

public class DisplayTechItem {
    private int id;
    private String name;
    private String categoryName;
    private String specification;
    private double dailyRate;
    private String status;

    public DisplayTechItem(int id, String name, String categoryName, String specification, double dailyRate, String status) {
        this.id = id;
        this.name = name;
        this.categoryName = categoryName;
        this.specification = specification;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSpecification() {
        return specification;
    }
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getDailyRate() {
        return dailyRate;
    }
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
