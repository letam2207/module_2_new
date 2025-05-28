package taskmanager.view;

import taskmanager.common.IdNotFoundException;
import taskmanager.common.UniqueIDException;
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
    public static void add() {
        try {
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

            jobService.add(new Job(id, name, date, amount, description));
            System.out.println("Thêm mới thành công!");
        } catch (UniqueIDException e) {
            System.out.println("Lỗi: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Lỗi: Dữ liệu nhập vào không hợp lệ!");
        }
    }


    public static void delete() {
        try {
            System.out.println("Nhập ID cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());

            jobService.delete(id);
            System.out.println(" Xóa thành công!");
        } catch (IdNotFoundException e) {
            System.out.println( e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(" Vui lòng nhập số nguyên hợp lệ!");
        }
    }

    public static int inputId() {
        System.out.println("Nhập ID: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void update() {
        int id = inputId();
        scanner.nextLine();
        if (!jobService.checkId(id)) {
            System.out.println("ID không tồn tại!");
            return;
        }
        System.out.println("Nhập tên chi tiêu mới:");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày chi tiêu mới:");
        String date = scanner.nextLine();
        System.out.println("Nhập số tiền chi tiêu mới:");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập mô tả mới:");
        String description = scanner.nextLine();

        Job newJob = new Job(id, name, date, amount, description);
        jobService.updateById(id, newJob);
        System.out.println("Cập nhật thành công!");
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
