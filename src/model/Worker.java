package model;

import java.util.ArrayList;
import java.util.List;

public class Worker {
    private int age;
    private double salary;
    private String id, name, workLocation;
    private List<SalaryHistory> salaryHistoryList;

    public Worker() {
    }

    public Worker(String id, String name, int age, double salary, String workLocation, List<SalaryHistory> salaryHistoryList) {
        this.age = age;
        this.salary = salary;
        this.id = id;
        this.name = name;
        this.workLocation = workLocation;
        this.salaryHistoryList = salaryHistoryList;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary, String status) {
        SalaryHistory sh = new SalaryHistory(this, newSalary, status);
        salaryHistoryList.add(sh);
        this.salary = newSalary;
    }

    public List<SalaryHistory> getSalaryHistory() {
        return salaryHistoryList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "age=" + age +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", workLocation='" + workLocation + '\'' +
                '}';
    }
}
