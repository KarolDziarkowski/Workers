import java.util.*;

public class ClassEmployee {
    private String nazwaGrupy;
    private List<Employee> pracownicy;
    private int maxPracownicy;

    public ClassEmployee(String nazwaGrupy, int maxPracownicy) {
        this.nazwaGrupy = nazwaGrupy;
        this.maxPracownicy = maxPracownicy;
        this.pracownicy = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        if (pracownicy.size() >= maxPracownicy) {
            System.out.println("Nie można dodać więcej pracowników do grupy " + nazwaGrupy);
            return;
        }
        if (pracownicy.stream().anyMatch(e -> e.getImie().equals(employee.getImie()) && e.getNazwisko().equals(employee.getNazwisko()))) {
            System.out.println("Pracownik o tym imieniu i nazwisku już istnieje.");
        } else {
            pracownicy.add(employee);
        }
    }

    public void addSalary(Employee employee, double kwota) {
        employee.setWynagrodzenie(employee.getWynagrodzenie() + kwota);
    }

    public void removeEmployee(Employee employee) {
        pracownicy.remove(employee);
    }

    public void changeCondition(Employee employee, EmployeeCondition newCondition) {
        employee.setStan(newCondition);
    }

    public Employee search(String nazwisko) {
        return pracownicy.stream()
                .filter(e -> e.getNazwisko().equals(nazwisko))
                .findFirst()
                .orElse(null);
    }

    public List<Employee> searchPartial(String fragment) {
        return pracownicy.stream()
                .filter(e -> e.getImie().contains(fragment) || e.getNazwisko().contains(fragment))
                .toList();
    }

    public long countByCondition(EmployeeCondition condition) {
        return pracownicy.stream().filter(e -> e.getStan() == condition).count();
    }

    public void summary() {
        pracownicy.forEach(Employee::printing);
    }

    public List<Employee> sortByName() {
        return pracownicy.stream().sorted().toList();
    }

    public List<Employee> sortBySalary() {
        return pracownicy.stream()
                .sorted((e1, e2) -> Double.compare(e2.getWynagrodzenie(), e1.getWynagrodzenie()))
                .toList();
    }

    public Employee max() {
        return Collections.max(pracownicy, Comparator.comparingDouble(Employee::getWynagrodzenie));
    }
}
