abstract class Greutate{
    public abstract int capacitate();
}

class GreutateSimpla extends Greutate{
    private int capacitate;
    public GreutateSimpla(int c){
        this.capacitate = c;
    }

    public int capacitate(){
        return capacitate;
    }

    public String toString(){
        String s = "";
        s += capacitate();
        return s;
    }
}

class GreutateDubla extends Greutate{
    private Greutate g1;
    private Greutate g2;

    public GreutateDubla(Greutate g1, Greutate g2){
        this.g1 = g1;
        this.g2 = g2;
    }

    public void setGreutate1(Greutate g){
        this.g1 = g;
    }

    public void setGreutate2(Greutate g){
        this.g2 = g;
    }

    public int capacitate(){
        return g1.capacitate() + g2.capacitate();
    }

    public String toString(){
        String s = "";
        s = s + g1.capacitate() + g2.capacitate();
        return s;
    }
}

class GreutateMultipla extends Greutate{
    private int capacitate;
    private Greutate[] greutati;

    public GreutateMultipla(Greutate[] greutati){
        this.greutati = greutati;
    }

    public int capacitate(){
        return capacitate;
    }
}

class ColectieGreutati extends Greutate{
    private int capacitate;
    private Greutate[] greutati = new Greutate[6];
    private int index = 0;

    public void adauga(Greutate g){
        if(index < 6)
            greutati[index++] = g;
        else
            System.out.println("Nu se mai pot adauga elemente in vectorul de greutati!");
    }

    public float medie(){
        int s = 0;
        for(int i = 0; i < index; i++)
            s += greutati[i].capacitate();

        float ma = (float) s / index;
        return ma;
    }

    public int capacitate(){
        return capacitate;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < index; i++)
            s = s + greutati[i].capacitate() + " ";
            return s;
    }
}

class Main{
    public static void main(String args[]){
        ColectieGreutati colectie = new ColectieGreutati();
        GreutateSimpla g1 = new GreutateSimpla(5);
        GreutateSimpla g2 = new GreutateSimpla(10);
        GreutateSimpla g3 = new GreutateSimpla(15);

        GreutateDubla g4 = new GreutateDubla(g1, g2);
        GreutateDubla g5 = new GreutateDubla(g2, g3);

        colectie.adauga(g1);
        colectie.adauga(g2);
        colectie.adauga(g3);
        colectie.adauga(g4);
        colectie.adauga(g5);
        System.out.println(colectie);

        float f = colectie.medie();
        System.out.println(f);
    }
}
