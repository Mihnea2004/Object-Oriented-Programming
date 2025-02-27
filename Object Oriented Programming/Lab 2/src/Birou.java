public class Birou {
    private String culoare, frumusete;

    public void tiparesteBirou(String c, String f){
        this.culoare = c;
        this.frumusete = f;
        System.out.println("Biroul este " + f + " si are culoarea " + c);
    }
}

//public class Main {
//    public static void main(String[] args) {
//        Sertar s1, s2;
//        s1 = new Sertar();
//        s2 = new Sertar();
//
//        s1.tipareste(5, 25, 16);
//        s2.tipareste(10, 20, 30);
//
//        Birou b;
//        b = new Birou();
//        b.tiparesteBirou("albastra", "frumos");
//    }
//}
