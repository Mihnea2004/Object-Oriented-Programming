class FelDeMancare{
    private String nume;
    private int numarCalorii;

    public FelDeMancare(String nume, int numarCalorii){
        this.nume = nume;
        this.numarCalorii = numarCalorii;
    }

    public int getnumarCalorii() {
        return numarCalorii;
    }

    public String afisare(){
        return this.nume + " " + this.numarCalorii;
    }

    public boolean equals(Object o){
        if(o instanceof FelDeMancare){
            FelDeMancare aux = (FelDeMancare) o;
            return nume.equals(aux.nume) && numarCalorii == aux.numarCalorii;
        }
        return false;
    }
}

class Meniu{
    private int nrMaximCalorii;

    public Meniu(int nrMaximCalorii){
        this.nrMaximCalorii = nrMaximCalorii;
    }

    private FelDeMancare mancaruri[] = new FelDeMancare[10];
    private int index = 0;

    public boolean adaugaFelDeMancare(FelDeMancare f){
        if(index >= 10)
            return false;

        for(int i = 0; i < index; i++)
            if(mancaruri[i].getnumarCalorii() >= nrMaximCalorii)
                return false;

        mancaruri[index++] = f;
        return true;
    }

    public String toString(){
        String s = "Meniu: " + "\n";
        for(int i = 0; i < index; i++)
            s = s + mancaruri[i].afisare() + "\n";

        return s;
    }

    public boolean schimbaFelulDeMancare(FelDeMancare nou){
        for(int i = 0; i < index; i++) {
            if (mancaruri[i].equals(nou)){
                mancaruri[i] = nou;
                return true;
            }

        }
        return false;
    }
}

class Main{
    public static void main(String[] argv){
        Meniu m = new Meniu(200);
        FelDeMancare f1 = new FelDeMancare("Snitel", 50);
        FelDeMancare f2 = new FelDeMancare("Prajitura", 100);
        FelDeMancare f3 = new FelDeMancare("Mar", 20);

        m.adaugaFelDeMancare(f1);
        m.adaugaFelDeMancare(f2);
        m.adaugaFelDeMancare(f3);

        System.out.println(m);
        
        FelDeMancare f4 = new FelDeMancare("Para", 21);
        m.schimbaFelulDeMancare(f4);
        System.out.println(m);
    }

}