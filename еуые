package kz.aitu.assik4sp.repositories;

import kz.aitu.assik4sp.models.Activity;

import java.sql.Time;
import java.sql.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepositoryInterface extends JpaRepository<Activity, Integer>{
    List<Activity> findByType(String type);
    List<Activity> findByDate(Date date);
    List<Activity> findByCalories(int calories_burned);
    List<Activity> findByDuration(Time time);
    List<Activity> findByDistance(double distance);
    List<Activity> findByNotes(String notes);
}
