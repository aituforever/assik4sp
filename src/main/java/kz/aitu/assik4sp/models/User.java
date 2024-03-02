package kz.aitu.assik4sp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid; // Unique identifier for each user

    private String fname; // First name of the user
    private String sname; // Surname of the user
    private Date dateofbirth; // Date of birth of the user
    private int height; // Height of the user in centimeters
    private int weight; // Weight of the user in kilograms
    private String gender; // Gender of the user 
}
