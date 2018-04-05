package org.firstinspires.ftc.teamcode;

//import com.google.blocks.ftcrobotcontroller.runtime.CRServoAccess;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by noahbrick48 on 10/30/2017.
 */
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;



class hardwareMap {
    public DcMotor rightwheel = null;
    public DcMotor leftwheel = null;
    public DcMotor relicgrabber = null;
    public DcMotor blockmover = null;
    public DcMotor rightoniwheel = null;
    public DcMotor leftoniwheel = null;



  public Servo leftarm = null;        // top set of block grabber
    public Servo rightarm = null;
    public Servo leftarm1 = null;     //bottom set of block grabber
    public Servo rightarm1 = null;
    public Servo leftarm2 = null;     // relic grabber
    public Servo rightarm2 = null;
    public Servo jewels  = null;

    public final static double jewels_up = 1;
    public final static double jewels_down = 1;
    public final static double leftarm1_open = 0.4;
    public final static double leftarm1_closed = 0.3;
    public final static double rightarm1_open= 0.4;
    public final static double rightarm1_closed = 0.6;
    public final static double leftarm_closed = 0.2;
    public final static double leftarm_open = 1;
    public final static double rightarm_open= 0.7;
    public final static double rightarm_closed = 1;
    public final static double leftarm2_closed = 0.3;
   /* public final static double leftarm2_open = 0;
    public final static double rightarm2_open= 1;
    public final static double rightarm2_closed = 0.7;
     */
    HardwareMap hwMap = null;

    /* constructor */
    public hardwareMap() {
    }

    public void init (HardwareMap ahwMap) {

        hwMap = ahwMap;

        rightwheel = hwMap.get(DcMotor.class, "rightdrive");
        leftwheel = hwMap.get(DcMotor.class, "leftdrive");

        rightoniwheel = hwMap.get(DcMotor.class, "rightonidrive");
        leftoniwheel = hwMap.get(DcMotor.class, "leftonidrive");

        blockmover = hwMap.get(DcMotor.class, "blockmove");
       // relicgrabber = hwMap.get(DcMotor.class, "relicgrabber");

        leftwheel.setDirection(DcMotor.Direction.REVERSE);
        leftoniwheel.setDirection(DcMotor.Direction.REVERSE);


        rightwheel.setPower(0);
        leftwheel.setPower(0);
        rightoniwheel.setPower(0);
        leftoniwheel.setPower(0);

        blockmover.setPower(0);
       // relicgrabber.setPower(0);



        leftwheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightwheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        leftoniwheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightoniwheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        blockmover.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        /* leftarm = hwMap.get(Servo.class, "leftarmtop");
        rightarm = hwMap.get(Servo.class, "rightarmtop");

        leftarm1 = hwMap.get(Servo.class, "leftarm1");
        rightarm1 = hwMap.get(Servo.class, "rightarm1");

        //leftarm2 = hwMap.get(Servo.class, "leftarm2");
        //rightarm2 = hwMap.get(Servo.class, "rightarm2");






        leftarm.setPosition(leftarm_closed);
        rightarm.setPosition(rightarm_closed);


        leftarm1.setPosition(leftarm1_closed);
        rightarm1.setPosition(rightarm1_closed);

        //leftarm2.setPosition(leftarm2_closed);
        //rightarm2.setPosition(rightarm2_closed);

        */

    }




}