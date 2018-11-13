package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

/**
 * <p>
 * The drivetrain subsystem is the subsystem with all the methods related to
 * driving the frame
 * 
 * There are simiple and complex driving methods, as well as all of the other
 * return methods
 * 
 * 
 * Simple Methods: No parameters needed. Only sets speeds. Need to add
 * Timer.delay
 * 
 * Comlex Methods: Parameters needed. Can set speeds to hearts content. No need
 * for Timer.delay
 * 
 * Return Methdos: Returns component needed after get___
 * </p>
 */
public class DriveTrain extends Subsystem {
  // Components
  public static Talon LF = RobotMap.DT_LEFTFRONT;
  public static Talon LB = RobotMap.DT_LEFTREAR;
  public static Talon RF = RobotMap.DT_RIGHTFRONT;
  public static Talon RB = RobotMap.DT_RIGHTREAR;
  public static ADXRS450_Gyro GYRO = RobotMap.DT_GYRO;
  public static MecanumDrive DT = RobotMap.DRIVETRAIN;

  /**
   * The drive method for OPDrive
   * 
   * @param Joystick
   */
  public static void drive(Joystick dasStick) {
    DT.driveCartesian(dasStick.getY(), dasStick.getX(), dasStick.getZ());
  }

  // || Simple Methods
  // \/

  /**
   * The method behind driving. Part of the simple methods
   * 
   * @param xSpeed    (for side-to-side movement)
   * @param ySpeed    (for forwards-to-backwards movement)
   * @param zRotation (for rotating movements)
   */
  public static void driveSimple(double ySpeed, double xSpeed, double zRotation) {
    DT.driveCartesian(ySpeed, xSpeed, zRotation);
  }

  /** Shuffle to the right with the robot. Needs testing */
  public static void rightShuffle() {
    DT.driveCartesian(0, 0.5, 0);
  }

  /** Shuffle to the left with the robot. Needs testing */
  public static void leftShuffle() {
    DT.driveCartesian(0, -0.5, 0);
  }

  /** Drive forward */
  public static void Forward() {
    DT.driveCartesian(0.5, 0, 0);
  }

  /** Drive Backwards */
  public static void Backward() {
    DT.driveCartesian(-0.5, 0, 0);
  }

  /** Turn Right. Needs Testing */
  public static void turnRight() {
    DT.driveCartesian(0, 0, -0.5); // Figure out what is Right
  }

  /** Turns left. Needs Testing */
  public static void turnLeft() {
    DT.driveCartesian(0, 0, 0.5); // Figure out what is Left
  }

  /** Stops the Robot from moving */
  public static void Stop() {
    DT.driveCartesian(0, 0, 0);
  }
  // /\
  // || Simple Methods

  // || Complex Methods
  // \/

  /**
   * Drive Method that has the complete control of the motor. This method controls
   * time and speeds. Part of the complex driving methods
   * 
   * @param xSpeed    (for side-to-side movement)
   * @param ySpeed    (for forwards-to-backwards movement)
   * @param zRotation (for rotating movements)
   * @param Time      in seconds
   */
  public void driveComplex(double ySpeed, double xSpeed, double zRotation, double Time) {
    DT.driveCartesian(ySpeed, xSpeed, zRotation);
    Timer.delay(Time);
    DriveTrain.Stop();
  }

  /**
   * Complex Method for going diagonally
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
   * Straight driving with time
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
   * Shuffles with time
   * 
   * @param ySpeed
   * @param Time
   */
  public void GoSide(double xSpeed, double Time) {
    DT.driveCartesian(0, xSpeed, 0);
    Timer.delay(Time);
    DriveTrain.Stop();
  }
  // /\
  // || Complex Driving Methods

  // || Return Methods
  // \/

  /** @return Drivetrain GRYO */
  public ADXRS450_Gyro getGyro() {
    return GYRO;
  }

  /** @return DriveTrain */
  public MecanumDrive getDrive() {
    return DT;
  }

  /** @return Left Front Motor on the Drivetrain */
  public Talon getLF() {
    return LF;
  }

  /** @return Right Front Motor on the Drivetrain */
  public Talon getRF() {
    return RF;
  }

  /** @return Right Back Motor on the Drivetrain */
  public Talon getRB() {
    return RB;
  }

  /** @return Left Back Motor on the Drivetrain */
  public Talon getLB() {
    return LB;
  }
  // /\
  // || Return Methods

  public void initDefaultCommand() {
  }
}
