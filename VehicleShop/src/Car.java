import java.util.Scanner;

public class Car extends Vehicle{
    private int wheels;
    private String type;
    private int gears;
    private int doors;
    private boolean isManual;
    private String color;



    public Car(String name,int doors, int gears, boolean isManual, String type, String color){
        super(name);
        this.wheels=4;
        this.doors=doors;
        this.gears=gears;
        this.isManual=isManual;
        this.type=type;
        this.color=color;
    }





    //getter setter


}
