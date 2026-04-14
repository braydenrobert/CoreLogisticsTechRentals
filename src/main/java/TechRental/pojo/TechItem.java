package TechRental.pojo;

/*
 * Contains all the fields (name, category, specification, daily rate, status).
 * Used for Create, Update, Delete, etc.
 */
public class TechItem {
    private int id;
    private String name;
    private int category;
    private String specification;
    private double dailyRate;
    private String status;

    public TechItem(int id, String name, int category, String specification, double dailyRate, String status) { // Read from existing item in database
        this.id = id;
        this.name = name;
        this.category = category;
        this.specification = specification;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    public TechItem(String name, int category, String specification, double dailyRate, String status) { // Create new item in database
        this.name = name;
        this.category = category;
        this.specification = specification;
        this.dailyRate = dailyRate;
        this.status = status;
    }

    public TechItem() {} // Empty constructor for javafx

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

    public int getCategory() {
        return category;
    }
    public void setCategory(int category) {
        this.category = category;
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
