package lowleveldesign.solid_principle.O_OpenClosePrinciple;

import java.util.ArrayList;
import java.util.List;

class Items{
    String name;
    int price;
    public Items(String name,int price){
        this.name=name;
        this.price=price;
    }
}
class ShoppingItem{
    private List<Items> items=new ArrayList<>();
    public void add(Items i){
        items.add(i);
    }
    public List<Items> getItems(){
        return items;
    }
    public double calculateTotalPrice(){
    double total=0;
    for(Items i:items){
        total+=i.price;
    }
    return total;
    }
}
class printInvoice{
    ShoppingItem shp;
    public printInvoice(ShoppingItem i){
        this.shp=i;
    }
    public void printer(){
        System.out.println("Sopping Items Invoice are:");
        for(Items i:shp.getItems()){
            System.out.println(i.name+"-"+i.price);
        }
        System.out.println("Total Price is: "+shp.calculateTotalPrice());
    }
}
// now we want to save in mongoDb,sqlDb and in file we wan to extend saving functionality but now it requires code changes and also breaking SRP;
class saveToDb{
    ShoppingItem shp;
    public saveToDb(ShoppingItem i){
        this.shp=i;
    }
    public void saveToFile(){
        System.out.println("Items saved in File");
    }
    public void saveToMongoDb(){
        System.out.println("Items saved in MongoDb");
    }
    public void saveToSql(){
        System.out.println("Items saved in SQL Db");
    }
}
public class OCPViolated {
    public static void main(String args[]){
        ShoppingItem items=new ShoppingItem();
        items.add(new Items("Fride",15000));
        items.add(new Items("Wardrobe",10000));

        items.calculateTotalPrice();
        printInvoice invoice=new printInvoice(items);
        invoice.printer();

        saveToDb db=new saveToDb(items);
        db.saveToFile();
    }
}
