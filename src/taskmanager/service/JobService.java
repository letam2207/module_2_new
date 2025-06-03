package taskmanager.service;

import taskmanager.common.IdNotFoundException;
import taskmanager.common.UniqueIDException;
import taskmanager.entity.Job;
import taskmanager.repository.IJobRepository;
import taskmanager.repository.JobRepository;

import java.util.List;

public class JobService implements IJobService {

    public static IJobRepository jobRepository = new JobRepository();

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void add(Job job) throws UniqueIDException {
        if (checkId(job.getId())) {
            throw new UniqueIDException("Mã chi tiêu đã tồn tại: " + job.getId());
        }
        jobRepository.add(job);
    }



    @Override
    public boolean checkId(int id) {
        return jobRepository.checkId(id);
    }



    @Override
    public boolean delete(int id) throws IdNotFoundException {
        if (!jobRepository.checkId(id)) {
            throw new IdNotFoundException("Không tìm thấy mã chi tiêu: " + id);
        }
        return jobRepository.delete(id);
    }


    @Override
    public void updateById(int id,Job job) {
        jobRepository.updateById(id,job);
    }

    @Override
    public List<Job> searchId(int id) {
        return jobRepository.searchId(id);
    }

    @Override
    public List<Job> searchName(String name) {
        return jobRepository.searchName(name);
    }
}
