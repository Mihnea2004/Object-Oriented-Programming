abstract class Avion{
    protected String planeID;
    protected int totalEnginePower;

    public Avion(String planeID, int totalEnginePower){
        this.planeID = planeID;
        this.totalEnginePower = totalEnginePower;
    }

    public String getPlaneID(){
        return planeID;
    }

    public int getTotalEnginePower(){
        return totalEnginePower;
    }

    public void takeOff(){
        System.out.println(this.planeID + " - Initialising takeoff procedure - Starting engines - Accelerating down the runway - Taking off - Retracting gear - Takeoff complete");
    }

    public void fly(){
        System.out.println(this.planeID + " - Flying");
    }

    public void land(){
        System.out.println(this.planeID + " - Initialising landing procedure - Enabling airbrakes - Lowering gear - Contacting runway - Decelerating - Stopping engines - Landing complete");
    }
}

abstract class AvionCalatori extends Avion{
    protected int maxPassengers;

    public AvionCalatori(String planeID, int totalEnginePower, int maxPassengers){
        super(planeID, totalEnginePower);
        this.maxPassengers = maxPassengers;
    }

    public int getMaxPassengers(){
        return maxPassengers;
    }
}

class Concorde extends AvionCalatori{
    public Concorde(String planeID, int totalEnginePower, int maxPassengers){
        super(planeID, totalEnginePower, maxPassengers);
    }

    public void goSuperSonic(){
        System.out.println(planeID + " - Supersonic mode activated");
    }

    public void goSubSonic(){
        System.out.println(planeID + " - Supersonic mode deactivated");
    }
}

class Boeing extends AvionCalatori{
    public Boeing(String planeID, int totalEnginePower, int maxPassengers){
        super(planeID, totalEnginePower, maxPassengers);
    }
}

abstract class AvionDeLupta extends Avion{
    public AvionDeLupta(String planeID, int totalEnginePower){
        super(planeID, totalEnginePower);
    }

    public void launchMissile(){
        System.out.println(this.planeID + " - Initialising missile launch procedure - Acquiring target - Launching missile - Breaking away - Misiile launch complete");
    }
}

class Mig extends AvionDeLupta{
    public Mig(String planeID, int totalEnginePower){
        super(planeID, totalEnginePower);
    }

    public void highSpeedGeometry(){
        System.out.println(this.planeID + " - High speed geometry selected");
    }

    public void normalGeometry(){
        System.out.println(this.planeID + " - Normal geometry selected");
    }
}

class TomCat extends AvionDeLupta{
    public TomCat(String planeID, int totalEnginePower){
        super(planeID, totalEnginePower);
    }

    public void refuel(){
        System.out.println(this.planeID + " - Initialising refueling procedure - Locating refueller - Catching up - Refuelling - Refuelling complete");
    }
}

class Main{
    public static void main(String argv[]){
        Avion a1 = new Boeing("Boeing123", 1000, 300);
        Avion a2 = new Concorde("Concorde456", 2000, 500);
        Avion a3 = new Mig("Mig234", 5000);
        Avion a4 = new TomCat("TomCat567", 4000);

        a1.takeOff();
        if(a2 instanceof Concorde)
            ((Concorde)a2).goSuperSonic();
        if(a3 instanceof Mig)
            ((Mig)a3).highSpeedGeometry();
        if(a4 instanceof TomCat)
            ((TomCat)a4).refuel();
    }
}
