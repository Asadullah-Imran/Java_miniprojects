public class Vehicle {
    private String name;
    private int currentSpeed;
    private int currentDirection;

    public Vehicle(String name){
        this.name=name;
        this.currentSpeed=0;
        this.currentDirection=0;
    }

    public void steer(int direction){

        this.currentDirection=(this.currentDirection+direction)%360;

        System.out.println("Steer method called: Steer at "+currentDirection+" degree");
    }




    public void move(int speed){
        this.currentSpeed=speed;

//        int immediateDirection=direction;
        System.out.println("Move Method called: Moving at "+currentSpeed+" speed ");

    }
    public void stop(){
        this.currentSpeed=0;
        System.out.println("Stop Method called: Stoping at "+currentSpeed+" speed in direction "+currentDirection);
    }


    //getter and setter


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }
}
