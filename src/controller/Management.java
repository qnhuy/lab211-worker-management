package controller;

import model.SalaryHistory;
import model.Worker;
import validation.Validation;

import java.util.ArrayList;
import java.util.Comparator;
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

        id = Validation.getCode("Enter code: ", "Code can not be existed or empty!", wList, 1);
        name = Validation.getString("Enter name: ", "Name cannot be empty!");
        age = Validation.getInt("Enter age: ", 18, 50);
        salary = Validation.getDouble("Enter salary: ", 0.000001, Double.MAX_VALUE);
        workLocation = Validation.getString("Enter work location: ", "Work location cannot be empty!");
        Worker w = new Worker(id, name, age, salary, workLocation, new ArrayList<SalaryHistory>());
        wList.add(w);
    }

    public void updateSalary(int salaryMode) {
        System.out.println("------Up/Down Salary------");
        String status = "";

        String id = Validation.getCode("Enter worker code to be update: ", "Code must be existed and can not be null or empty!", wList, 2);
        Worker w = Validation.checkWorker(id, wList);

        System.out.println("Salary of current worker: " + w.getSalary());

        while (true) {
            double updateSalary = Validation.getDouble("Enter update salary: ", 0.000001, Double.MAX_VALUE);
            if (salaryMode == 1 && updateSalary > w.getSalary()) {
                w.setSalary(updateSalary, "UP");
                break;
            } else if (salaryMode == 2 && updateSalary < w.getSalary()) {
                w.setSalary(updateSalary, "DOWN");
                break;
            }
            System.err.println("Input salary is invalid. Please try again!");

        }
    }

    public void displaySalaryHistory() {
        //save salary history of all worker into a list (include worker infor)
        List<SalaryHistory> allSalaryHistory = new ArrayList<>();
        for (Worker w : wList) {
            allSalaryHistory.addAll(w.getSalaryHistory());
        }

        //sort by id
        allSalaryHistory.sort(Comparator.comparing(aSH -> aSH.getWorker().getId()));

        if (allSalaryHistory.isEmpty()) {
            System.err.println("Nothing to display!");
        } else {
            for (SalaryHistory sh : allSalaryHistory) {
                System.out.println(sh);
            }
        }
    }

    public void displayAllWorker() {
        for(Worker w : wList) {
            System.out.println(w);
        }
    }

    public void displayWorkerSalary() {
        String id = Validation.getCode("Enter code: ", "Code can not be null or empty!", wList, 2);
        Worker w = Validation.checkWorker(id, wList);

        for (SalaryHistory sh : w.getSalaryHistory()) {
            System.out.println(sh);
        }
    }
}