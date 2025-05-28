package taskmanager.view;

import taskmanager.entity.Job;
import taskmanager.service.IJobService;
import taskmanager.service.JobService;

import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class JobView {
    private static final IJobService jobService = new JobService();
    private static final Scanner scanner = new Scanner(System.in);
    public static void display(List<Job> jobList){
        for (int i = 0; i < jobList.size(); i++) {
            System.out.println(jobList.get(i));
        }
    }
    public static void add(){
        System.out.println("Nhập mã chi tiêu :");
        int id  = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên chi tiêu :");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày chi tiêu :");
        String date = scanner.nextLine();
        System.out.println("Nhập số tiền chi tiêu :");
        Double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập mô tả về việc chi tiêu :");
        String description = scanner.nextLine();
        jobService.add(new Job(id,name,date,amount,description));
    }

    public static void delete() {
        System.out.println("Nhập ID cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        boolean check = jobService.delete(id);
        if (check){
            System.out.println("xóa thành công");
        }else {
            System.out.println("không tìm thấy id");
        }
    }
    public static int inputId(){
        System.out.println("Nhập ID cần sửa: ");
        return scanner.nextInt();
    }
    public static void update(Job job){
        System.out.println("Nhập tên chi tiêu :");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày chi tiêu :");
        String date = scanner.nextLine();
        System.out.println("Nhập số tiền chi tiêu :");
        Double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập mô tả về việc chi tiêu :");
        String description = scanner.nextLine();
    }
    public static void searchName(){
        System.out.println("Nhập tên chi tiêu muốn tìm ");
        String name = scanner.nextLine();
        List<Job> jobList = jobService.searchName(name);
        display(jobList);
    }

    public static void searchId(){
        int id = JobView.inputId();
        List<Job> jobList = jobService.searchId(id);
        if (jobList.isEmpty()){
            System.out.println("Không tìm thấy mã chi tiêu "+ id);
        }else {
            JobView.display(jobList);
        }
    }

}
