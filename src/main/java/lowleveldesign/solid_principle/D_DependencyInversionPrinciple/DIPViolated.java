package lowleveldesign.solid_principle.D_DependencyInversionPrinciple;

class MySqlDb{// Low-level module
    public void saveToSql(String data){
        System.out.println("Executing Sql query: INSERT INTO user VALUES('"+data+"');");
    }
}
class MongoDBDatabase {  // Low-level module
    public void saveToMongo(String data) {
        System.out.println(
                "Executing MongoDB Function: db.users.insert({name: '"
                        + data + "'})"
        );
    }
}
class UserService{
    private final MySqlDb sql=new MySqlDb();
    private final MongoDBDatabase mongo =new MongoDBDatabase();
    public void storeUserToSql(String user){
        sql.saveToSql(user);
    }
    public  void storeUserToMongo(String user){
        mongo.saveToMongo(user);
    }
}
public class DIPViolated {
    public static void main(String[] args) {
        UserService user1 = new UserService();
        user1.storeUserToSql("Naman");
        user1.storeUserToMongo("Rohit");
    }
}
