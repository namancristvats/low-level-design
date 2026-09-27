package lowleveldesign.DesignPattern.SingletonDesignPattern;

public class SingletonLazyInitializationThreadSafe {
    private static SingletonLazyInitializationThreadSafe instance=null;
    private SingletonLazyInitializationThreadSafe(){
        System.out.println("Singleton Constructor Called!");
    }
    public static SingletonLazyInitializationThreadSafe getInstance(){
        if(instance==null){
            synchronized (SingletonLazyInitializationThreadSafe.class){
                if(instance==null){//double locking
                    instance =new SingletonLazyInitializationThreadSafe();
                }
            }
        }
        return instance;
    }
    public static void main(String args[]){
        SingletonLazyInitializationThreadSafe ob1=SingletonLazyInitializationThreadSafe.getInstance();
        SingletonLazyInitializationThreadSafe ob2=SingletonLazyInitializationThreadSafe.getInstance();
        System.out.println(ob1==ob2);
    }
}
