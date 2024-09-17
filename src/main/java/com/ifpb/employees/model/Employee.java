package com.ifpb.employees.model;

public class Employee {
    private int id;
    private String name;
    private String email;
    private String entrance;
    private String role;
    private double salary;
    
    public Employee(int id, String name, String email, String entrance, String role, double salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.entrance = entrance;
        this.role = role;
        this.salary = salary;
    }

    public Employee(String name, String email, String entrance, String role, double salary) {
        this.name = name;
        this.email = email;
        this.entrance = entrance;
        this.role = role;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEntrance() {
        return entrance;
    }

    public void setEntrance(String entrance) {
        this.entrance = entrance;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
