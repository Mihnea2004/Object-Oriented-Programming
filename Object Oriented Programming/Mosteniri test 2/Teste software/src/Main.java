import java.util.*;

interface Tests{
    public int getNumarTeste();
    public String toString();
}

class WrongQualityIndicatorException extends RuntimeException{
    public WrongQualityIndicatorException(String message){
        super(message);
    }
}

class IntegrationTest implements Tests{
    private String name;
    private int qualityIndicator;

    public IntegrationTest(String name, int qualityIndicator){
        if(qualityIndicator < 1 || qualityIndicator > 10)
            throw new WrongQualityIndicatorException(("Wrong interval!"));

        this.name = name;
        this.qualityIndicator = qualityIndicator;
    }

    public int getNumarTeste(){
        return 1;
    }

    public String toString(){
        return String.format("IntegrationTest(name = [%s], quality indicator = [%d])\n", name, qualityIndicator);
    }
}

class WrongComponentComplexityIndicatorException extends RuntimeException{
    public WrongComponentComplexityIndicatorException(String message){
        super(message);
    }
}

class ComponentTest implements Tests{
    private String name;
    private int qualityIndicator;
    private int complexity;

    public ComponentTest(String name, int qualityIndicator, int complexity){
        if(complexity < 1 || complexity > 10)
            throw new WrongComponentComplexityIndicatorException(("Wrong interval!"));

        this.name = name;
        this.qualityIndicator = qualityIndicator;
        this.complexity = complexity;
    }

    public int getNumarTeste(){
        return 1;
    }

    public String toString(){
        return String.format("ComponentTest(name = [%s], quality indicator = [%d], complexity = [%s])\n", name, qualityIndicator, complexity);
    }
}

class TesteSuite{
    private List <Tests> teste;

    public TesteSuite(){
        this.teste = new ArrayList<>();
    }

    public boolean addNewIntegrationTest(String name, int indicator){
        try{
            IntegrationTest t = new IntegrationTest(name, indicator);
            teste.add(t);
            return true;
        }
        catch(WrongQualityIndicatorException e){
            return false;
        }
    }

    public boolean addNewComponentTest(String name, int indicator, int quality){
        try{
            ComponentTest t1 = new ComponentTest(name, indicator, quality);
            teste.add(t1);
            return true;
        }
        catch(WrongComponentComplexityIndicatorException e){
            return false;
        }
    }

    public int getNumarTeste(){
        int sum = 0;
        for(Tests t : teste)
            sum += t.getNumarTeste();

        return sum;
    }

    public String toString(){
        String s = "TestSuite: \n";
        ;
        Iterator <Tests> it = teste.iterator();
        while(it.hasNext())
            s = s + it.next() + " ";

        return s;
    }
}

class Main{
    public static void main(String[] args){
        TesteSuite teste = new TesteSuite();
        teste.addNewIntegrationTest("Nokia", 8);
        teste.addNewIntegrationTest("Vodafone", 6);
        teste.addNewComponentTest("Orange", 7, 9);
        teste.addNewComponentTest("Huawei", 10, 10);

        System.out.println(teste);

        System.out.println(teste.getNumarTeste());
    }
}