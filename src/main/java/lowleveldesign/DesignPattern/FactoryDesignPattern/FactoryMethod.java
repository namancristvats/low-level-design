package lowleveldesign.DesignPattern.FactoryDesignPattern;
//Define interface for creating object but allows subclasses to decide which concrete class to instantiate

interface Burger1 {
    void prepare();
}

class BasicBurger1 implements Burger1 {
    public void prepare() {
        System.out.println("Preparing Basic Burger with bun, patty, and ketchup!");
    }
}

class StandardBurger1 implements Burger1 {
    public void prepare() {
        System.out.println("Preparing Standard Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumBurger1 implements Burger1 {
    public void prepare() {
        System.out.println("Preparing Premium Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}
class BasicWheatBurger implements Burger1 {
    public void prepare() {
        System.out.println("Preparing Basic Wheat Burger with bun, patty, and ketchup!");
    }
}

class StandardWheatBurger implements Burger1 {
    public void prepare() {
        System.out.println("Preparing Standard Wheat Burger with bun, patty, cheese, and lettuce!");
    }
}

class PremiumWheatBurger implements Burger1 {
    public void prepare() {
        System.out.println("Preparing Premium Wheat Burger with gourmet bun, premium patty, cheese, lettuce, and secret sauce!");
    }
}
interface BurgerFactory1{
    Burger1 createBurger(String type);
}

class SinghBurger implements BurgerFactory1{

    @Override
    public Burger1 createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicBurger1();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardBurger1();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumBurger1();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}
class KingBurger implements BurgerFactory1{

    @Override
    public Burger1 createBurger(String type) {
        if (type.equalsIgnoreCase("basic")) {
            return new BasicWheatBurger();
        } else if (type.equalsIgnoreCase("standard")) {
            return new StandardWheatBurger();
        } else if (type.equalsIgnoreCase("premium")) {
            return new PremiumWheatBurger();
        } else {
            System.out.println("Invalid burger type!");
            return null;
        }
    }
}
public class FactoryMethod {
    public static void main(String args[]){
        String type="premium";
        String type2="standard";
        BurgerFactory1 factory=new SinghBurger();
        BurgerFactory1 factory2=new KingBurger();
        Burger1 premiumBurger=factory.createBurger(type);
        Burger1 standardWheat=factory2.createBurger(type2);

        System.out.println("----------------------------------------");
        if(premiumBurger!=null){
            premiumBurger.prepare();
        }
        if(standardWheat!=null){
            standardWheat.prepare();
        }
    }
}
