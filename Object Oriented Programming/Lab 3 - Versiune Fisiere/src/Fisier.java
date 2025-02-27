public class Fisier {
    private String nume;
    private String continut;
    private int id;
    private static int contor=0;
    private Fisier prev = null;
    private int nrConcatenari = 0;

    public Fisier(String nume, String continut){
        this.nume = nume;
        this.continut = continut;
        id=contor;
        contor++;

    }

    public Fisier salveazaVersiune(){
        contor--; //scad ca sa am aceeasi dimensiune cu cea a obiectului de tip fisier creat
        Fisier f1 = new Fisier(this.nume,this.continut);
        f1.id=this.id;
        f1.prev=this.prev;
        this.prev=f1;
        return f1;
    }

    public void afisare(){
        System.out.println("Nume: " + this.nume + "\n" + "Continut: " + this.continut + "\n" + "ID: " + this.id);
        if(this.prev == null)
            System.out.println("ID-ul anterior nu exista!");
        else
            System.out.println("ID anterior: " + this.prev.id);
    }

    public void concateneaza(Fisier f2){
        salveazaVersiune();
        this.continut = this.continut + f2.continut;
        nrConcatenari++;
    }

    public String toString(){
        if(this.prev == null)
            return "Nume: " + nume + "\n" + "ID: " + id + "\n" + "Continut: " + continut + "\n" + "Continut anterior - null";
        else
            return "Nume: " + nume + "\n" + "ID: " + id + "\n" + "Continut: " + continut + "\n" + "Continut anterior" + prev.continut;
    }

    public int numaraConcatenarile(){
        return nrConcatenari;
    }
}
