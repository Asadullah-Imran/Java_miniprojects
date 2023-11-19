class Hello {
    private  int a;
    private Hello(int a ){
        this.a =a;
        System.out.println("THIS is the number: "+a);


    }
    public static void getHello(int b){
        new Hello(b);
    }
}

public class Main {
    public static void main(String[] args) {
       Hello.getHello(45);
       Hello.getHello(567);
       Hello.getHello(700);
    }
}

//output
//        THIS is the number: 45
//        THIS is the number: 45
//        THIS is the number: 45

//why not
//        THIS is the number: 45
//        THIS is the number: 567
//        THIS is the number: 700