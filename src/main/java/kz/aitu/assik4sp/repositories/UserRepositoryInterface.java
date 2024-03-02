package kz.aitu.assik4sp.repositories;
import java.sql.Date;
import java.util.List;
import kz.aitu.assik4sp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User, Integer> {
    List<User> findBySname(String sname);
    List<User> findByFname(String fname);
    List<User> findByDateofbirth(Date dateofbirth);
    List<User> findByHeight(int height);
    List<User> findByWeight(int weight);
    List<User> findByGender(String gender);
    User findByUsername(String username);
}
