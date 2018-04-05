package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.OpticalDistanceSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;

/**
 * This file illustrates the concept of driving a path based on time.
 * It uses the common Pushbot hardware class to define the drive on the robot.
 * The code is structured as a LinearOpMode
 *
 * The code assumes that you do NOT have encoders on the wheels,
 *   otherwise you would use: PushbotAutoDriveByEncoder;
 *
 *   The desired path in this example is:
 *   - Drive forward for 3 seconds
 *   - Spin right for 1.3 seconds
 *   - Drive Backwards for 1 Second
 *   - Stop and close the claw.
 *
 *  The code is written in a simple form with no optimizations.
 *  However, there are several ways that this type of sequence could be streamlined,
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@Autonomous(name="triangle", group="Pushbot")
//@Disabled
public class auto1 extends LinearOpMode {

    /* Declare OpMode members. */
    hardwareMap robot = new hardwareMap();
    private ElapsedTime     runtime = new ElapsedTime();


    static final double     FORWARD_SPEED = 0.6;
    static final double     TURN_SPEED    = 0.5;

    @Override
    public void runOpMode() {

        /*
         * Initialize the drive system variables.
         * The init() method of the hardware class does all the work here
         */
        robot.init(hardwareMap);
        OpticalDistanceSensor odsSensor;
        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");    //
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Step through each leg of the path, ensuring that the Auto mode has not been stopped along the way
       /* robot.relicgrabber.setPower(-FORWARD_SPEED);
        robot.blockmover.setPower(-FORWARD_SPEED);
        runtime.reset();
        while (opModeIsActive() && (runtime.seconds() < 0.5)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        }
        robot.blockmover.setPower(0);
        robot.relicgrabber.setPower(0);
      */


        // Step 1:  Drive forward for 3 seconds
        robot.leftwheel.setPower(FORWARD_SPEED);
        robot.rightwheel.setPower(FORWARD_SPEED);
        robot.leftoniwheel.setPower(FORWARD_SPEED);
        robot.rightoniwheel.setPower(FORWARD_SPEED);

        runtime.reset();
        /* while (opModeIsActive() && (runtime.seconds() < 1.5)) {
            telemetry.addData("Path", "Leg 1: %2.5f S Elapsed", runtime.seconds());
            telemetry.update();
        } */

        odsSensor = hardwareMap.get(OpticalDistanceSensor.class, "light sensor");

        // wait for the start button to be pressed.
        waitForStart();

        // while the op mode is active, loop and read the light levels.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive()) {

            // send the info back to driver station using telemetry function.
            telemetry.addData("Raw", odsSensor.getRawLightDetected());
            telemetry.addData("Normal", odsSensor.getLightDetected());

            telemetry.update();


            if (odsSensor.getLightDetected() > 0.05) {
                robot.leftwheel.setPower(-1);
                robot.rightwheel.setPower(-1);
                robot.leftoniwheel.setPower(-1);
                robot.rightoniwheel.setPower(-1);
                runtime.reset();
                while (opModeIsActive() && (runtime.seconds() < 1.3)) {
                    telemetry.addData("Path", "Leg 2: %2.5f S Elapsed", runtime.seconds());
                    telemetry.update();
                }
                robot.leftwheel.setPower(1);
                robot.rightwheel.setPower(1);
                robot.leftoniwheel.setPower(1);
                robot.rightoniwheel.setPower(1);
                
            } }






        // Step 4:  Stop and close the claw.
        robot.leftwheel.setPower(0);
        robot.rightwheel.setPower(0);
        robot.leftoniwheel.setPower(0);
        robot.rightoniwheel.setPower(0);
        robot.blockmover.setPower(0);
        //robot.relicgrabber.setPower(0);

        telemetry.addData("Path", "Complete");
        telemetry.update();
        sleep(1000);
    }
}
