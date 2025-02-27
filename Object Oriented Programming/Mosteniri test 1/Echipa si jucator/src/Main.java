class Jucator{
    private String numeJucator;
    private int numarTricou;

    public Jucator(String numeJucator, int numarTricou){
        this.numeJucator = numeJucator;
        this.numarTricou = numarTricou;
    }

    public boolean equals(Object o){
        if(o instanceof Jucator){
            Jucator aux = (Jucator)o;
            return numeJucator.equals(aux.numeJucator) && numarTricou == aux.numarTricou;
        }
        return false;
    }

    public String afisare(){
        return "(<" + this.numeJucator + ">, <" + this.numarTricou + ">)" + "   ";
    }
}

class Echipa{
    private Jucator[] titulari = new Jucator[11];
    private Jucator[] rezerve = new Jucator[11];

    public Echipa(Jucator[] titulari, Jucator[] rezerve){
        this.titulari = titulari;
        this.rezerve = rezerve;
    }

    public boolean efectueazaSchimbare(Jucator t, Jucator r){
        int ok = 0;
        int pozTitular = 0, pozRezerva = 0;

        for(int i = 0; i < titulari.length; i++){
            if(t.equals(titulari[i])){
                pozTitular = i;
                ok++;
                break;
            }
        }

        for(int i = 0; i < rezerve.length; i++){
            if(r.equals(rezerve[i])){
                pozRezerva = i;
                ok++;
                break;
            }
        }

        if(ok != 2)
            return false;

        titulari[pozTitular] = r;
        rezerve[pozRezerva] = t;
        return true;
    }

    public String toString(){
        String s = "Titulari: ";
        for(int i = 0; i < titulari.length; i++)
            s = s + titulari[i].afisare();

        s = s + "\nRezerve: ";
        for(int i = 0; i < rezerve.length; i++)
            s = s + rezerve[i].afisare();

        return s;
    }
}

class Main{
    public static void main(String[] argv){

        Jucator j1 = new Jucator("Baluta", 25);
        Jucator j2 = new Jucator("Tanase", 7);
        Jucator j3 = new Jucator("Tavi Popescu", 10);
        Jucator j4 = new Jucator("Birligea", 9);
        Jucator j5 = new Jucator("Miculescu", 11);

        Jucator[] titulari = {j1, j3, j4};
        Jucator[] rezerve = {j2, j5};

        Echipa e = new Echipa(titulari, rezerve);
        System.out.println(e);

        System.out.println();
        e.efectueazaSchimbare(j1, j5);
        System.out.println("Echipa dupa schimbare: " + e);
    }
}