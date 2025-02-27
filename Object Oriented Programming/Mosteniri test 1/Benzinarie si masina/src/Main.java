class Masina{
    private String nrInmatriculare;
    private int capacitateRezervor;
    
    public Masina(String nrInmatriculare, int capacitateRezervor){
        this.nrInmatriculare = nrInmatriculare;
        this.capacitateRezervor = capacitateRezervor;
    }

    public int getCapacitateRezervor(){
        return capacitateRezervor;
    }

    public String afisare(){
        return this.nrInmatriculare + " " + this.capacitateRezervor;
    }
}

class Benzinarie{
    private int cantitateDisponibila;
    
    public Benzinarie(int cantitateDisponibila){
        this.cantitateDisponibila = cantitateDisponibila;
    }
    
    private Masina[] masini = new Masina[10];
    private int nrMasini = 0;

    public boolean alimenteazaMasina(Masina m){
        int c = m.getCapacitateRezervor();
        if(cantitateDisponibila >= c){
            cantitateDisponibila = cantitateDisponibila - c;
            return true;
        }
        else{
            if(nrMasini >= 10)
                return false;
            masini[nrMasini++] = m;
            return true;
        }
    }

    public String toString(){
        String s = "Coada benzinarie: " + "\n";
        for(int i = 0; i < nrMasini; i++)
            s = s + "Masina" + (i+1) + " " + masini[i].afisare() + "\n";

        return s;
    }

    public void alimenteazaBenzinarie(int cantitate){
        cantitateDisponibila += cantitate;
        if(nrMasini > 0){
            for(int i = 0; i < nrMasini - 1; i++){
                int c = masini[i].getCapacitateRezervor();
                if(cantitateDisponibila >= c) {
                    cantitateDisponibila -=c;
                    nrMasini--; //tot scad pana raman fara masini de alimentat

                    for(int j = i; j < nrMasini; j++)
                        masini[j] = masini[j + 1];
                    i--;
                }

                else {
                    return;
                }
            }
        }
    }
}


class Main{
    public static void main(String[] argv){
        Benzinarie b = new Benzinarie(0);
        Masina m1 = new Masina("AR09NRP", 5);
        Masina m2 = new Masina("AR24AZU", 10);
        Masina m3 = new Masina("AR63YSP", 15);

        b.alimenteazaMasina(m1);
        b.alimenteazaMasina(m2);
        b.alimenteazaMasina(m3);

        System.out.println(b);

        b.alimenteazaBenzinarie(15);
        System.out.println(b);
    }
}