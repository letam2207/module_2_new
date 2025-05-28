package taskmanager.repository;

import taskmanager.entity.Job;

import java.util.List;

public interface IJobRepository {
    List<Job> findAll();

    void add(Job job);

    boolean checkId(int id);

    Job findById(int id);

    boolean delete(int id);

    void updateById(int id,Job job);

    List<Job> searchId(int id);

    List<Job> searchName(String name);

}
