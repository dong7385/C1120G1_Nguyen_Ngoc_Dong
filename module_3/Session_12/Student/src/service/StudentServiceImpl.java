package service;

import model.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentRepository repository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Student student) {
        repository.save(student);
    }

    @Override
    public Student findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }
}
