package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;

/**
 * Created by noahbrick48 on 2/15/2018.
 */
@TeleOp(name = "Sensor: MR ODS", group = "Sensor")

public class sensor extends LinearOpMode{




        OpticalDistanceSensor odsSensor;  // Hardware Device Object

        @Override
        public void runOpMode() {

            // get a reference to our Light Sensor object.
            odsSensor = hardwareMap.get(OpticalDistanceSensor.class, "light sensor");

            // wait for the start button to be pressed.
            waitForStart();

            // while the op mode is active, loop and read the light levels.
            // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
            while (opModeIsActive()) {

                // send the info back to driver station using telemetry function.
                telemetry.addData("Raw",    odsSensor.getRawLightDetected());
                telemetry.addData("Normal", odsSensor.getLightDetected());

                telemetry.update();
            }
        }
    }

