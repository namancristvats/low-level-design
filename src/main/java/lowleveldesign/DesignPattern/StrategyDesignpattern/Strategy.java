package lowleveldesign.DesignPattern.StrategyDesignpattern;

interface walkableRobot{
    void walk();
}
class NormalWalk implements walkableRobot{

    @Override
    public void walk() {
        System.out.println("Robot can walk");
    }
}
class NoWalk implements walkableRobot{

    @Override
    public void walk() {
        System.out.println("Robot cannot walk");
    }
}
interface flyableRobot{
    void fly();
}
class NormalFly implements flyableRobot{

    @Override
    public void fly() {
        System.out.println("Robot can fly");
    }
}
class NoFly implements flyableRobot{

    @Override
    public void fly() {
        System.out.println("Robot cannot fly");
    }
}
interface talkableRobot{
    void talk();
}
class NormalTalk implements talkableRobot{

    @Override
    public void talk() {
        System.out.println("Robot can talk");
    }
}
class NoTalk implements talkableRobot{

    @Override
    public void talk() {
        System.out.println("Robot cannot talk");
    }
}
abstract class Robot{
    protected walkableRobot walkableBehaviour;
    protected talkableRobot talkableBehaviour;
    protected flyableRobot flyableBehaviour;

    public Robot(walkableRobot walk,talkableRobot talk,flyableRobot fly){
        this.flyableBehaviour=fly;
        this.talkableBehaviour=talk;
        this.walkableBehaviour=walk;
    }
    public void walk(){
        walkableBehaviour.walk();
    }
    public void talk(){
        talkableBehaviour.talk();
    }
    public void fly(){
        flyableBehaviour.fly();
    }
    public abstract void projection();
}
class CompanionRobot extends Robot{

    public CompanionRobot(walkableRobot walk, talkableRobot talk, flyableRobot fly) {
        super(walk, talk, fly);
    }

    @Override
    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}
class WorkerRobot extends Robot{

    public WorkerRobot(walkableRobot walk, talkableRobot talk, flyableRobot fly) {
        super(walk, talk, fly);
    }

    @Override
    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}
public class Strategy {
    public static void main(String[] args){
        Robot robot1=new CompanionRobot(
                new NormalWalk(),new NormalTalk(),new NormalFly()
        );
        robot1.walk();
        robot1.talk();
        robot1.fly();
        robot1.projection();

        System.out.println("--------------------------------------");

        Robot robot2=new WorkerRobot(
                new NoWalk(),new NoTalk(),new NoFly()
        );
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}
