class Angajat{
    private String numeAngajat;
    private int salariu;

    public Angajat(String numeAngajat, int salariu){
        this.numeAngajat = numeAngajat;
        this.salariu = salariu;
    }

    public String getNumeAngajat(){
        return numeAngajat;
    }

    public String afisare(){
        return "Angajat: <" + this.numeAngajat + "> - <" + this.salariu + ">\n";
    }

    public int getSalariu(){
        return salariu;
    }

}

class Firma{
    private String numeFirma;
    private int buget;

    public Firma(String numeFirma, int buget){
        this.numeFirma = numeFirma;
        this.buget = buget;
    }

    Angajat[] angajati = new Angajat[30];
    int nrAngajati = 0;

    public boolean adaugaAngajat(Angajat a){
        if(nrAngajati >= 30)
            return false;

        for(int i = 0; i < nrAngajati; i++)
            if((a.getNumeAngajat()).equals(angajati[i].getNumeAngajat()))
                return false;

        angajati[nrAngajati++] = a;
        return true;
    }

    public String toString(){
        String s = "Nume firma: " + this.numeFirma + "\n";
        for(int i = 0; i < nrAngajati; i++)
            s = s + angajati[i].afisare();

        return s;
    }

    public int platesteSalarii(){
        int s = 0;
        for(int i = 0; i < nrAngajati; i++)
            s = s + angajati[i].getSalariu();

        buget = buget - s;
        return buget;
    }
}

class Main{
    public static void main(String[] argv){
        Firma f = new Firma("Altex", 75000);
        Angajat a1 = new Angajat("Mihnea", 5000);
        Angajat a2 = new Angajat("Rares", 3000);
        Angajat a3 = new Angajat("Corina", 15000);
        f.adaugaAngajat(a1);
        f.adaugaAngajat(a2);
        f.adaugaAngajat(a3);

        System.out.println(f);

        f.adaugaAngajat(a2);
        System.out.println(f);
        
        System.out.println("Bugetul firmei ramas dupa platirea salariilor este de " + f.platesteSalarii() + " lei!");
    }
}