class Figura {
    private float arie;

    public Figura(float arie) {
        this.arie = arie;
    }

    public String afisare(){
        return "Arie: " + this.arie;
    }

    public float getArie(){
        return arie;
    }

    public boolean equals(Object o){
        if(o instanceof Figura){
            Figura f = (Figura)o;
            return this.arie == ((Figura) o).arie;
        }
        return false;
    }

}

class Desen{
    private String titlu;

    public Desen(String titlu){
        this.titlu = titlu;
    }

    Figura[] figuri = new Figura[1024];
    private int nrFiguri = 0;

    public boolean adaugaFigura(Figura f){
        if(nrFiguri >= 1024)
            return false;

        for(int i = 0; i < nrFiguri; i++)
            if(f.getArie() == figuri[i].getArie())
                return false;

        figuri[nrFiguri++] = f;
        return true;
    }

    public String toString(){
        String s = "Titlu desen: " + this.titlu + "\n";
        for(int i = 0; i < nrFiguri; i++)
            s = s + "Figura" + (i+1) + " " + figuri[i].afisare() + "\n";

        return s;
    }

    public float medieArie(){
        if(nrFiguri == 0)
            return 0;
        else{
            float s = 0;
            for(int i = 0; i < nrFiguri; i++)
                s = s + figuri[i].getArie();
            float ma = (float) s / nrFiguri;

            return ma;
        }
    }
}

class Main{
    public static void main(String[] argv){
        Desen d = new Desen("Mona Lisa");
        Figura f1 = new Figura(1);
        Figura f2 = new Figura(2);
        Figura f3 = new Figura(2);

        d.adaugaFigura(f1);
        d.adaugaFigura(f2);
        d.adaugaFigura(f3);

        System.out.println(d);

        System.out.println("Media ariilor este " + d.medieArie());
    }
}