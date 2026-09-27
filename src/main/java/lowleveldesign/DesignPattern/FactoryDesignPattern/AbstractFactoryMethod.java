package lowleveldesign.DesignPattern.FactoryDesignPattern;

interface Pizza{
    void prepare();
}
class BasicPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing Pizza with Basic Toppings");
    }
}
class StandardPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing Pizza with Standard Toppings");
    }
}
class PremiumPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing Pizza with Standard Toppings");
    }
}
class BasicWheatPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing WheatPizza with Basic Toppings");
    }
}
class StandardWheatPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing WheatPizza with Standard Toppings");
    }
}
class PremiumWheatPizza implements Pizza{

    @Override
    public void prepare() {
        System.out.println("Preparing WheatPizza with Standard Toppings");
    }
}
interface GarlicBread{
    void prepare();
}
class BasicBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing Basic GarlicBread!!!");
    }
}
class StandardBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing Standard GarlicBread!!!");
    }
}
class PremiumBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing Premium GarlicBread!!!");
    }
}
class BasicWheatBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing WheatBasic GarlicBread!!!");
    }
}
class StandardWheatBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing WheatStandard GarlicBread!!!");
    }
}
class PremiumWheatBread implements GarlicBread{

    @Override
    public void prepare() {
        System.out.println("Preparing WheatPremium GarlicBread!!!");
    }
}
interface FoodFactory{
    Pizza createPizza(String type);
    GarlicBread createGarlicBread(String type);
}
class SinghOutlet implements FoodFactory{

    @Override
    public Pizza createPizza(String type) {
        if(type.equalsIgnoreCase("basic")){
            return new BasicPizza();
        }
        else if(type.equalsIgnoreCase("standard")){
            return new StandardPizza();
        }
        else if(type.equalsIgnoreCase("premium")){
            return new PremiumPizza();
        }
        else{
            System.out.println("Invalid Pizza type!");
            return null;
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if(type.equalsIgnoreCase("basic")){
            return new BasicBread();
        }
        else if(type.equalsIgnoreCase("standard")){
            return new StandardBread();
        }
        else if(type.equalsIgnoreCase("premium")){
            return new PremiumBread();
        }
        else{
            System.out.println("Invalid Bread type!");
            return null;
        }
    }
}
class KingOutlet implements FoodFactory{

    @Override
    public Pizza createPizza(String type) {
        if(type.equalsIgnoreCase("basic")){
            return new BasicWheatPizza();
        }
        else if(type.equalsIgnoreCase("standard")){
            return new StandardWheatPizza();
        }
        else if(type.equalsIgnoreCase("premium")){
            return new PremiumWheatPizza();
        }
        else{
            System.out.println("Invalid Pizza type!");
            return null;
        }
    }

    @Override
    public GarlicBread createGarlicBread(String type) {
        if(type.equalsIgnoreCase("basic")){
            return new BasicWheatBread();
        }
        else if(type.equalsIgnoreCase("standard")){
            return new StandardWheatBread();
        }
        else if(type.equalsIgnoreCase("premium")){
            return new PremiumWheatBread();
        }
        else{
            System.out.println("Invalid Bread type!");
            return null;
        }
    }
}
public class AbstractFactoryMethod {
    public static void main(String [] args){
        String pizza="standard";
        String bread="premium";
        FoodFactory f1=new SinghOutlet();
        FoodFactory f2=new KingOutlet();
        System.out.println("---------------------------------------------------------");
        Pizza standardWheatPizza=f2.createPizza(pizza);
        GarlicBread premiumNormalGarlicBread=f1.createGarlicBread(bread);

        standardWheatPizza.prepare();
        premiumNormalGarlicBread.prepare();
    }
}
