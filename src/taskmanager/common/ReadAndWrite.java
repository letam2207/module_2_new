package taskmanager.common;

import taskmanager.entity.Job;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {

    public static void writeFileToBinary(String filePath, List<Job> jobList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(jobList);
        }catch (IOException e){
            System.out.println("Lỗi ghi file nhị phân: " + e.getMessage());
        }
    }

    public static List<Job> readFileToBinary(String filePath) {
        List<Job> jobList = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists() || file.length() == 0) {
            return jobList;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            jobList = (List<Job>) ois.readObject();
        } catch (IOException e) {
            System.out.println("Lỗi đọc file nhị phân: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Lỗi không tìm thấy class: " + e.getMessage());
        }
        return jobList;
    }
}
