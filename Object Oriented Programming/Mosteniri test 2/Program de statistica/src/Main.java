import java.util.*;

interface Statistica{
    public void calculeaza(List <String> secventaStringuri);
    public String toString();
}

class StatisticaNumarAparitii implements Statistica{
    private List <String> secventaCautata;
    private List <String> jurnal;

    public StatisticaNumarAparitii(List <String> cauta, List <String> jurnal){
        this.secventaCautata = cauta;
        this.jurnal = jurnal;
    }

    public void calculeaza(List <String> secventaStringuri){
        int nrAparitii = 0;
        for(String s : secventaStringuri)
            if(secventaCautata.contains(s))
                nrAparitii++;
        String rezultat = String.format("In secventa %s apar %d siruri din secventa %s", secventaStringuri, nrAparitii, secventaCautata);
        jurnal.add(rezultat);
    }

    public String toString(){
        return String.join("\n", jurnal);
    }
}

class StatisticaNumeraleNonReale implements Statistica{
    private List <String> jurnal;

    public StatisticaNumeraleNonReale(){
        this.jurnal = new ArrayList<>();
    }

    public void calculeaza(List <String> secventaStringuri){
        int countNonReal = 0;
        for(String s : secventaStringuri){
            try{
                Double.parseDouble(s);
            }
             catch(NumberFormatException e){
                countNonReal++;
             }
        }
        String rezultat = String.format("In secventa %s apar %d siruri ce nu sunt numerale reale", secventaStringuri, countNonReal);
        jurnal.add(rezultat);
    }

    public String toString(){
        return String.join("\n", jurnal);
    }
}

class Executor{
    private List <Statistica> statistici;

    public Executor(List <Statistica> statistici){
        this.statistici = statistici;
    }

    public void executa(List <String> secventaStringuri){
        for(Statistica s : statistici)
            s.calculeaza(secventaStringuri);

        Iterator <Statistica> it = statistici.iterator();
        while(it.hasNext())
            System.out.println(it.next());
    }
}

class Main{
    public static void main(String[] args){
        List <String> cauta = new ArrayList<>();
        List <String> jurnal = new ArrayList<>();
        cauta.add("mere");
        cauta.add("pere");
        cauta.add("banane");
        StatisticaNumarAparitii s1 = new StatisticaNumarAparitii(cauta, jurnal);

        StatisticaNumeraleNonReale s2 = new StatisticaNumeraleNonReale();

        List <Statistica> statistici = new ArrayList<>();
        statistici.add(s1);
        statistici.add(s2); //daca nu le dau add, nu are ce sa execute mai jos

        Executor e = new Executor(statistici);

        List <String> secventaStatistici = new ArrayList<>();
        secventaStatistici.add("Ana");
        secventaStatistici.add("are");
        secventaStatistici.add("mere");
        e.executa(secventaStatistici);

        List <String> secventaStatistici2 = new ArrayList<>();
        secventaStatistici2.add("Maria");
        secventaStatistici2.add("are");
        secventaStatistici2.add("pere");
        e.executa(secventaStatistici2);
    }
}