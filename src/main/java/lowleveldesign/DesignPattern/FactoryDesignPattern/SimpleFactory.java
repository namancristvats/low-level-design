package lowleveldesign.DesignPattern.FactoryDesignPattern;
//A factory class that decides which concrete class to instantiate.
interface Burger{
    void prepare();
}
class BasicBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}
class StandardBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, lattice and ketchup!");
    }
}
class PremiumBurger implements Burger{

    @Override
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}
class BurgerFactory{
    public Burger createBurger(String type){
        if(type.equalsIgnoreCase("Basic")){
            return new BasicBurger();
        }
        else if(type.equalsIgnoreCase("Standard")){
            return new StandardBurger();
        }
        else if(type.equalsIgnoreCase("Premium")){
            return new PremiumBurger();
        }
        else{
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}
public class SimpleFactory {
    public static void main(String args[]){
        String type="Standard";

        BurgerFactory factory=new BurgerFactory();
        Burger burger= factory.createBurger(type);
        System.out.println("--------------------------------------");
        if(burger!=null){
            burger.prepare();
        }
    }
}
