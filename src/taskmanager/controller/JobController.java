package taskmanager.controller;

import taskmanager.common.IdNotFoundException;
import taskmanager.common.UniqueIDException;
import taskmanager.entity.Job;
import taskmanager.service.IJobService;
import taskmanager.service.JobService;
import taskmanager.view.JobView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobController {
    static Scanner scanner = new Scanner(System.in);
public static IJobService jobService = new JobService();
    public static void menu() {
        boolean check = true;
        do {
            System.out.println("-------ỨNG DỤNG QUẢN LÝ CÔNG VIỆC---------");
            System.out.println("1. Hiển thị danh sách");
            System.out.println("2. Thêm");
            System.out.println("3. Xóa ");
            System.out.println("4. Sửa");
            System.out.println("5. Tìm kiếm theo mã chi tiêu ");
            System.out.println("6. Tìm kiếm gần đúng theo tên chi tiêu");
            System.out.println("7. Sắp xếp theo tên tăng dần");
            System.out.println("8. Sắp xếp theo số tiền chi giảm dần, nếu số tiền chi giống nhau thì sắp xếp theo tên tăng dần");
            System.out.println("9. Thoát");
            System.out.println("-----------NHẬP LỰA CHỌN-----------");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    List<Job> jobList = jobService.findAll();
                    JobView.display(jobList);
                    break;
                case 2:
                    add();
                    break;
                case 3:
                    delete();
                    break;
                case 4:
                    update();
                    break;
                case 5:
                    searchId();
                    break;
                case 6:
                    searchName();
                    break;
                case 7:
                    ArrayList<Job> jobArrayList = (ArrayList<Job>) jobService.findAll();
                    jobArrayList.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
                    JobView.display(jobArrayList);

                    break;
                case 8:
                    ArrayList<Job> jobs = (ArrayList<Job>) jobService.findAll();
                    jobs.sort((p1,p2)->Double.compare(p1.getAmount(),p2.getAmount()));
                    JobView.display(jobs);
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    check = false;
            }
        } while (check);
    }

        private static void add(){
        Job job = JobView.input();
            try {
                jobService.add(job);
                System.out.println("Thêm thành công!");
            } catch (UniqueIDException e) {
                System.out.println("Lỗi: " + e.getMessage());
            }
        }
    public static void delete() {
        try {
            int id = JobView.inputId();
            jobService.delete(id);
            System.out.println(" Xóa thành công!");
        } catch (IdNotFoundException e) {
            System.out.println( e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(" Vui lòng nhập số nguyên hợp lệ!");
        }
    }
    private  static void update(){
        int id = JobView.inputId();
        if (!jobService.checkId(id)) {
            System.out.println("ID không tồn tại!");
            return;
        }
        Job job = JobView.input();
        jobService.updateById(id, job);
        System.out.println("Cập nhật thành công!");
    }
    private static void searchName(){
        String name = JobView.inputName();
        List<Job> jobList = jobService.searchName(name);
        if (jobList.isEmpty()){
            System.out.println("Không tìm thấy mã chi tiêu "+ name);
        }else {
            JobView.display(jobList);
        }
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
