import java.util.ArrayList;
import java.util.List;

public class AddToCart {
    List<Product> items= new ArrayList<>();
    void add(Product item){
        items.add(item);
    }
    void showCart(){
        for (Product item:items){
            System.out.println(item.getName());
            System.out.println(item.getModel());
            System.out.println(item.getprice());
            System.out.println("*******");
        }
    }

}
