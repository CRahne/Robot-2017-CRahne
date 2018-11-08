/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

/** 
   * Delete standard comments from the template unless actually useful
   * @Nate
   */
/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static Talon LF = RobotMap.DT_LEFTFRONT;
  public static Talon LB = RobotMap.DT_LEFTREAR;
  public static Talon RF = RobotMap.DT_RIGHTFRONT;
  public static Talon RB = RobotMap.DT_RIGHTREAR;
  public static ADXRS450_Gyro GYRO = RobotMap.DT_GYRO;
  public static MecanumDrive DT = RobotMap.DRIVETRAIN;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public static void drive(Joystick dasStick) {
    // DT.driveCartesian(dasStick.getY(), dasStick.getX());
    DT.driveCartesian(dasStick.getY(), dasStick.getX(), dasStick.getZ());
  }
  /*
   * What is the difference between ^ and v ?
   * @Nate
   */
  public static void DriveForward(double ySpeed, double xSpeed, double zRotation) {
    DT.driveCartesian(ySpeed, xSpeed, zRotation);

  }

  /** 
   * Use comments
   * @Nate
   */
  public static void Right() {
    DT.driveCartesian(0, 0, -0.5); // Figure out what is Right
  }
  /** 
   * Use comments
   * @Nate
   */
  public static void Left() {
    DT.driveCartesian(0, 0, 0.5); // Figure out what is Left
  }
  /** 
   * Use comments
   * @Nate
   */
  public static void Stop() {
    DT.driveCartesian(0, 0, 0);
  }


  /** 
   * Use actual comments and descriptions
   * @Nate
   */
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
   * Use actual comments and descriptions
   * @Nate
   */
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
   * Use actual comments and descriptions
   * @Nate
   */
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
   * Use actual comments and descriptions
   * @Nate
   */
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
