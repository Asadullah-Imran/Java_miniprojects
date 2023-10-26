abstract class Product extends ProductDetails{
String name;
String model;
int price;
Product(String name,String model,int price){
    this.model=model;
    this.name=name;
    this.price=price;
}

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getprice() {
        return price;
    }

    @Override
    public String getModel() {
        return model;
    }
}

interface ProductDetails{
String getName();
String getModel();
int getprice();
}
