package TechRental.pojo;


/*
 * Category lookup table (Computing, Power, Peripheral, Audio).
 */
public class Category extends DatabaseItem {
    private String name;

    public Category(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
