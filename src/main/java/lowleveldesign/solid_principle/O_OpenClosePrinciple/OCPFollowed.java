package lowleveldesign.solid_principle.O_OpenClosePrinciple;

import java.util.ArrayList;
import java.util.List;

class Product{
    String productName;
    int price;
    public Product(String name,int price){
        this.productName=name;
        this.price=price;
    }
}
class ShoppingCart{
    private List<Product> products=new ArrayList<>();

    public void add(Product p){
        products.add(p);
    }
    public List<Product> getProducts(){
        return products;
    }
    public double calculateTotal(){
        double total=0;
        for(Product p:products){
            total+=p.price;
        }
        return total;
    }
}
class ShoppingCartInvoice{
    private ShoppingCart cart;
    public ShoppingCartInvoice(ShoppingCart cart){
        this.cart=cart;
    }
    public  void printInvoice(){
        System.out.println("Shopping Cart Invoice:-");
        for(Product p: cart.getProducts()){
            System.out.println(p.productName+"-"+p.price);
        }
        System.out.println("Total Calculated Price is :"+cart.calculateTotal());
    }
}
interface Persistance{
    void save();
}
class saveToDB implements  Persistance{

    @Override
    public void save() {
        System.out.println("Products are saved in DB");
    }
}
class saveToFile implements  Persistance{

    @Override
    public void save() {
        System.out.println("Products are saved in File");
    }
}
class saveToMongo implements  Persistance{

    @Override
    public void save() {
        System.out.println("Products are saved in MongoDb");
    }
}
public class OCPFollowed {
    public static void main(String[] args){
        ShoppingCart shp=new ShoppingCart();
        shp.add(new Product("Badminton Racket",5000));
        shp.add(new Product("Chair",2000));

        List<Product> list=shp.getProducts();
        System.out.println("List of Products are:-");
        for(Product p:list){
            System.out.println(p.productName);
        }
        ShoppingCartInvoice invoice=new ShoppingCartInvoice(shp);
        invoice.printInvoice();
        Persistance db=new saveToDB();
        Persistance mongoDb=new saveToMongo();
        Persistance file=new saveToFile();
        db.save();
        mongoDb.save();
        file.save();
    }

}
