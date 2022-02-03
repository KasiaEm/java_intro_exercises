package com.sda.ex13;

public class Employee {
    private String firstName;
    private String lastName;
    private Department deparment;
    private Double salary;
    private Employee[] subordinates;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public Employee(String firstName, String lastName, Department deparment, Double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.deparment = deparment;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDeparment() {
        return deparment;
    }

    public void setDeparment(Department deparment) {
        this.deparment = deparment;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Employee[] getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Employee... subordinates) {
        this.subordinates = subordinates;
        if (this.deparment != null) {
            for (Employee subordinate : subordinates) {
                subordinate.setDeparment(this.deparment);
            }
        }
    }

    public void printSubordinates() {
        for (Employee subordinate : subordinates) {
            System.out.println(subordinate);
        }
    }

    public void printAllSubordinates() {
        for (Employee subordinate : subordinates) {
            System.out.println(subordinate);
            subordinate.printSubordinates();
        }
    }

    public void raise(double percent) {
        this.salary *= (1 + percent);
        if (subordinates != null) {
            for (Employee subordinate : subordinates) {
                subordinate.raise(percent);
            }
        }
    }

    public void sendMessage(String message) {
        System.out.println(this.firstName
                + " " + this.lastName
                + ", " + this.deparment
                + ", OK: " + message);
        if (subordinates != null) {
            for (Employee subordinate : subordinates) {
                subordinate.sendMessage(message);
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" + firstName + " " + lastName +
                ", " + deparment +
                ", " + salary +
                "$}";
    }
}
