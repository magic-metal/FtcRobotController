package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import cc.metalmagic.robot.Constants;

@Autonomous(name="Robot: Testing Motor Polarity", group="Robot")
public class DebugLeftRightMotorWithEncoders extends LinearOpMode {

    /* Declare all motors as null */
    private DcMotor testMotor = null;

    static final double MOTOR_TICK_COUNTS = Constants.MOTOR_TICK_COUNT; // goBILDA 5203 series Yellow Jacket
    // figure out how many times we need to turn the wheels to go a certain distance
    // the distance you drive with one turn of the wheel is the circumference of the wheel
    // The wheel's Diameter is 96mm. To convert mm to inches, divide by 25.4
    static final double WHEEL_DIAMETER_INCHES = Constants.WHEEL_DIAMETER_INCHES; // in Inches
    static final double CIRCUMFERENCE_INCHES = Constants.CIRCUMFERENCE_INCHES; // pi * the diameter of the wheels in inches

    static final double SPEED = 0.5; // Motor Power setting

    @Override
    public void runOpMode() {
        /* Assign all the motors */
        /*
        Test Results:   motorFrontLeft -> -ve Encoder Value
                        motorFrontRight -> +ve Encoder Value and stops
                        motorBackLeft -> : +ve Encoder Value .. and Stops
                        motorBackRight -> : + ve and Stops
            CONCLUSION: The Left Front Motor's Polarity was flipped.
            We reversed the wire connection to reverse the polarity...which fixes the issu
         */
        testMotor = hardwareMap.get(DcMotor.class, "motorFrontLeft"); //Front Left is giving -ve val for currentPosition
        // Set all the right motor directions
        testMotor.setDirection(DcMotor.Direction.FORWARD);

        testMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        testMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        testMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();

        testMotor.setTargetPosition(50 * 543);

        testMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        testMotor.setPower(-1);

        int counter = 1;
        while (testMotor.isBusy()) {
            telemetry.addLine("Current Position of the Motors")
                    .addData("Left Front  ", "%d", testMotor.getCurrentPosition())
                    .addData(" Counter: ", "%d", counter++);

            telemetry.update();
        }

        counter = 1;
        telemetry.addLine("Current Position of the Motors")
                .addData("Left Front  ", "%d", testMotor.getCurrentPosition())
                .addData(" Counter: ", "%d", counter++);

        telemetry.update();

        sleep(1000);
        testMotor.setPower(0);
    }
}
