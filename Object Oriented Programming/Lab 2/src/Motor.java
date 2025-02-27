class Motor {
    private int capacitate;

    public Motor(int c){
        capacitate = c;
    }

    public void setCapacitate(int c){
        capacitate = c;
    }

    public void tipareste(){
        System.out.println("Motor in capacitate " + capacitate);
    }
}

//        Motor m1, m2;
//        m1 = new Motor(5);
//        m2 = m1;
//        m2.tipareste();
//        m2.setCapacitate(10);
//        m1.tipareste();
