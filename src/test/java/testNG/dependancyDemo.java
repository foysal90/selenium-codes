package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependancyDemo {
    @Test
    void startCar (){
        System.out.println("started");
        Assert.fail(); // it will fail startCar
    }

    @Test  (dependsOnMethods = {"startCar"}) //ignore test as startCar failed
    void pauseCar (){
        System.out.println("paused");
    }

    @Test  (dependsOnMethods = {"startCar"})  //ignore test as startCar failed
    void breakCar (){
        System.out.println("break");
    }
    @Test  (dependsOnMethods = {"startCar","pauseCar"}, alwaysRun = true) // alwaysrun will forcefully run the test while startCAR IS Failed
    void stopCar (){
        System.out.println("stop");
    }

}
