package lowleveldesign.solid_principle.I_InterfaceSegregationPrinciple;

interface TwoDShape{
    double area();
}
interface ThreeDShape{
    double area();
    double volume();
}
class square implements TwoDShape{
    private double s;
    public square(double side){
        this.s=side;
    }
    @Override
    public double area() {
        return s*s;
    }
}
class cube implements ThreeDShape{
        private double side;
        public cube(double s){
            this.side=s;
        }
    @Override
    public double area() {
        return 6*side*side;
    }

    @Override
    public double volume() {
        return side*side*side;
    }
}
public class ISPFollowed {
    public static void main(String [] args){
        TwoDShape square=new square(10);
        ThreeDShape cube=new cube(8);
        System.out.println(square.area());
        System.out.println(cube.area());
        System.out.println(cube.volume());
    }
}
