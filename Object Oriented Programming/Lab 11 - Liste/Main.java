import java.util.*;
abstract class Tip{ //dat fiind ca superclasa nu are constructor, nu am nevoie de super la subclase!!
    public String getTip(){
        return "Tip: ";
    }
    abstract public String toString();
}

class Intreg extends Tip{
    private int valoare;
    public Intreg(int v){
        this.valoare = v;
    }

    public String getTip(){
        return super.getTip() + "Intreg";
    }

    public String toString(){
        return "" + this.valoare;
    }
}

class Sir extends Tip{
    private String s;
    public Sir(String s){
        this.s = s;
    }

    public String getTip(){
        return super.getTip() + "Sir";
    }

    public String toString(){
        return s;
    }
}

class Colectie extends Tip{
    private List <Tip> colectie = new ArrayList <Tip>();

    public String getTip(){
        return super.getTip() + "Colectie";
    }

    public String toString(){
        String s = "";
        Iterator <Tip> it = colectie.iterator();
        while(it.hasNext()){
            s = s + it.next() + " ";
        }
        return s;
    }

    public boolean equals(Object o){
        if(o instanceof Object){
            Object aux = (Object) o;
            return true;
        }
        else
            return false;
    }

    public void adauga(Tip t){
        colectie.add(t);
    }
}

class Main{
    public static void main(String argv[]){
        Intreg i1 = new Intreg(10);
        Intreg i2 = new Intreg(20);

        Sir s1 = new Sir("Mihnea");
        Sir s2 = new Sir("Rares");

        Colectie c1 = new Colectie();
        c1.adauga(i1);
        c1.adauga(i2);
        c1.adauga(s1);
        c1.adauga(s2);

        System.out.println(c1);

        Colectie c2 = new Colectie();
        c2.adauga(i1);
        c2.adauga(i2);
        c2.adauga(s1);
        c2.adauga(s2);

        System.out.println(c2);

        System.out.println(c1.equals(c2));
    }

}
