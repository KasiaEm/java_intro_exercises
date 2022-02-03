package com.sda.ex13;

public class EmployeeManager {
    private static Employee ceo;
    private static Employee headIT;
    private static Employee headFinances;

    public static void main(String[] args) {
        prepareData();

        ceo.printAllSubordinates();
        headIT.raise(0.15);
        System.out.println("RAISE IN IT");
        ceo.printAllSubordinates();
        System.out.println("MEETING");
        ceo.sendMessage("Meeting on Monday 7am!");

    }

    private static void prepareData() {
        ceo = new Employee("John", "Smith", 100000d);
        headIT = new Employee("Mark", "Brown", Department.IT, 90000d);
        headFinances = new Employee("Dora", "Black", Department.FINANCES, 80000d);
        Employee emp1IT = new Employee("Clara", "Jones", 40000d);
        Employee emp2IT = new Employee("Frank", "Mayer", 35000d);
        Employee emp1Finance = new Employee("Tonya", "Hanks", 25000d);
        Employee emp2Finance = new Employee("Ursula", "Perry", 20000d);



        ceo.setSubordinates(headIT, headFinances);
        headIT.setSubordinates(emp1IT, emp2IT);
        headFinances.setSubordinates(emp1Finance, emp2Finance);
    }
}
