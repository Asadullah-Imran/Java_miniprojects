import java.util.Scanner;

public class Car extends Vehicle{
    private int wheels;
    private String type;
    private int gears;
    private int doors;
    private boolean isManual;
    private int currentGear;


    public Car(String name,int wheels,int doors, int gears, boolean isManual, String type){
        super(name);
        this.wheels=wheels;
        this.doors=doors;
        this.gears=gears;
        this.isManual=isManual;
        this.type=type;
        this.currentGear=1;
    }

    public void changeGear(int newGear){
        this.currentGear=newGear;
        System.out.println("Change gear Method called: Change to "+currentGear+" gear");
    }


    public void changeSpeed(int newSpeed){
        move(newSpeed);
        System.out.println("change speed method called: speed ->"+newSpeed +" mph");
    }
    public void accelerate(int rate){
        setCurrentSpeed(getCurrentSpeed()+rate);
        System.out.println("accelerate method called: current speed -> "+getCurrentSpeed());

    }

    public void gearChange(int a,int b,int c){
        int newSpeed=getCurrentSpeed();
        if(isManual){
            if(newSpeed==0){
                stop();
                System.out.println("change the gear 1 manually");
                Scanner sc= new Scanner(System.in);
                int x= sc.nextInt();
                changeGear(x);

            } else if (newSpeed>0 && newSpeed<=a) {
                System.out.println("change the gear 1 manually");
                Scanner sc= new Scanner(System.in);
                int x= sc.nextInt();
                changeGear(x);
            }else if (newSpeed>a && newSpeed<=b) {
                System.out.println("change the gear 2 manually");
                Scanner sc= new Scanner(System.in);
                int x= sc.nextInt();
                changeGear(x);
            }else if (newSpeed>b && newSpeed<=c) {
                System.out.println("change the gear 3 manually");
                Scanner sc= new Scanner(System.in);
                int x= sc.nextInt();
                changeGear(x);
            }else {
                System.out.println("change the gear 4 manually");
                Scanner sc= new Scanner(System.in);
                int x= sc.nextInt();
                changeGear(x);
            }

        }else{
            if(newSpeed==0){
                stop();
                changeGear(1);
            } else if (newSpeed>0 && newSpeed<=a) {
                changeGear(1);
            }else if (newSpeed>a && newSpeed<=b) {
                changeGear(2);
            }else if (newSpeed>b && newSpeed<=c) {
                changeGear(3);
            }else {
                changeGear(4);
            }
        }
    }




    //getter setter


    public int getWheels() {
        return wheels;
    }

    public String getType() {
        return type;
    }

    public int getGears() {
        return gears;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isManual() {
        return isManual;
    }

    public int getCurrentGear() {
        return currentGear;
    }
}
