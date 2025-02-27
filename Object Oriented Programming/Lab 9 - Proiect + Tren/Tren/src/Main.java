abstract class Vagon{
    protected int colete;
    public int capacitate(){
        return colete;
    }

    public abstract void deschideUsi();
    public abstract void inchideUsi();

}

class CalatoriA extends Vagon {
    public int capacitate() {
        return 40 + 300;
    }

    public void deschideUsi() {
        System.out.println("Usile s-au deschis automat pentru calatoriA!");
    }

    public void inchideUsi() {
        System.out.println("Usile s-au inchis automat pentru calatoriA!");
    }

    public String toString(){
        return "CalatoriA";
    }
}

class CalatoriB extends Vagon{
    public int capacitate() {
        return 50 + 400;
    }

    public void deschideUsi() {
        System.out.println("Usile s-au deschis automat pentru calatoriB!");
    }

    public void inchideUsi() {
        System.out.println("Usile s-au inchis automat pentru calatoriB!");
    }

    public void blocheazaGeamuri(){
        System.out.println("Geamurile s-au blocat pentru calatoriB!");
    }

    public String toString(){
        return "CalatoriB";
    }
}

class Marfa extends Vagon{
    public int capacitate(){
        return 400;
    }

    public void deschideUsi() {
        throw new UnsupportedOperationException("Deschiderea usilor este manuala pentru Marfa.");
    }

    public void inchideUsi() {
        throw new UnsupportedOperationException("Inchiderea usilor este manuala pentru Marfa.");
    }

    public String toString(){
        return "Marfa";
    }
}

class Tren{
    private Vagon[] vagoane = new Vagon[15];
    private int index = 0;

    public Tren(Vagon[] vagoane){
        if(vagoane.length > 15)
            System.out.println("Eroare!");

        this.vagoane = vagoane;
        this.index = vagoane.length;
    }

    public int capacitate(){
        int s = 0;
        for(int i = 0; i < index; i++)
            s += vagoane[i].capacitate();

        return s;
    }

    public boolean equals(Object o){
        if(o == null)
            return false;
        if(o instanceof Tren)
            return this.capacitate() == ((Tren) o).capacitate();

        return false;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < index; i++)
            s = s + vagoane[i] + " ";

        return s;
    }
}

class Main{
    public static void main(String[] args) {
        Vagon [] v1 = {new CalatoriA(), new CalatoriB()};
        Vagon [] v2 = {new CalatoriB(), new Marfa()};
        Vagon [] v3 = {new CalatoriA(), new CalatoriB()};

        Tren t1 = new Tren(v1);
        Tren t2 = new Tren(v2);
        Tren t3 = new Tren(v3);

        System.out.println("Primul tren: "+ t1);
        System.out.println("Al doilea tren: "+ t2);
        System.out.println("Al treilea tren: "+ t3);

        System.out.println(t1.equals(t3));
    }
}