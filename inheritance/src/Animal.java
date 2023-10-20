
public class Animal {
    private String name;
    private  int age;
    public Animal(String name, int age){
        this.name=name;
        this.age=age;
    }

    public void eat(){
        System.out.println(name+" is eating");
    }
    public void makesSound(){
        System.out.println(name+" is making sound");
    }
    public void sleep(){
        System.out.println(name+" is sleeping");
    }


    public static void main(String[] args) {

    }
}