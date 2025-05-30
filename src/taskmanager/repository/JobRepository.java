package taskmanager.repository;

import taskmanager.common.ReadAndWrite;
import taskmanager.entity.Job;

import java.util.ArrayList;
import java.util.List;

public class JobRepository implements IJobRepository {

    private static final String JOB_FILE = "src/taskmanager/data/job.csv";

    @Override
    public List<Job> findAll() {
        List<Job> jobList = new ArrayList<>();
        List<String> stringList = ReadAndWrite.readFileCSV(JOB_FILE);
        String[] array;
        for (int i = 0; i < stringList.size(); i++) {
            array = stringList.get(i).split(",");
            Job job = new Job(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]), array[4]);
            jobList.add(job);
        }
        return jobList;
    }


    @Override
    public void add(Job job) {
        List<String> stringList = new ArrayList<>();
        stringList.add(job.getInToFile());
        ReadAndWrite.writeFileCSV(JOB_FILE, stringList, true);
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
        boolean check = false;
        for (int i = 0; i < jobList.size(); i++) {
            if (id == jobList.get(i).getId()) {
                check = true;
                jobList.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for (Job j : jobList) {
            stringList.add(j.getInToFile());
        }
        ReadAndWrite.writeFileCSV(JOB_FILE, stringList, false);
        return check;
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
        List<String> stringList = new ArrayList<>();
        for (Job j : jobList) {
            stringList.add(j.getInToFile());
        }
        ReadAndWrite.writeFileCSV(JOB_FILE, stringList, false);
    }


    @Override
    public List<Job> searchId(int id) {
        List<Job> jobList = findAll();
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
        List<Job> matchedJobs = new ArrayList<>();
        String searchLower = name.toLowerCase();

        for (Job job : jobs) {
            if (job.getName().toLowerCase().contains(searchLower)) {
                matchedJobs.add(job);
            }
        }
        return matchedJobs;
    }

}
