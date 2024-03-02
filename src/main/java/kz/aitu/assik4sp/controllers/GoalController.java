package kz.aitu.assik4sp.controllers;

import kz.aitu.assik4sp.models.Measurement;
import kz.aitu.assik4sp.services.interfaces.MeasurementServiceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("measurements")
public class MeasurementController {
    private final MeasurementServiceInterface service;

    public MeasurementController(MeasurementServiceInterface service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<Measurement> getAll(){
        return service.getAll();
    }
    @GetMapping("/{measurementid}")
    public ResponseEntity<Measurement> getbyId(@PathVariable("measurementid") int id){
        Measurement measurement = service.getById(id);
        if(measurement==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(measurement, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Measurement> create(@RequestBody Measurement measurement){
        Measurement createdMeasurement = service.create(measurement);
        if(createdMeasurement==null)
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(createdMeasurement, HttpStatus.CREATED);
    }

    @GetMapping("/type/{type}")
    public List<Measurement> getAllByType(@PathVariable("type") String type){
        return service.getByType(type);
    }
    @GetMapping("/date/{date}")
    public List<Measurement> getAllByDate(@PathVariable("date") Date date){
        return service.getByDate(date);
    }

    @GetMapping("/value/{value}")
    public List<Measurement> getAllByValue(@PathVariable("value") double value){
        return service.getByValue(value);
    }

    @GetMapping("/unit/{unit}")
    public List<Measurement> getAllByUnit(@PathVariable("unit") String unit){
        return service.getByUnit(unit);
    }
}
