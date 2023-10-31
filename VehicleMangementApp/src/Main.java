

public class Main {
    public static void main(String[] args) {




    SUV suv=new SUV("RAV4",4,false,60,110,130);
        System.out.println(suv);
        //checking the direction and speed
        System.out.println("current speed: "+suv.getCurrentSpeed());
        System.out.println("current direction: "+suv.getCurrentDirection());
        System.out.println("current gear: "+suv.getCurrentGear());


        //action performed (vehicle)
        suv.steer(45);
        suv.move(120);
        //suv.stop();
        //checking the direction and speed
        System.out.println("current speed: "+suv.getCurrentSpeed());
        System.out.println("current direction: "+suv.getCurrentDirection());
        System.out.println("current gear: "+suv.getCurrentGear());


        //action performed (Car)
        suv.changeSpeed(150);
        suv.accelerate(10);
        suv.steer(500);

//checking the direction and speed
        System.out.println("current speed: "+suv.getCurrentSpeed());
        System.out.println("current direction: "+suv.getCurrentDirection());
        System.out.println("current gear: "+suv.getCurrentGear());

    }
}