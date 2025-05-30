package taskmanager.repository;

import taskmanager.common.ReadAndWrite;
import taskmanager.entity.Job;

import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {

    private static final String JOB_FILE = "src/taskmanager/data/job.dat";

    @Override
    public List<Job> findAll() {
        return ReadAndWrite.readFileToBinary(JOB_FILE);
    }

    @Override
    public void add(Job job) {
        List<Job> jobList = findAll();
        jobList.add(job);
        ReadAndWrite.writeFileToBinary(JOB_FILE, jobList);
    }

    @Override
    public boolean checkId(int id) {
        for (Job job : findAll()) {
            if (job.getId() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        List<Job> jobList = findAll();
        boolean removed = jobList.removeIf(job -> job.getId() == id);
        if (removed) {
            ReadAndWrite.writeFileToBinary(JOB_FILE, jobList);
        }
        return removed;
    }

    @Override
    public void updateById(int id, Job job) {
        List<Job> jobList = findAll();
        for (int i = 0; i < jobList.size(); i++) {
            if (jobList.get(i).getId() == id) {
                jobList.set(i, job);
                break;
            }
        }
        ReadAndWrite.writeFileToBinary(JOB_FILE, jobList);
    }

    @Override
    public List<Job> searchId(int id) {
        List<Job> jobList = findAll();
        List<Job> result = new ArrayList<>();
        for (Job job : jobList) {
            if (job.getId() == id) {
                result.add(job);
            }
        }
        return result;
    }

    @Override
    public List<Job> searchName(String name) {
        List<Job> jobList = findAll();
        List<Job> result = new ArrayList<>();
        String keyword = name.toLowerCase();
        for (Job job : jobList) {
            if (job.getName().toLowerCase().contains(keyword)) {
                result.add(job);
            }
        }
        return result;
    }
}
