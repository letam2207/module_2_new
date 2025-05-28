package taskmanager.repository;

import taskmanager.entity.Job;

import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {

    private static final List<Job> jobList = new ArrayList<>();

    static {
        jobList.add(new Job(1, "Tiền mua đồ ăn", "20/03/2025", 2000000, "Mua đồ ăn sáng"));
        jobList.add(new Job(3, "Trả tiền trọ", "22/1/2025", 500000, "Mua đồ ăn sáng"));
        jobList.add(new Job(2, "Đóng tiền điện", "12/04/2025", 200000, "Mua đồ ăn sáng"));
    }

    @Override
    public List<Job> findAll() {
        return jobList;
    }


    @Override
    public void add(Job job) {
        jobList.add(job);
    }

    @Override
    public boolean checkId(int id) {
        for (Job job : jobList) {
            if (job.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Job findById(int id) {
        for (Job job : findAll()) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }


    @Override
    public boolean delete(int id) {
        for (int i = 0; i < jobList.size(); i++) {
            if (jobList.get(i).getId() == id) {
                jobList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateById(int id, Job job) {
        for (int i = 0; i < jobList.size(); i++) {
            if (jobList.get(i).getId() == id) {
                jobList.set(i, job);
                return;
            }
        }
    }


    @Override
    public List<Job> searchId(int id) {
        List<Job> list = new ArrayList<>();
        for (Job job : jobList) {
            if (job.getId() == id) {
                list.add(job);
            }
        }
        return list;
    }

    @Override
    public List<Job> searchName(String name) {
        List<Job> jobs = findAll();
        List<Job> jobList1 = new ArrayList<>();
        for (int i = 0; i < jobs.size(); i++) {
            if (jobs.get(i).getName().toUpperCase().contains(name.toLowerCase())) {
                jobList1.add(jobs.get(i));
            }
        }
        return jobList1;
    }
}
