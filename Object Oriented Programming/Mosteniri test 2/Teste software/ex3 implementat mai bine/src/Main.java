import java.util.*;

interface Test{
    public int getNumarTeste();
}

class WrongQualityIndicatorException extends Exception{
    public WrongQualityIndicatorException(String mesaj){
        super(mesaj);
    }
}

class IntegrationTest implements Test{
    private String nume;
    private int qualityIndicator;

    public IntegrationTest(String nume, int qualityIndicator) throws WrongQualityIndicatorException{
        if(qualityIndicator < 1 || qualityIndicator > 10)
            throw new WrongQualityIndicatorException("Numarul trebuie sa fie intre 1 si 10!");
        this.nume = nume;
        this.qualityIndicator = qualityIndicator;
    }

    @Override
    public int getNumarTeste() {
        return 1;
    }

    public String toString(){
        return String.format("IntegrationTest (name = [%s], quality indicator = [%d])\n", nume, qualityIndicator);
    }
}

class WrongComponentComplexityIndicatorException extends Exception{
    public WrongComponentComplexityIndicatorException(String mesaj){
        super(mesaj);
    }
}

class ComponentTest implements Test{
    private String nume;
    private int qualityIndicator;
    private int complexity;

    public ComponentTest(String nume, int qualityIndicator, int complexity) throws WrongQualityIndicatorException, WrongComponentComplexityIndicatorException{
        if(qualityIndicator < 1 || qualityIndicator > 10)
            throw new WrongQualityIndicatorException("Numarul trebuie sa fie intre 1 si 10!");

        if(complexity <= 0)
            throw new WrongComponentComplexityIndicatorException("Numarul trebuie sa fie strict pozitiv!");

        this.nume = nume;
        this.qualityIndicator = qualityIndicator;
        this.complexity = complexity;
    }

    public int getNumarTeste() {
        return 1;
    }

    public String toString(){
        return String.format("IntegrationTest (name = [%s], quality indicator = [%d], component complexity indicator = [%d])\n", nume, qualityIndicator, complexity);
    }
}

class TestSuite{
    private List <Test> teste;

    public TestSuite() {
        this.teste = new ArrayList<>();
    }

    public boolean addNewIntegrationTest(String name, int indicator) throws WrongQualityIndicatorException{
        try{
            IntegrationTest t = new IntegrationTest(name, indicator);
            teste.add(t);
            return true;
        }
        catch(WrongQualityIndicatorException e){
            return false;
        }
    }

//    public void metodaProblematica() throws WrongComponentComplexityIndicatorException{
//        throw new WrongComponentComplexityIndicatorException("A aparut o problema!");
//    }
//
//    public void metodaPropaga() throws WrongComponentComplexityIndicatorException{
//        metodaProblematica();
//    }

    public boolean addNewComponentTest(String name, int indicator, int complexity) throws WrongQualityIndicatorException, WrongComponentComplexityIndicatorException{
        try{
            ComponentTest t = new ComponentTest(name, indicator, complexity);
            teste.add(t);
            return true;
        }
        catch(WrongQualityIndicatorException e){
            return false;
        }

        catch(WrongComponentComplexityIndicatorException e){
            System.out.println("Eroare");
            return false;
        }
    }

    public int getNumarTeste(){
        int s = 0;
        for(Test t : teste)
            s += t.getNumarTeste();

        return s;
    }

    public String toString(){
        String s = "Teste suite: \n";
        Iterator <Test> it = teste.iterator();
        while(it.hasNext())
            s += it.next() + " ";

        return s;
    }
}

class Main{
    public static void main(String[] args){
        TestSuite teste = new TestSuite();
        try{
            teste.addNewIntegrationTest("Nokia", 8);
            teste.addNewIntegrationTest("Vodafone", 13);
            teste.addNewComponentTest("Orange", 7, 9);
            teste.addNewComponentTest("Huawei", 11, 10);
        }
        catch(WrongQualityIndicatorException e){
            System.out.println("A aparut o exceptie!");
        }
        catch(WrongComponentComplexityIndicatorException e){
            System.out.println("A aparut o exceptie!");
        }

        System.out.println(teste);

        System.out.println(teste.getNumarTeste());
    }
}