package lowleveldesign.solid_principle.S_SingleResponsibility_Principle;

import java.util.ArrayList;
import java.util.List;

class Products{
    String productName;
    int price;
    public Products(String name,int price){
        this.productName=name;
        this.price=price;
    }
}
class ShoppingCart1{
    private List<Products> products=new ArrayList<>();

    public void add(Products p){
        products.add(p);
    }
    public List<Products> getProducts(){
        return products;
    }
    public double calculateTotal(){
        double total=0;
        for(Products p:products){
            total+=p.price;
        }
        return total;
    }

}
class ShoppingCartInvoice{
    private ShoppingCart1 cart;
    public ShoppingCartInvoice(ShoppingCart1 cart){
        this.cart=cart;
    }
    public  void printInvoice(){
        System.out.println("Shopping Cart Invoice:-");
        for(Products p: cart.getProducts()){
            System.out.println(p.productName+"-"+p.price);
        }
        System.out.println("Total Calculated Price is :"+cart.calculateTotal());
    }
}
class ShoppingCartSave{
    private ShoppingCart1 cart;
    public ShoppingCartSave(ShoppingCart1 cart){
        this.cart=cart;
    }
    public void saveToDb(){
        System.out.println("Saving shopping cart to database");
    }
}
public class SRPFollowed {
    public static void main(String args[]){
        ShoppingCart1 cart=new ShoppingCart1();
        cart.add(new Products("TV",40000));
        cart.add(new Products("AC",60000));
        cart.calculateTotal();
        ShoppingCartInvoice invoice=new ShoppingCartInvoice(cart);
        invoice.printInvoice();
        ShoppingCartSave save=new ShoppingCartSave(cart);
        save.saveToDb();
    }
}
