//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fisier f = new Fisier("Mihnea", "e cel mai smecher!");
        f.afisare();
        f.salveazaVersiune();
        f.afisare();
        System.out.println();

        Fisier f2 = new Fisier("Levi","Boss");
        f2.salveazaVersiune();
        f2.afisare();
        System.out.println();

        Fisier f3 = new Fisier("Remetan", "intreadevar, e cel mai smecher!");
        f2.concateneaza(f3);
        f2.afisare();
        System.out.println();

        Fisier f4 = new Fisier("Szatmari", "e smecher si el!");
        f3.concateneaza(f4);
        f3.afisare();
        f3.concateneaza(f);
        System.out.println();

        System.out.println("Numarul concatenarilor este: " + f3.numaraConcatenarile());
    }
}