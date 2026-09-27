package lowleveldesign.DesignPattern.SingletonDesignPattern;

public class SingletonEagerInitialization {
    private static SingletonEagerInitialization instance=new SingletonEagerInitialization();

    private SingletonEagerInitialization(){
        System.out.println("Singleton Constructor is Called");
    }
    public static SingletonEagerInitialization getInstance(){
       return instance;
    }
    public static void main(String args[]){
        SingletonEagerInitialization s1=SingletonEagerInitialization.getInstance();
        SingletonEagerInitialization s2=SingletonEagerInitialization.getInstance();
        System.out.println(s1==s2);
    }
}
