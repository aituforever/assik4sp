package kz.aitu.assik4sp.services;

import kz.aitu.assik4sp.models.User;
import kz.aitu.assik4sp.repositories.UserRepositoryInterface;
import kz.aitu.assik4sp.services.interfaces.UserServiceInterface;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
@Service

public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface repo;

    public UserService(UserRepositoryInterface repo) {
        this.repo = repo;
    }

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User getById(int id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public User create(User user) {
        return repo.save(user);
    }

    @Override
    public List<User> getByFname(String fname) {
        return repo.findByFname(fname);
    }

    @Override
    public List<User> getBySurname(String sname) {
        return repo.findBySname(sname);
    }

    @Override
    public List<User> getByDateofbirth(Date dateofbirth) {
        return repo.findByDateofbirth(dateofbirth);
    }

    @Override
    public List<User> getByHeight(int height) {
        return repo.findByHeight(height);
    }

    @Override
    public List<User> getByWeight(int weight) {
        return repo.findByWeight(weight);
    }
    @Override
    public List<User> getByGender(String gender) {
        return repo.findByGender(gender);
    }

    @Override
    public User getByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public double getBMI(int id) {
        User user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }
        return user.calculateBMI();
    }
}
