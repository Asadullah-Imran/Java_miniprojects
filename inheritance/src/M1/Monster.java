package M1;

public class Monster {
    String name;
    double weight;
    public void increaseWeight(double weight) {
        System.out.println("New weight of monster="+(this.weight+weight));
    }
    boolean eat(Human h){
        //check intelligence and return a boolean value
        if(h.intelligence=="high"){
            System.out.println("int");
            return true;
        }
        return false;
    }
    String scare(boolean bravery){
        if(bravery){
            return "brave";

        }
        return " not brave";
//check bravery and return a string
    }
}