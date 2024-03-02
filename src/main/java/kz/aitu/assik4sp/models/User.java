package kz.aitu.assik4sp.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.sql.Date;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userid;
    private String fname;
    private String sname;
    private Date dateofbirth;
    private int height;
    private int weight;
    private String gender;
    @Getter
    private String username;
    private String password;

    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public double calculateBMI() {
        double heightInMeters = height / 100.0;
        return weight / (heightInMeters * heightInMeters);
    }
}
