package taskmanager.view;
import taskmanager.entity.Job;
import java.util.List;
import java.util.Scanner;


public class JobView {

    private static final Scanner scanner = new Scanner(System.in);
    public static void display(List<Job> jobList){
        for (int i = 0; i < jobList.size(); i++) {
            System.out.println(jobList.get(i));
        }
    }
    public static Job input() {
            System.out.println("Nhập mã chi tiêu :");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.println("Nhập tên chi tiêu :");
            String name = scanner.nextLine();

            System.out.println("Nhập ngày chi tiêu :");
            String date = scanner.nextLine();

            System.out.println("Nhập số tiền chi tiêu :");
            double amount = Double.parseDouble(scanner.nextLine());

            System.out.println("Nhập mô tả về việc chi tiêu :");
            String description = scanner.nextLine();

            return new Job(id, name, date, amount, description);
    }

    public static int inputId() {
        System.out.println("Nhập ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputName(){
        System.out.println("Nhập tên chi tiêu muốn tìm ");
        return scanner.nextLine();
    }



}