package kz.aitu.assik4sp.controllers;

import kz.aitu.assik4sp.models.Goal;
import kz.aitu.assik4sp.services.interfaces.GoalServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("goals")
public class GoalController {
    private final GoalServiceInterface service;

    public GoalController(GoalServiceInterface service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<Goal> getAll(){
        return service.getAll();
    }
    @GetMapping("/{goalid}")
    public ResponseEntity<Goal> getbyId(@PathVariable("goalid") int id){
        Goal goal = service.getById(id);
        if(goal==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(goal, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Goal> create(@RequestBody Goal goal){
        Goal createdGoal = service.create(goal);
        if(createdGoal==null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdGoal, HttpStatus.CREATED);
    }

    @GetMapping("/type/{type}")
    public List<Goal> getAllByType(@PathVariable("type") String type){
        return service.getByType(type);
    }
    @GetMapping("/startDate/{startDate}")
    public List<Goal> getAllByDate(@PathVariable("startDate") Date startDate){
        return service.getByStartDate(startDate);
    }
    @GetMapping("/targetValue/{targetValue}")
    public List<Goal> getAllByTargetValue(@PathVariable("targetValue") double targetValue){
        return service.getByTargetValue(targetValue);
    }
    @GetMapping("/durationDays/{durationDays}")
    public List<Goal> getAllByDurationDays(@PathVariable("durationDays") int durationDays){
        return service.getByDurationDays(durationDays);
    }
    @GetMapping("/achieved/{achieved}")
    public List<Goal> getAllByNotes(@PathVariable("achieved") boolean achieved){
        return service.getByAchieved(achieved);
    }
}
