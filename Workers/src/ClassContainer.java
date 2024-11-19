import java.util.HashMap;
import java.util.Map;

public class ClassContainer {
    private Map<String, ClassEmployee> grupyPracownicze;

    public ClassContainer() {
        this.grupyPracownicze = new HashMap<>();
    }

    public void addClass(String nazwa, int maxPracownicy) {
        grupyPracownicze.put(nazwa, new ClassEmployee(nazwa, maxPracownicy));
    }

    public void removeClass(String nazwa) {
        grupyPracownicze.remove(nazwa);
    }

    public ClassEmployee getClassEmployee(String nazwa) {
        return grupyPracownicze.get(nazwa);
    }

    public void summary() {
        grupyPracownicze.forEach((nazwa, grupa) -> {
            double procentoweZapelnienie = (double) grupa.sortByName().size() / grupa.sortByName().size() * 100;
            System.out.println("Nazwa grupy: " + nazwa + ", Zapełnienie: " + procentoweZapelnienie + "%");
        });
    }
}
