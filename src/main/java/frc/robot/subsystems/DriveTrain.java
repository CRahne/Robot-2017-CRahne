package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

public class DriveTrain extends Subsystem {
  public static Talon LF = RobotMap.DT_LEFTFRONT;
  public static Talon LB = RobotMap.DT_LEFTREAR;
  public static Talon RF = RobotMap.DT_RIGHTFRONT;
  public static Talon RB = RobotMap.DT_RIGHTREAR;
  public static ADXRS450_Gyro GYRO = RobotMap.DT_GYRO;
  public static MecanumDrive DT = RobotMap.DRIVETRAIN;

  @Override
  public void initDefaultCommand() {
  }

  public static void drive(Joystick dasStick) {
    DT.driveCartesian(dasStick.getY(), dasStick.getX(), dasStick.getZ());
  }

  public static void DriveForward(double ySpeed, double xSpeed, double zRotation) {
    DT.driveCartesian(ySpeed, xSpeed, zRotation);

  }

  public static void Right() {
    DT.driveCartesian(0, 0, -0.5); // Figure out what is Right
  }

  public static void Left() {
    DT.driveCartesian(0, 0, 0.5); // Figure out what is Left
  }

  public static void Stop() {
    DT.driveCartesian(0, 0, 0);
  }

  /**
   * Go Complete Control
   * 
   * @param ySpeed
   * @param xSpeed
   * @param zRotation
   * @param Time      in seconds
   */
  public void Go(double ySpeed, double xSpeed, double zRotation, double Time) {
    DT.driveCartesian(ySpeed, xSpeed, zRotation);
    Timer.delay(Time);
    DriveTrain.Stop();
  }

  /**
   * Go Diagonal
   * 
   * @param ySpeed
   * @param xSpeed
   * @param Time
   */
  public void Go(double ySpeed, double xSpeed, double Time) {
    DT.driveCartesian(ySpeed, xSpeed, 0);
    Timer.delay(Time);
    DriveTrain.Stop();
  }

  /**
   * GoStraight
   * 
   * @param ySpeed
   * @param Time
   */
  public void GoStraight(double ySpeed, double Time) {
    DT.driveCartesian(ySpeed, 0, 0);
    Timer.delay(Time);
    DriveTrain.Stop();
  }

  /**
   * GoSide
   * 
   * @param ySpeed
   * @param Time
   */
  public void GoSide(double xSpeed, double Time) {
    DT.driveCartesian(0, xSpeed, 0);
    Timer.delay(Time);
    DriveTrain.Stop();
  }

  public ADXRS450_Gyro getGyro() {
    return GYRO;
  }

  public MecanumDrive getDrive() {
    return DT;
  }

  public Talon getLF() {
    return LF;
  }

  public Talon getRF() {
    return RF;
  }

  public Talon getRB() {
    return RB;
  }

  public Talon getLB() {
    return LB;
  }
}
