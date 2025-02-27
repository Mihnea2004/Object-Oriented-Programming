import java.util.Random;
import java.util.Date;

class CoordinateGenerator {
    private Random randomGenerator;
    public CoordinateGenerator() {
        Date now = new Date();
        long sec = now.getTime();
        randomGenerator = new Random(sec);
    }
    public int generateX() {
        int x = randomGenerator.nextInt(101);
        if(x < 5)
            x = 0;
        else if(x > 95)
            x = 100;
        else
            x = randomGenerator.nextInt(99) + 1;
        return x;
    }

    public int generateY() {
        int y = randomGenerator.nextInt(101);
        if(y < 5)
            y = 0;
        else if(y > 95)
            y = 50;
        else
            y = randomGenerator.nextInt(49) + 1;
        return y;
    }
}

class Out extends Exception{
    public Out(String mesaj){
        super("Exceptie cu mesajul: " + mesaj);
    }
}

class Gol extends Exception{
    public Gol(String mesaj){
        super("Exceptie cu mesajul: " + mesaj);
    }
}

class Corner extends Exception{
    public Corner(String mesaj){
        super("Exceptie cu mesajul: " + mesaj);
    }
}

class Minge{
    private int x;
    private int y;
    private String numeEchipa1;
    private String numeEchipa2;
    private static CoordinateGenerator gen = new CoordinateGenerator();

    public Minge(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void suteaza() throws Out, Gol, Corner{
        x = gen.generateX();
        y = gen.generateY();

        if(y == 0 || y == 50){
            throw new Out("Mingea a iesit in out!");
        }
        if(x == 0 || x == 100){
            if(y >= 20 && y <= 30){
                throw new Gol("Mingea a intrat in poarta!");
            }
        }
        if(x == 0 || x == 100){
            if(y > 0 && y < 20){
                if(y > 30 && y < 50){
                    throw new Out("Mingea a iesit in corner!");
                }
            }
        }
    }

    public String toString(){
        return this.numeEchipa1 + " - " + this.numeEchipa2 + ": Mingea se afla la coordonatele: (" + this.getX() + ", " + this.getY() + ")!";
    }
}

class Joc{
    private String numeEchipa1;
    private String numeEchipa2;
    private int numarDeGoluri1;
    private int numarDeGoluri2;
    private int nrOuturi;
    private int nrCornere;

    public Joc(String numeEchipa1, String numeEchipa2){
        this.numeEchipa1 = numeEchipa1;
        this.numeEchipa2 = numeEchipa2;
    }

    public String toString(){
        return this.numeEchipa1 + " - " + this.numeEchipa2 + " Scor: " + this.numarDeGoluri1 + " - " +  this.numarDeGoluri2 + "Numar de out-uri: " + this.nrOuturi + "Numar de cornere: " + this.nrCornere;
    }

    public void simulare(){
        Minge m = new Minge(1, 1);
        for(int i = 0; i < 1000; i++){
            try{
                System.out.println("Mingea se afla la coordonatele: (" + m.getX() + ", " + m.getY() + ")!");
                m.suteaza();
            }
            catch(Gol e){
                if(m.getX() == 0)
                    numarDeGoluri1++;
                if(m.getX() == 100)
                    numarDeGoluri2++;
                m = new Minge(50, 25);
            }
            catch(Out e){
                nrOuturi++;
                m = new Minge(m.getX(), m.getY());
            }
            catch(Corner e){
                nrCornere++;
                m = new Minge(0, 0);
            }
        }
    }
}

class Main{
    public static void main(String argv[]){
        Joc j1 = new Joc("Steaua", "Craiova");
        Joc j2 = new Joc("Rapid", "CFR Cluj");
        j1.simulare();
        System.out.println(j1);
    }
}
