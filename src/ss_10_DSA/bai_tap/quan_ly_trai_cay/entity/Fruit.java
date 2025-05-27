package ss_10_DSA.bai_tap.quan_ly_trai_cay.entity;

public class Fruit {
    int id;
    private String fruitName;
    private String fruitType;
    private String productionDate;
    private String expiry;
    private String origin;
    private double price;

    public Fruit() {
    }

    public Fruit(int id,String fruitName, String fruitType, String productionDate,
                 String expiry, String origin, double price) {
        this.id = id;
        this.fruitName = fruitName;
        this.fruitType = fruitType;
        this.productionDate = productionDate;
        this.expiry = expiry;
        this.origin = origin;
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getFruitType() {
        return fruitType;
    }

    public void setFruitType(String fruitType) {
        this.fruitType = fruitType;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", fruitName='" + fruitName + '\'' +
                ", fruitType='" + fruitType + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", expiry='" + expiry + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }
}
