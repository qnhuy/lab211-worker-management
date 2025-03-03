package model;

public class Worker {
    private int age;
    private double salary;
    private String id, name, workLocation;

    public Worker() {
    }

    public Worker(String id, String name, int age, double salary, String workLocation) {
        this.age = age;
        this.salary = salary;
        this.id = id;
        this.name = name;
        this.workLocation = workLocation;
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

    public void setSalary(double salary) {
        this.salary = salary;
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
}
