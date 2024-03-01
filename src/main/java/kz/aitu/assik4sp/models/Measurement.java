package kz.aitu.assik4sp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "measurements")
public class Measurement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int measurementid; // Unique identifier for each measurement

    private String type; // Type of measurement
    private Date date; // Date when the measurement was taken
    private double value; // Value of the measurement
    private String unit; // Unit of measurement (e.g., cm, kg, etc.)
}
