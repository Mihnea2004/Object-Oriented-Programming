import java.util.*;

abstract class CircuitElectric{
    public abstract double rezistentaEchivalenta();
    public double curent(double tensiune){
        return tensiune / rezistentaEchivalenta();
    }
    public abstract boolean contineSubcircuit(CircuitElectric subcircuit);
}

class Rezistenta extends CircuitElectric{
    private double valoareRezistenta;
    public Rezistenta(double valoareRezistenta){
        this.valoareRezistenta = valoareRezistenta;
    }

    @Override
    public double rezistentaEchivalenta() {
        return this.valoareRezistenta;
    }

    public boolean contineSubcircuit(CircuitElectric subcircuit){
        return this.equals(subcircuit);
    }
}

class CircuitSerie extends CircuitElectric{
    private List <CircuitElectric> circuiteSerie;
    public CircuitSerie(List <CircuitElectric> circuiteSerie){
        this.circuiteSerie = circuiteSerie;
    }

    public double rezistentaEchivalenta(){
        double s = 0;
        for(CircuitElectric c : circuiteSerie)
            s += c.rezistentaEchivalenta();

        return s;
    }

    public boolean contineSubcircuit(CircuitElectric subcircuit){
        boolean intermediar = false;
        for(CircuitElectric c : circuiteSerie)
            intermediar = intermediar || c.contineSubcircuit(subcircuit);

        return this.equals(subcircuit) || intermediar;
    }
}

class CircuitParalel extends CircuitElectric{
    private List <CircuitElectric> circuiteParalel;
    public CircuitParalel(List <CircuitElectric> circuiteParalel){
        this.circuiteParalel =circuiteParalel;
    }

    public double rezistentaEchivalenta(){
        double s = 0;
        for(CircuitElectric c : circuiteParalel)
            s += (1 / c.rezistentaEchivalenta());

        return 1 / s;
    }

    public boolean contineSubcircuit(CircuitElectric subcircuit){
        boolean intermediar = false;
        for(CircuitElectric c : circuiteParalel)
            //aici verific daca un subcircuit se contine pe el insusi
            intermediar = intermediar || c.contineSubcircuit(subcircuit);

        return this.equals(subcircuit) || intermediar;
        //aici am verificat daca fiecare circuit pas cu pas se contine pe el insusi
    }
}

class Main{
    public static void main(String[] argv){
        Rezistenta R1 = new Rezistenta(2);
        Rezistenta R2 = new Rezistenta(1);
        Rezistenta R3 = new Rezistenta(4);
        Rezistenta R4 = new Rezistenta(2);

        List <CircuitElectric> serie1, serie2, paralel;

        serie1 = new ArrayList<CircuitElectric>();
        serie1.add(R1);
        serie1.add(R2);

        serie2 = new ArrayList<CircuitElectric>();
        serie2.add(R3);
        serie2.add(R4);

        CircuitSerie c1, c2;
        c1 = new CircuitSerie(serie1);
        c2 = new CircuitSerie(serie2);
        double x = c1.rezistentaEchivalenta();
        System.out.println("x = " + x);
        double y = c2.rezistentaEchivalenta();
        System.out.println("y = " + y);

        paralel = new ArrayList<CircuitElectric>();
        paralel.add(c1);
        paralel.add(c2);

        CircuitParalel circuitParalel = new CircuitParalel(paralel);
        double z = circuitParalel.rezistentaEchivalenta();
        System.out.println("z = " + z);

        CircuitElectric circuitIntreg = circuitParalel;
        double a = circuitIntreg.rezistentaEchivalenta();
        System.out.println("a = " + a);

        double b = circuitIntreg.curent(9);
        System.out.println("b = " + b);

        System.out.println("Cautarea lui R1: " + circuitIntreg.contineSubcircuit(R1));
    }
}

