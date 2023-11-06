
public class Coupe extends Car {
    int a,b,c;
    public Coupe(String name, int gears, boolean isManual, int gearA, int gearB, int gearC) {
        super(name, 4, 2, gears, isManual, "Coupe");
        a=gearA;
        b=gearB;
        c=gearC;
    }

    @Override
    public void accelerate(int rate) {
        super.accelerate(rate);
        gearChange(a,b,c);
    }

    @Override
    public void move(int speed) {
        super.move(speed);
        gearChange(a,b,c);
    }

    public String toString(){
        return "This car name is "+ getName()+ " \nthis is a "+ getType() +" type car" +"\n"   ;
    }

}
