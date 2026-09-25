package lowleveldesign.solid_principle.I_InterfaceSegregationPrinciple;

interface shape{
    double area();
    double volume();
}
class Square implements shape{
    private double side;
    public Square(double s){
        this.side=s;
    }
    @Override
    public double area() {
        return side*side;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Volume not applicable for square");
    }
}
class Cube implements shape{
    private double side;
    public Cube(double side){
        this.side=side;
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
class Rectangle implements shape{
    private double length,width;
    public Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }
    @Override
    public double area() {
        return length* width;
    }

    @Override
    public double volume() {
        throw new UnsupportedOperationException("Volume not applicable for Rectangle");
    }
}
public class ISPViolated {
    public static void main(String args[]) {
        shape square = new Square(5);
        shape rectangle = new Rectangle(5, 10);
        shape cube = new Cube(8);

        System.out.println("Square Area: "    + square.area());
        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Cube Area: "      + cube.area());
        System.out.println("Cube Volume: "    + cube.volume());

        try {
            System.out.println("Square Volume: " + square.volume()); // Will throw an exception
        } catch (UnsupportedOperationException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
