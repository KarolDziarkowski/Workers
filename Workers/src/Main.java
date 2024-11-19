public class Main {
    public static void main(String[] args) {
        // Przykładowe użycie klas
        ClassContainer container = new ClassContainer();
        container.addClass("Grupa1", 5);

        Employee emp1 = new Employee("Jan", "Kowalski", EmployeeCondition.OBECNY, 1985, 5000);
        Employee emp2 = new Employee("Anna", "Nowak", EmployeeCondition.DELEGACJA, 1990, 5500);

        ClassEmployee grupa1 = container.getClassEmployee("Grupa1"); // użycie metody getClassEmployee
        if (grupa1 != null) {
            grupa1.addEmployee(emp1);
            grupa1.addEmployee(emp2);
            grupa1.summary();
        }
    }
}
