class Card{
    private String numarCard;
    private float sold;

    public Card(String numarCard, float sold){
        this.numarCard = numarCard;
        this.sold = sold;
    }

    public String getNumarCard() {
        return numarCard;
    }
    public String afisare(){
        return this.numarCard + " - " + this.sold + "\n";
    }

    public float getSold(){
        return this.sold;
    }
}

class Portofel{
    private String numeProprietar;

    public Portofel(String numeProprietar){
        this.numeProprietar = numeProprietar;
    }

    private Card[] carduri = new Card[6];
    private int nrCarduri = 0;

    public boolean adaugaCard(String nume, float sold){
        if(nrCarduri >= 6)
            return false;

        for(int i = 0; i < nrCarduri; i++)
            if(nume.equals(carduri[i].getNumarCard()))
                return false;

        Card c = new Card(nume, sold);
        carduri[nrCarduri++] = c;
        return true;
    }

    public String toString(){
        String s = "Portofel: " + this.numeProprietar + "\n";
        for(int i = 0; i < nrCarduri; i++)
            s = s + "Card" + (i+1) + " " + carduri[i].afisare();

        return s;
    }

    public float calculeazaSold(){
        float s = 0;
        for(int i = 0; i < nrCarduri; i++)
            s += carduri[i].getSold();

        return s;
    }
}

class Main{
    public static void main(String[] argv){
        Portofel p = new Portofel("Mihnea");
        p.adaugaCard("RO84RNCB", 3000);
        p.adaugaCard("RO67INGB", 5000);
        p.adaugaCard("RO32BTRL", 2000);
        p.adaugaCard("RO67INGB", 6000);

        System.out.println(p);

        System.out.println("Sold-ul total: " + p.calculeazaSold());
    }
}