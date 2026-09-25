package lowleveldesign.solid_principle.S_SingleResponsibility_Principle;

import java.util.ArrayList;
import java.util.List;
import java.util.PropertyPermission;

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
    public void addProduct(Product p){
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
    public void printInvoice(){
        System.out.println("Shopping Cart Invoice:-");
        for(Product p: products){
            System.out.println(p.productName+"-"+p.price);
        }
        System.out.println("Total Calculated Price is :"+calculateTotal());
    }
    public void saveToDb(){
        System.out.println("Saving shopping cart to database");
    }
}
public class SRPViolated {
   public static void main(String args[]){
       ShoppingCart cart=new ShoppingCart();
       cart.addProduct(new Product("Laptop",50000));
       cart.addProduct(new Product("Iphone",80000));
       List<Product> p=cart.getProducts();
       System.out.println(p);
       cart.printInvoice();
       cart.saveToDb();
   }
}
