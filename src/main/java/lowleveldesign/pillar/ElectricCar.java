package lowleveldesign.pillar;

public class ElectricCar extends Car{
    private int batteryLevel;
    public ElectricCar(String brand,String model){
        super(brand,model);
        this.batteryLevel=100;
    }
    //specialized method for Electric Car
    public void chargeBattery(){
        batteryLevel=100;
        System.out.println(brand+" "+model+": Battery fully Charged!");
    }
    @Override
    public void accelerate() {
        if(!isEngineOn){
            isEngineOn=true;
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if(batteryLevel<=0){
            System.out.println(brand+" "+model + ": Battery dead! Cannot accelerate.");
            return;
        }
        batteryLevel-=10;
        currentSpeed+=15;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed +
                " km/h. Battery at " + batteryLevel + "%.");
    }



    @Override
    public void accelerate(int speed) {
        if(!isEngineOn){
            isEngineOn=true;
            System.out.println(brand + " " + model + " : Cannot accelerate! Engine is off.");
            return;
        }
        if(batteryLevel<=0){
            System.out.println(brand+" "+model + ": Battery dead! Cannot accelerate.");
            return;
        }
        batteryLevel-=10+speed;
        currentSpeed+=speed;
        System.out.println(brand + " " + model + " : Accelerating to " + currentSpeed +
                " km/h. Battery at " + batteryLevel + "%.");
    }

    @Override
    public void brake() {
        currentSpeed-=15;
        if (currentSpeed < 0) currentSpeed = 0;
        System.out.println(brand + " " + model +
                " : Regenerative braking! Speed is now " + currentSpeed +
                " km/h. Battery at " + batteryLevel + "%.");

    }
}
