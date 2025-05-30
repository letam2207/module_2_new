package taskmanager.entity;

import javax.print.DocFlavor;
import java.io.Serializable;
import java.util.Date;

public class Job implements Serializable {
    private int id;
    private String name;
    private String date;
    private double amount;
    private String description;

    public Job() {
    }

    public Job(int id, String name, String date, double amount, String description) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.amount = amount;
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "----------------------------" +
                "\n Mã chi tiêu: " + id +
                "\n Tên chi tiêu: " + name +
                "\n Ngày chi tiêu: " + date +
                "\n Số tiền: " + String.format("%,.0f VNĐ", amount) +
                "\n Mô tả: " + description +
                "\n----------------------------";
    }
    public String getInToFile(){
        return this.id+","+this.name+","+this.date+","+this.amount+","+this.description;
    }

}
