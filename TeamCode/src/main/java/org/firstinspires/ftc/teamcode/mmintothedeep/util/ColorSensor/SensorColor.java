package org.firstinspires.ftc.teamcode.mmintothedeep.util.ColorSensor;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
@Disabled
public class SensorColor {
    private ColorSensor colorSensor;
    private DistanceSensor proximitySensor;
    public void init(HardwareMap hwMap)  {
        colorSensor = hwMap.get(ColorSensor.class, "colorSensor");
        proximitySensor = hwMap.get(DistanceSensor.class, "colorSensor");
    }
    public String getRGB() {
        return "(" + (colorSensor.red()) + " , " + colorSensor.green() + " , " + colorSensor.blue() + ")";
    }

    public Integer getRed() {
        return colorSensor.red();
    }

    public Integer getBlue() {
        return colorSensor.blue();
    }

    public Integer getGreen() {
        return colorSensor.green();
    }

    public String getProximity(DistanceUnit du) {
        return "Proximity from object is " + proximitySensor.getDistance(du)+" inches";
    }

}
