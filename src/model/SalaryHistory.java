package model;

import java.time.LocalDate;

public class SalaryHistory {
    private String id, name;
    private int age;
    private double updateSalary;
    private String status;
    private LocalDate date;

    public SalaryHistory(String id, String name, int age, double updateSalary, String status, LocalDate date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.updateSalary = updateSalary;
        this.status = status;
        this.date = date;
    }

    @Override
    public String toString() {
        return String.format(" %s | %-8s | %2d | %-7.2s | %-4s | %-10s ", id, name, age, updateSalary, status, date);
    }
}
