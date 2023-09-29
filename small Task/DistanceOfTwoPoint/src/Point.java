import java.util.Scanner;

public class Point {
    private int x;
    private int y;
    //Constructor creating
    public Point(int startX,int startY){
        x=startX;
        y=startY;
    }
    // as variable is private so using this method we can get variables;
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    // here other point indicate p2 as i was working with p1.
    // If i working with p2 then the other point wil indicate p1
    public double distance(Point otherPoint){
        int dx= x-otherPoint.getX();
        int dy= y-otherPoint.getY();
        return Math.sqrt(dx*dx+dy*dy);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("\nHi user! want to get distance between two point?");
        System.out.println("\nEnter coordinate of first point ");
        System.out.print("\tx1= ");
        int x1= sc.nextInt();
        System.out.print("\ty1= ");
        int y1= sc.nextInt();
        System.out.println("\nEnter coordinate of Second point ");
        System.out.print("\tx2= ");
        int x2= sc.nextInt();
        System.out.print("\ty2= ");
        int y2= sc.nextInt();

        Point p1= new Point(x1,y1);
        Point p2 = new Point(x2,y2);
        System.out.print("\nThe distance between ("+x1+","+y1+") and ("+x2+","+y2+") is " );
        System.out.println(p1.distance(p2));

    }
}