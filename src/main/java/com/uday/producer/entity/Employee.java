package com.uday.producer.entity;

import java.time.LocalDateTime;

public class Employee {
    private String employeeId;
    private String employeeName;
    private LocalDateTime createdOn;

    public Employee(String employeeId, String employeeName, LocalDateTime createdOn) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.createdOn = createdOn;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
