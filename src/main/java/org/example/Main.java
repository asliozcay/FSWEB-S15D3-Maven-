package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {
    private static Map<Integer, Employee> employeeMap;
    private static List<Employee> duplicatedEmployees;
    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Aslı", "Özçay"));
        employees.add(new Employee(2, "Sevil", "Eren"));
        employees.add(new Employee(3, "Mustafa Ali", "Eren"));
        employees.add(new Employee(1, "Aslı", "Özçay"));
        employees.add(new Employee(4, "Eylül", "Eren"));
    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        employeeMap = new HashMap<>();
        duplicatedEmployees = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employee == null) {
                System.out.println("null");
                continue;
            }
            if(employeeMap.containsKey(employee.getId())){
                duplicatedEmployees.add(employee);
            }
            else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployees;
    }
    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        Iterator<Employee> iterator = employees.iterator();
        employeeMap = new HashMap<>();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee == null) {
                System.out.println("null");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())) {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees){
        List<Employee> duplicates = findDuplicates(employees);
        Map<Integer, Employee> uniques = findUniques(employees);
        List<Employee> onlyUnique = new LinkedList<>(uniques.values());
        onlyUnique.removeAll(duplicates);
        return onlyUnique;
    }
}