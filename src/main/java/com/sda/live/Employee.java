package com.sda.live;

public class Employee {
    private String name;
    private String lastName;
    private Department department;
    private double salary;
    private Employee[] employees = new Employee[0];

    public Employee(String name) {
        this.name = name;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
        for (int i = 0; i < employees.length; i++) {
            employees[i].department = this.department;
        }
    }

    public void showSubordinates() {
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public void showAllSubordinates(){
        this.showSubordinates();
        for (Employee e : employees) {
            e.showAllSubordinates();
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", salary=" + salary +
                '}';
    }
}
