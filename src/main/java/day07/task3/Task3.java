package day07.task3;

import java.util.*;
import java.util.stream.Collectors;

public class Task3 {
    public record EmployeeInfo(
            long id,
            String name,
            String department,
            long monthlySalaryInCents,
            boolean active
    ) { }

    public static class EmployeeAnalytics {
        public static Map<String, List<EmployeeInfo>> groupActiveByDepartment(
                List<EmployeeInfo> employees
        ) {
            if (employees == null) throw new IllegalArgumentException("Employees can't be empty");
            if (employees.stream().anyMatch(employee -> employee == null)) {
                throw new IllegalArgumentException("Employees can't contain null");
            }

            Map<String, List<EmployeeInfo>> result = employees.stream()
                    .filter(EmployeeInfo::active)
                    .collect(Collectors.groupingBy(EmployeeInfo::department));

            return result;
        }

        public static Map<String, Double> calculateAverageSalaryByDepartment(
                List<EmployeeInfo> employees
        ) {
            if (employees == null) throw new IllegalArgumentException("Employees can't be empty");
            if (employees.stream().anyMatch(employee -> employee == null)) {
                throw new IllegalArgumentException("Employees can't contain null");
            }

            Map<String, Double> result = employees.stream()
                    .collect(Collectors.groupingBy(EmployeeInfo::department,
                            Collectors.averagingLong(EmployeeInfo::monthlySalaryInCents)
                    ));

            return result;
        }

        public static Optional<EmployeeInfo> findHighestPaidActiveEmployee(
                List<EmployeeInfo> employees
        ) {
            if (employees == null) throw new IllegalArgumentException("Employees can't be empty");
            if (employees.stream().anyMatch(employee -> employee == null)) {
                throw new IllegalArgumentException("Employees can't contain null");
            }

            Optional<EmployeeInfo> result = employees.stream()
                    .filter(EmployeeInfo::active)
                    .max(Comparator.comparingLong(EmployeeInfo::monthlySalaryInCents));

            return result;
        }
    }

    public static void main(String[] args) {
        List<EmployeeInfo> employees = List.of(
                new EmployeeInfo(1L, "Anna", "IT", 850_000L, true),
                new EmployeeInfo(2L, "Mark", "IT", 720_000L, true),
                new EmployeeInfo(3L, "Kate", "IT", 680_000L, false),

                new EmployeeInfo(4L, "John", "Sales", 600_000L, true),
                new EmployeeInfo(5L, "Emma", "Sales", 550_000L, false),

                new EmployeeInfo(6L, "Olivia", "HR", 580_000L, false),
                new EmployeeInfo(7L, "Daniel", "HR", 620_000L, false)
        );

        System.out.println(EmployeeAnalytics.groupActiveByDepartment(employees));
        System.out.println(EmployeeAnalytics.calculateAverageSalaryByDepartment(employees));
        System.out.println(EmployeeAnalytics.findHighestPaidActiveEmployee(employees)
                .map(EmployeeInfo::name).orElse("No active employees"));

        System.out.println(EmployeeAnalytics.findHighestPaidActiveEmployee(new ArrayList<>())
                .map(EmployeeInfo::name).orElse("No active employees"));

        try {
            EmployeeAnalytics.groupActiveByDepartment(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            EmployeeAnalytics.calculateAverageSalaryByDepartment(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            EmployeeAnalytics.findHighestPaidActiveEmployee(null);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        List<EmployeeInfo> listWithNull = new ArrayList<>();
        listWithNull.add(null);

        try {
            EmployeeAnalytics.groupActiveByDepartment(listWithNull);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            EmployeeAnalytics.calculateAverageSalaryByDepartment(listWithNull);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            EmployeeAnalytics.findHighestPaidActiveEmployee(listWithNull);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
