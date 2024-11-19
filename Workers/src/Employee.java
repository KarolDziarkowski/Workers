public class Employee implements Comparable<Employee> {
    private String imie;
    private String nazwisko;
    private EmployeeCondition stan;
    private int rokUrodzenia;
    private double wynagrodzenie;

    public Employee(String imie, String nazwisko, EmployeeCondition stan, int rokUrodzenia, double wynagrodzenie) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stan = stan;
        this.rokUrodzenia = rokUrodzenia;
        this.wynagrodzenie = wynagrodzenie;
    }

    public void printing() {
        System.out.println("Imię: " + imie + ", Nazwisko: " + nazwisko + ", Stan: " + stan +
                ", Rok urodzenia: " + rokUrodzenia + ", Wynagrodzenie: " + wynagrodzenie);
    }

    @Override
    public int compareTo(Employee other) {
        return this.nazwisko.compareTo(other.nazwisko);
    }

    public String getNazwisko() { return nazwisko; }
    public String getImie() { return imie; }
    public EmployeeCondition getStan() { return stan; }
    public void setStan(EmployeeCondition stan) { this.stan = stan; }
    public double getWynagrodzenie() { return wynagrodzenie; }
    public void setWynagrodzenie(double wynagrodzenie) { this.wynagrodzenie = wynagrodzenie; }
}
