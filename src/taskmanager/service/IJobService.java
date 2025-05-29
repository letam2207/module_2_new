package taskmanager.service;

import taskmanager.common.IdNotFoundException;
import taskmanager.common.UniqueIDException;
import taskmanager.entity.Job;

import java.util.List;

public interface IJobService {
    List<Job> findAll();

    void add(Job job) throws UniqueIDException;


    boolean  checkId(int id);

    Job findById(int id);
    boolean delete(int id) throws IdNotFoundException;


    void updateById(int id,Job job);

    List<Job> searchId(int id);

    List<Job> searchName(String name);
}
