import java.util.*;

class Utilizator implements Destinatar{
    private String nume;
    private List <String> jurnal;

    public Utilizator(String nume){
        this.nume = nume;
        this.jurnal = new ArrayList<>();
    }

    public void trimite(Destinatar d, String mesaj){
        String rezultat = "Trimis catre " + d + " cu mesajul " + mesaj;
        jurnal.add(rezultat);
        d.receptioneaza(this, mesaj);
    }

    public void receptioneaza(Utilizator expeditor, String mesaj){
        String rezultat = String.format("Primit de la %s mesajul %s", expeditor.nume, mesaj);
        jurnal.add(rezultat);
    }

    public String toString(){
        return nume + " " + String.join("\n", jurnal);
    }
}

interface Destinatar{
    public void receptioneaza(Utilizator expeditor, String mesaj);
}

class DestinatarDuplicat extends RuntimeException{
    public DestinatarDuplicat(String mesaj){
        super(mesaj);
    }
}

class Grup implements Destinatar{
    private List <Destinatar> membri;
    private String nume;

    public Grup(String nume){
        this.nume = nume;
        this.membri = new ArrayList<>();
    }

    public void inscrie(Destinatar d){
        if(membri.contains(d))
            throw new DestinatarDuplicat("Destinatarul " + d + "este deja in grupul " + nume);
        else
            membri.add(d);
    }

    public void receptioneaza(Utilizator expeditor, String mesaj){
        for(Destinatar m: membri)
            if(m != expeditor)
                m.receptioneaza(expeditor, mesaj);
    }
}

class Main{
    public static void main(String[] args){
        Utilizator u1 = new Utilizator("Dan");
        Utilizator u2 = new Utilizator("Marius");
        Utilizator u3 = new Utilizator("Alex");

        Grup g = new Grup("Carnivorii");

        g.inscrie(u3);
        g.inscrie(u1);

        u3.trimite(g, "Am deschis magazinul!");
        u2.trimite(g, "Vin acuma!");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
    }
}