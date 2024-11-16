package org.firstinspires.ftc.teamcode.mmcenterstage.HardwareTesting;

import com.qualcomm.hardware.rev.RevSPARKMini;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcontroller.external.samples.ConceptRevSPARKMini;


@TeleOp (name = "Arm Motor Test - ONLY IF NEEDED", group = "Testing")
@Disabled
public class ArmMotorTest extends OpMode {

    CRServo armMotor = null;

    @Override
    public void init() {
        armMotor = hardwareMap.get(CRServo.class, "armMotor");

    }

    @Override
    public void loop() {
        armMotor.setPower(gamepad1.left_stick_y);
    }


}
