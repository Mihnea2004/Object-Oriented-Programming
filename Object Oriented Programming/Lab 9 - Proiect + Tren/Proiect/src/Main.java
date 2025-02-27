interface Risky{
    public double getRisk();
}

class Membru{
    private String nume;
    private int varsta;

    public Membru(String n, int v){
        this.nume = n;
        this.varsta = v;
    }

    public String toString() {
        return "Nume: " + nume + ", Varsta: " + varsta;
    }
}

abstract class Project implements Risky{
    //protected String manager;
    protected String titlu;
    protected String obiectiv;
    protected long fonduri;

    protected Membru manager;
    protected Membru[] membrii;
    protected int index;

    public Project(String t, String o, long f, Membru manager, int maxMembrii){
        this.titlu = t;
        this.obiectiv = o;
        this.fonduri = f;
        this.manager = manager;
        this.membrii = new Membru[maxMembrii];
        this.index = 0;
    }

    public void addMember(Membru m){
        if(index < membrii.length)
            membrii[index++] = m;
        else
            return;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < index; i++)
            s += membrii[i] + " ";

        return s;
    }
}

class ProiectComercial extends Project{
    private String deadline;
    private int echipe;
    private long fonduriMarketing;

    public ProiectComercial(String titlu, String obiectiv, long fonduri, Membru manager, String deadline, int echipe){
        super(titlu, obiectiv, fonduri, manager, 15); //nr max membrii e 15 (ip)
        this.deadline = deadline;
        this.echipe = echipe;
        this.fonduriMarketing = fonduri / 2;
    }

    public double getRisk(){
        return (double) (echipe * 3) / index / (fonduri - fonduriMarketing);
    }

}

class ProiectMilitar extends Project{
    private String deadline;
    private String parola;

    public ProiectMilitar(String titlu, String obiectiv, long fonduri, Membru manager, int maxMembrii, String deadline, String parola){
        super(titlu, obiectiv, fonduri, manager, 15);
        this.deadline = deadline;
        this.parola = parola;
    }

    public double getRisk(){
        return (double) index / parola.length() / fonduri;
    }

}

class ProiectOpenSource extends Project{
    private String mailing_list;

    public ProiectOpenSource(String titlu, String obiectiv, long fonduri, Membru manager, int maxMembrii, String mailing_list){
        super(titlu, obiectiv, fonduri, manager, 1000);
        this.mailing_list = mailing_list;
    }

    public double getRisk(){
        return (double) index / fonduri;
    }
}

class InvestmentCompany{
    private Project[] proiecte;
    private int count;

    public InvestmentCompany(int maxProjects){
        this.proiecte = new Project[maxProjects];
        this.count = 0;
    }

    public void addProject(Project p){
        if(count < proiecte.length)
            proiecte[count++] = p;
        else
            return;
    }

    public Project getBestInvestment(){
        if(count == 0)
            return null;

        Project bestProject = proiecte[0]; //primul il consideram cel mai putin riscant
        for(int i = 1; i < count; i++)
            if(proiecte[i].getRisk() < bestProject.getRisk())
                bestProject = proiecte[i];

        return bestProject;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < count; i++)
            s += proiecte[i] + " ";

        return s;
    }
}

class Main{
    public static void main(String[] argv){
        Membru manager1 = new Membru("Remetan Rares", 23);
        Membru manager2 = new Membru("Remetan Florin", 59);
        Membru manager3 = new Membru("Remetan Mihnea", 20);

        Membru m1 = new Membru("Oros Corina", 60);
        Membru m2 = new Membru("Ispravnic Cristian", 61);
        Membru m3 = new Membru("Durus Daniel", 54);
        Membru m4 = new Membru("Olteanu Alin", 48);
        Membru m5 = new Membru("Mihuta Cosmin", 43);

        ProiectComercial p1 = new ProiectComercial("Lidl", "vanzare de produse", 50, manager1, "31.12.2024", 15);
        p1.addMember(m1);
        p1.addMember(m2);
        System.out.println("Proiect comercial: " + p1);

        ProiectMilitar p2 = new ProiectMilitar("Steaua", "promovare", 2500, manager2, 5, "02.03.2025", "Parola cea mai tare!");
        p2.addMember(m3);
        System.out.println("Proiect militar: " + p2);

        ProiectOpenSource p3 = new ProiectOpenSource("Polo", "performanta", 100, manager3, 10, "Aloo");
        p3.addMember(m4);
        p3.addMember(m5);
        System.out.println("Proiect open-source: " + p3);

        InvestmentCompany i = new InvestmentCompany(4);
        i.addProject(p1);
        i.addProject(p2);
        i.addProject(p3);
        System.out.println(i);

        Project bestCompany = i.getBestInvestment();
        System.out.println("Cel mai putin riscant proiect este: " + bestCompany.titlu);
    }

}