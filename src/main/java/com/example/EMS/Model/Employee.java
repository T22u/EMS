package com.example.EMS.Model;

import javax.persistence.*;

@Entity
@Table(name = "Employee_Table")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name = "First_Name")
    private String First_Name;
    @Column(name = "Last_Name")
    private String Last_Name;
    @Column(name = "Email")
    private String Email;
    @Column(name = "Phone")
    private String Phone;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
