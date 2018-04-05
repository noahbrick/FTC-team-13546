package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * Created by noahbrick48 on 11/27/2017.
 */
@TeleOp(name="drivetrain: Telop tank", group="metal")
public class drivetank extends LinearOpMode {


    hardwareMap robot = new hardwareMap();

    @Override
    public void runOpMode() {
        double blockgrabber;
        double relicgrabber;
        double left;
        double right;


        robot.init(hardwareMap);

        telemetry.addData("say", "it's working???");
        OpticalDistanceSensor odsSensor;
        odsSensor = hardwareMap.get(OpticalDistanceSensor.class, "light sensor");

        waitForStart();
        while (opModeIsActive()) {


            blockgrabber = -gamepad2.left_stick_y;
            //relicgrabber = (-gamepad2.right_stick_y)/3;
            robot.blockmover.setPower(blockgrabber);
            //obot.relicgrabber.setPower(relicgrabber);


            left = -gamepad1.left_stick_y;
            right = -gamepad1.right_stick_y;

            if (left > 0.05 || left < -0.05 || right > 0.05 || right < -0.05) {
                robot.leftwheel.setPower(left);
                robot.rightwheel.setPower(right);
                robot.rightoniwheel.setPower(right);
                robot.leftoniwheel.setPower(left);
            } else if (gamepad1.a) {
                robot.leftoniwheel.setPower(1);
                robot.rightwheel.setPower(1);
            } else if (gamepad1.b) {
                robot.leftoniwheel.setPower(-1);
                robot.rightwheel.setPower(-1);
            } else if (gamepad1.dpad_up) {
                robot.leftwheel.setPower(1);
                robot.rightoniwheel.setPower(1);
            } else if (gamepad1.dpad_down) {
                robot.leftwheel.setPower(-1);
                robot.rightoniwheel.setPower(-1);
            } else {
                robot.leftwheel.setPower(0);
                robot.rightwheel.setPower(0);
                robot.rightoniwheel.setPower(0);
                robot.leftoniwheel.setPower(0);
            }

                // send the info back to driver station using telemetry function.
                telemetry.addData("Raw", odsSensor.getRawLightDetected());
                telemetry.addData("Normal", odsSensor.getLightDetected());

                telemetry.update();




          /*

            if (gamepad2.x) {

                robot.rightarm.setPosition(robot.rightarm_open);
                robot.leftarm.setPosition(robot.leftarm_open);

            }
            else if (gamepad2.y) {
                robot.rightarm.setPosition(robot.rightarm_closed);
                robot.leftarm.setPosition(robot.leftarm_closed);
            }




                if (gamepad2.right_bumper) {
                    robot.rightarm2.setPosition(robot.rightarm2_open);
                    robot.leftarm2.setPosition(robot.leftarm2_open);
                }
                else if (gamepad2.left_bumper) {
                    robot.rightarm2.setPosition(robot.rightarm2_closed);
                    robot.leftarm2.setPosition(robot.leftarm2_closed);
                }
                */

                telemetry.addData("left", "working", left);
                telemetry.addData("right", "working", right);


                sleep(40);


            }
        }
    }




