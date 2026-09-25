package lowleveldesign.pillar;

public class ManualCar extends Car{
    private int currentGear;
    public ManualCar(String brand,String model){
        super(brand,model);
        this.currentGear=0;
    }
    //specialized method for gear
    public void shiftGear(int gear){
        this.currentGear=gear;
        System.out.println(brand + " " + model + " : Shifted to gear " + currentGear);
    }
    @Override
    public void accelerate() {
        if(!isEngineOn){
            System.out.println(brand+" "+model + ": Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed+=20;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    @Override
    public void accelerate(int speed) {
        if(!isEngineOn){
            System.out.println(brand+" "+model + ": Cannot accelerate! Engine is off.");
            return;
        }
        currentSpeed+=speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed + " km/h");
    }

    @Override
    public void brake() {
        currentSpeed-=20;
        if(currentSpeed<0) currentSpeed=0;
        System.out.println(brand + " " + model + " : Braking! Speed is now " + currentSpeed + " km/h");
    }
}
