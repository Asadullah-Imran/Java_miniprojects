public class SomeClass {
    SomeClass()
    {
        System.out.println("I am the base constructor");
    }
    SomeClass(int a)
    {
        this();
        System.out.println("I have an extra value: "+ a);
        this.someMethod(a);
    }
    SomeClass(int a, double b){
       this(a);
        System.out.println("I have more values: " + b);
    }
    public void someMethod(){
        System.out.println("I have no param");
    }
    public void someMethod(int c){
        System.out.println("I borrow "+c+" form a constructor");
    }
}