public class SUV extends Car {

    public SUV(String name,int doors,int gears, boolean isManual ,String color) {
        super(name, doors, gears, isManual, "SUV" ,color);

    }



    public String toString(){
        return "This car name is "+ getName()+ " \nthis is a "+ getType() +" type car" +"\n"   ;
    }

}
