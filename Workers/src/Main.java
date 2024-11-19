import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Tworzenie i dodawanie grupy pracowników
        ClassContainer container = new ClassContainer();
        container.addClass("Grupa1", 5);
        container.addClass("Grupa2", 3);

        Employee emp1 = new Employee("Jan", "Kowalski", EmployeeCondition.OBECNY, 1985, 5000);
        Employee emp2 = new Employee("Anna", "Nowak", EmployeeCondition.DELEGACJA, 1990, 5500);
        Employee emp3 = new Employee("Piotr", "Nowicki", EmployeeCondition.CHORY, 1988, 4500);
        Employee emp4 = new Employee("Ewa", "Kowalczyk", EmployeeCondition.NIEOBECNY, 1992, 5200);

        // Dodawanie pracowników do grupy
        ClassEmployee grupa1 = container.getClassEmployee("Grupa1");
        if (grupa1 != null) {
            grupa1.addEmployee(emp1);
            grupa1.addEmployee(emp2);
            grupa1.addEmployee(emp3);
            grupa1.addEmployee(emp4);

            // Wyświetlenie podsumowania grupy
            System.out.println("Podsumowanie Grupa1:");
            grupa1.summary();

            // Zwiększenie wynagrodzenia jednemu z pracowników
            System.out.println("\nDodanie wynagrodzenia:");
            grupa1.addSalary(emp1, 1000);
            emp1.printing();

            // Zmiana statusu pracownika
            System.out.println("\nZmiana statusu:");
            grupa1.changeCondition(emp2, EmployeeCondition.OBECNY);
            emp2.printing();

            // Wyszukiwanie pracownika po nazwisku
            System.out.println("\nWyszukiwanie po nazwisku 'Nowak':");
            Employee found = grupa1.search("Nowak");
            if (found != null) {
                found.printing();
            }

            // Wyszukiwanie częściowe po fragmencie
            System.out.println("\nWyszukiwanie częściowe po fragmencie 'Ko':");
            List<Employee> partialSearch = grupa1.searchPartial("Ko");
            partialSearch.forEach(Employee::printing);

            // Liczba pracowników w stanie DELEGACJA
            System.out.println("\nLiczba pracowników w stanie DELEGACJA:");
            long count = grupa1.countByCondition(EmployeeCondition.DELEGACJA);
            System.out.println("Liczba: " + count);

            // Sortowanie pracowników po nazwisku
            System.out.println("\nSortowanie po nazwisku:");
            List<Employee> sortedByName = grupa1.sortByName();
            sortedByName.forEach(Employee::printing);

            // Sortowanie pracowników po wynagrodzeniu
            System.out.println("\nSortowanie po wynagrodzeniu:");
            List<Employee> sortedBySalary = grupa1.sortBySalary();
            sortedBySalary.forEach(Employee::printing);

            // Pracownik z najwyższym wynagrodzeniem
            System.out.println("\nPracownik z najwyższym wynagrodzeniem:");
            Employee maxSalaryEmployee = grupa1.max();
            maxSalaryEmployee.printing();
        }

        // Wyświetlenie podsumowania wszystkich grup w ClassContainer
        System.out.println("\nPodsumowanie wszystkich grup:");
        container.summary();
    }
}
