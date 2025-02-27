class Telefon{
    private String numeProprietar;
    private String[] apeluri = new String[100];
    private int counter;

    public Telefon(String nume){
        this.numeProprietar = nume;
    }

    public boolean apeleaza(Telefon apelat){
        if(apelat.counter >= 100)
            return false;

        apelat.apeluri[apelat.counter++] = numeProprietar;
        return true;
    }

    public void afisare(){
        System.out.println("Nume proprietar: " + this.numeProprietar);
        System.out.println("Lista apeluri: ");
        for(int i = 0; i < counter; i++)
            System.out.println(this.apeluri[i] + " ");
    }

    public int numarDeApeluri(String nume){
        int count = 0;
        for(int i = 0; i < counter; i++)
            if(this.apeluri[i].equals(nume))
                count++;

        return count;
    }

    public String toString(){
        String s = "Nume proprietar: " + numeProprietar + "\nlista apeluri: ";
        for(int i = 0; i < counter; i++)
            s = s + this.apeluri[i] + " ";

        return s;
    }
}

class Main{
    public static void main(String[] args){
        Telefon t1 = new Telefon("Mihnea");
        Telefon t2 = new Telefon("Rares");
        Telefon t3 = new Telefon("Corina");
        Telefon t4 = new Telefon("Alexandra");
        Telefon t5 = new Telefon("Iulia");
        Telefon t6 = new Telefon("Corina");

        t1.apeleaza(t2);
        System.out.println(t2);

        t2.apeleaza(t3);
        System.out.println(t3);

        t3.apeleaza(t2);
        System.out.println(t2);

        t4.apeleaza(t2);
        System.out.println(t2);

        t5.apeleaza(t3);
        System.out.println(t3);

        int x = t2.numarDeApeluri("Corina");
        System.out.println("Aceasta persoana a sunat de " + x + " ori!");

    }
}
