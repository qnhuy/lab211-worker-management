package model;

import java.time.LocalDate;
import java.util.Date;

public class SalaryHistory {
    private Worker worker;
    private double newSalary;
    private String status;
    private LocalDate date;

    public SalaryHistory(Worker worker, double newSalary, String status) {
        this.worker = worker;
        this.newSalary = newSalary;
        this.status = status;
        this.date = LocalDate.now();
    }

    public double getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(double newSalary) {
        this.newSalary = newSalary;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(" %s | %-8s | %-6.1f | %-7s | %s ",
                worker.getId(), worker.getName(), newSalary, status, date);
    }
}
