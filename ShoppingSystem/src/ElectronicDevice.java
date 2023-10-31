import java.util.ArrayList;
import java.util.List;

public class ElectronicDevice extends Product{
    public ElectronicDevice(String name,String model,int price){
        super(name,model,price);
    }
}


class SeeItems{

    List<Product> items= new ArrayList<>();
    void addItems(Product item){
        items.add(item);
    }

    void seeEverything(){
        int k=1;
        for(Product item: items){
            System.out.println("id: "+k);
            System.out.println(item.getName());
            System.out.println(item.getModel());
            System.out.println(item.getprice());
            System.out.println("*******");
            k++;
        }
    }
    Product findItem(int id){
        int k=1;
        for(Product item: items){
            if(k==id){
                return item;
            }
            k++;
        }
        return null;
    }
}