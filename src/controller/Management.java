package controller;

import model.SalaryHistory;
import model.Worker;
import validation.Validation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Management {
    private Scanner sc = new Scanner(System.in);

    private List<Worker> wList;
    private List<SalaryHistory> shList;

    public Management() {
        wList = new ArrayList<>();
        shList = new ArrayList<>();
    }

    public void addWorker() {
        System.out.println("------Add Worker------");
        String id, name, workLocation;
        int age;
        double salary;

        id = Validation.getCode("Enter ID: ", "ID can not be null or empty!", wList, 1);
        name = Validation.getString("Enter name: ", "Name cannot be empty!");
        age = Validation.getInt("Enter age: ", 18, 50);
        salary = Validation.getDouble("Enter salary: ", 0.000001, Double.MAX_VALUE);
        workLocation = Validation.getString("Enter work location: ", "Work location cannot be empty!");
        Worker w = new Worker(id, name, age, salary, workLocation);
        wList.add(w);
    }

    public void updateSalary(int salaryMode) {
        System.out.println("------Update Salary------");
        String id = Validation.getCode("Enter worker ID to be update: ", "ID must be existed and can not be null or empty!", wList, 2);
        double updateMoney = Validation.getDouble("Enter update salary: ", 0.000001, Double.MAX_VALUE);
        String status = "";
        double update = 0;
        Worker w = Validation.checkWorker(id, wList);

        if (salaryMode == 1) {
            update = w.getSalary() + updateMoney;
            status = "UP";
        } else if (salaryMode == 2) {
            if (w.getSalary() > updateMoney) {
                update = w.getSalary() - updateMoney;
                status = "DOWN";
            }
        }

        SalaryHistory sh = new SalaryHistory(id, w.getName(), w.getAge(), w.getSalary(), status, java.time.LocalDate.now());
    }

    public void getInformation() {
        display(shList);
    }

    public void displayAll() {
        display(wList);
    }

    private void display(List l) {
        for (Object o : l) {
            System.out.println(o);
        }
    }
}
