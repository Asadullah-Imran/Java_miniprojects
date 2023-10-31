import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {

    static void menu(){   //try to make a interface on menu function
        System.out.println("Choose a option");
        System.out.println("#1. See items");
        System.out.println("#2. See Cart items");
        System.out.println("#3. CheckOut");
        System.out.println("#4. Exit");
    }
    public static void main(String[] args) {
        Product laptop= new ElectronicDevice("laptop","dell345",87994);
        Product phone= new ElectronicDevice("phone","oppo",7994);


        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Jambo Shpping Center");
        SeeItems add= new SeeItems();
        AddToCart addToCart= new AddToCart();

        menu();
        int option;
        option = sc.nextInt();
        while(option!=4){
            switch (option){
                case 1:
                    add.addItems(laptop);
                    add.addItems(phone);

                    int x=1;
                    while(x==1){
                        add.seeEverything();
                        System.out.println("#1. add to cart");
                        System.out.println("#2.main menu");
                        int option2= sc.nextInt();
                        switch (option2){
                            case 1:
                                System.out.println("Enter product id to add the product into your cart: ");
                                System.out.println("# 0. for exit: ");
                                int id= sc.nextInt();
                                if(id>0){
                                    if(add.findItem(id)==null){
                                        System.out.println("no id matched");
                                    }else{
                                        Product item =add.findItem(id);
                                        addToCart.add(item);
                                        System.out.println("Item added into the cart successfully");
                                    }

                                }


                                break;
                            case 2:
                                x=0;
                                break;
                            default:
                                System.out.println("try again with 1,or 2");
                                break;

                        }
                    }


                    break;
                case 2:
                    addToCart.showCart();
                    break;
                case 3:
                    System.out.println(option);
                    break;
                default:
                    System.out.println("try again with 1,2,3 or 4");
                    break;
            }
            menu();
            option = sc.nextInt();
        }
        System.out.println("Thank you for staying with us ");
        System.out.println("Have a nice day");

    }
}