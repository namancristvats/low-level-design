package lowleveldesign.solid_principle.D_DependencyInversionPrinciple;


import javax.xml.crypto.Data;

interface Database{
    void save(String data);
}
class MySql implements Database{

    @Override
    public void save(String user) {
        System.out.println("Executing Sql query: INSERT INTO user VALUES('"+user+"');");
    }
}
class MongoDb implements Database{

    @Override
    public void save(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({name: '"
                        + data + "'})"
        );
    }
}
class User {
    private final Database db;
    public User(Database db){
        this.db=db;
    }
    public void storeUser(String data){
        db.save(data);
    }
}
public class DIPFollowed {
    public static  void main(String []args){
        Database mySql=new MySql();
        Database  mongoDb=new MongoDb();
        User user1=new User(mySql);
        user1.storeUser("Crist");
        User user2=new User(mongoDb);
        user2.storeUser("Naman");

    }

}
