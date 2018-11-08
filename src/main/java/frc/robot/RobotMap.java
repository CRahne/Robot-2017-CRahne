/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  public static Talon CLIMB_MOTOR;
  public static Talon CLIMB_ALT;
  /** 
   * Missing objects
   * @Nate
   */
  public static Talon DT_LEFTFRONT;
  public static Talon DT_LEFTREAR;
  public static Talon DT_RIGHTFRONT;
  public static Talon DT_RIGHTREAR;
  public static ADXRS450_Gyro DT_GYRO;
  public static MecanumDrive DRIVETRAIN;
  public static UsbCamera GEAR_CAM;
  public static DigitalInput GEAR_SWITCH;
  public static UsbCamera SHOOT_CAM;
  public static Talon SHOOT_MOTOR;
  public static Encoder SHOOT_ENCODER;
  public static Talon SHOOT_KICKER;
  public static Talon GATE;
  public static Talon SWEEP_MOTOR;

  public static void init() {
    CLIMB_MOTOR = new Talon(4);
    CLIMB_MOTOR.setInverted(true);
    LiveWindow.addActuator("Climb", "Motor 1", CLIMB_MOTOR);

    CLIMB_ALT = new Talon(7);
    CLIMB_ALT.setInverted(true);
    LiveWindow.addActuator("Climb", "Motor 2", CLIMB_ALT);

    GATE = new Talon(0);
    GATE.setInverted(true);
    LiveWindow.addActuator("Shooter", "Gate", GATE);

    DT_LEFTFRONT = new Talon(2);
    LiveWindow.addActuator("DriveTrain", "DT_LEFTFRONT", DT_LEFTFRONT);

    DT_RIGHTFRONT = new Talon(1);
    LiveWindow.addActuator("DriveTrain", "DT_RIGHTFRONT", DT_RIGHTFRONT);

    DT_LEFTREAR = new Talon(0);
    LiveWindow.addActuator("DriveTrain", "DT_LEFTREAR", DT_LEFTREAR);

    DT_RIGHTREAR = new Talon(3);
    LiveWindow.addActuator("DriveTrain", "DT_RIGHTREAER", DT_RIGHTREAR);

    DT_GYRO = new ADXRS450_Gyro();
    DT_GYRO.reset();
    DT_GYRO.calibrate();
    // SmartDashboard.putDouble("GYRO", RobotMap.DT_GYRO.getAngle());
    LiveWindow.addSensor("DriveTrain", "DT_GYRO", DT_GYRO);

    DRIVETRAIN = new MecanumDrive(DT_LEFTFRONT, DT_LEFTREAR, DT_RIGHTFRONT, DT_RIGHTREAR);

    GEAR_CAM = CameraServer.getInstance().startAutomaticCapture("GEAR", 0);
    GEAR_CAM.setBrightness(0);
    GEAR_CAM.setResolution(160, 120);
    GEAR_CAM.setFPS(30);

    GEAR_SWITCH = new DigitalInput(0);
    LiveWindow.addSensor("GEAR SWITCH", 0, GEAR_SWITCH);

    SHOOT_CAM = CameraServer.getInstance().startAutomaticCapture("SHOOTER", 1);
    SHOOT_CAM.setBrightness(0);
    SHOOT_CAM.setResolution(160, 120);

    SHOOT_KICKER = new Talon(1);
    // SHOOT_KICKER.setInverted(true);
    LiveWindow.addActuator("Shooter", "Kicker", SHOOT_KICKER);

    SHOOT_MOTOR = new Talon(6);
    LiveWindow.addActuator("Shooter", "Motor", (Talon) SHOOT_MOTOR);

    SWEEP_MOTOR = new Talon(5);
    LiveWindow.addActuator("Sweeper", "Motor", (Talon) SWEEP_MOTOR);
  }
}
