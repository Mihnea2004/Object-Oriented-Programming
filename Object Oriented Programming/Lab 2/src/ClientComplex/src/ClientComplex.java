class Complex {
    private double real;
    private double imaginar;
    private static double counter;

    public Complex(double real, double imaginar){
        this.real = real;
        this.imaginar = imaginar;
    }

    public double CalculeazaModulul(){
        return Math.sqrt(real * real + imaginar * imaginar);
    }

    public void Afisare(){
        System.out.println(real + " +i * " + imaginar);
        counter++;
    }

    public Complex CalculeazaSuma(Complex c){
        double sumaReale = real + c.real;
        double sumaImaginare = imaginar + c.imaginar;
        return new Complex(sumaReale, sumaImaginare);
    }

    static public double NrAparitii(){
        return counter;
    }
}

class ClientComplex{
    public static void main(String[] args) {
       Complex x, y;
       x = new Complex(1, 4);
       y = new Complex(3, 5);

       x.Afisare();
       y.Afisare();

       double modul = x.CalculeazaModulul();
       System.out.println("Modulul numarului complex este: " + modul);

       Complex suma = x.CalculeazaSuma(y);
       suma.Afisare();

       double nrAparitii = x.NrAparitii();
       System.out.println("Numarul de aparitii este: " + nrAparitii);
    }
}
