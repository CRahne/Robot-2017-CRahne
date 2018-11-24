package frc.robot.subsystems;

/**
 * Drivetrain
 * drive() {This method will bind the joystick to control the robot} 
 * 
 * ---> Simple Methods {Basic functions with no parameters}
 *      -->driveSimple {The driveSimple method is the simplest autonomous driving method}
 *      
 *      -->rightShuffle {Will shuffle the robot to the right with a change in xSpeed}
 *      -->leftShuffle {Shuffle left with the robot with a change in the xSpeed}
 *      
 *      -->Forward {Tells the robot to go forward with a change in the ySpeed}
 *      -->Backward {Tells the robot to go backward with a change in the ySpeed}
 *
 *      -->turnRight {Tells the robot to turn 90 degrees to the right}
 *      -->turnLeft {Tells robot to turn 90 degrees to the right}
 * 
 *      --> Stop {Tells the robot to stop moving. Call at the end of autos}
 * 
 * ---> Complex Methods
 *      -->driveComplex {Gives the Programmer complete control, with TIMER.DELAY and DriveTrain.Stop}
 *      
 *      -->XYGo {Will alter the ySpeed and xSpeed of a robot with the Timer.Delay and DriveTrain.Stop}
 *      -->GoStraight {This method will alter the ySpeed of going forward}
 *      -->GoSide {Shuffles to the one side or the other}
 * 
 * ---> Return Methods
 *      
 *      -->getGyro {Returns the Drivetrain GYRO}
 *      -->getDrive {Returns DriveTrain}
 *      -->getLF {Returns the left front motor on the drivetrain}
 *      -->getRF {Returns the right front motor on the drivetrain}
 *      -->getLB {Returns the left back motor on the drivetrain}
 *      -->getRB {Returns the right back motor on the drivetrain}
 * 
*/

//imports
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;

/**
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
 * 
 * 
 * @param ySpeed    The robot's speed along the Y-Axis [-1.0, 1.0]. Right is
 *                  positive
 * @param xSpeed    The robot's speed along the X-Axis [-1.0, 1.0]. Forward is
 *                  positive
 * @param zRotation The robot's rotation rate around the Z axis. Clockwise is
 *                  positive
 * @param Time      How long the move will be ran for
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
  public void drive(Joystick dasStick) {
    // This calls on driveCartesions and used the stick methods to control the
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
  public void driveSimple(double ySpeed, double xSpeed, double zRotation) {
    // This will just take a simple inputs from the programmer in the parameters
    DT.driveCartesian(ySpeed, xSpeed, zRotation);
  }

  /** Shuffle to the right with the robot */
  public void rightShuffle() {
    DT.driveCartesian(0, 0.5, 0); // Sets xSpeed to 0.5 volts
  }

  /** Shuffle to the left with the robot */
  public void leftShuffle() {
    DT.driveCartesian(0, -0.5, 0);// Sets xSpeed to -0.5 volts
  }

  /** Drive forward */
  public void Forward() {
    DT.driveCartesian(0.5, 0, 0);// Sets the ySpeed to 0.5 volts
  }

  /** Drive Backwards */
  public void Backward() {
    DT.driveCartesian(-0.5, 0, 0); // Sets the ySpeed to -0.5 volts
  }

  /**
   * Turns 90 degrees to the right. This method doesn't take the parameter of
   * targetAngle
   */
  public void turnRight() {
    double angle = GYRO.getAngle();
    // Sets a while statement on the gyro
    while (angle > 90) {
      DT.driveCartesian(0, 0, 0.4);
      angle = GYRO.getAngle();// This will rearead the the GYRO after each loop
    }
  }

  /**
   * Turns 90 degrees to the left. This method doesn't take the parameter of
   * targetAngle
   */
  public void turnLeft() {
    double angle = GYRO.getAngle();
    // Sets a while statement on the gyro
    while (angle > -90) {
      DT.driveCartesian(0, 0, -0.4);
      angle = GYRO.getAngle();// This will reread the GYRO after each loop
    }
  }

  /** Stops the Robot from moving. Call at the end of autos */
  public void Stop() {
    DT.driveCartesian(0, 0, 0); // Sets all speeds down to zero
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
    DT.driveCartesian(ySpeed, xSpeed, zRotation); // This allows complete control of all factors of the drive
    Timer.delay(Time); // Sets a time delay because there are no encoders on this robot
    DriveTrain.Stop(); // Tells the robot to stop
  }

  /**
   * Controls ySpeed and xSpeed on the driveCartesian. This will also have a
   * Timer.Delay and a DriveTrain.Stop at the end of it. Doesn't have the the
   * zRotation as a parameter
   * 
   * @param ySpeed
   * @param xSpeed
   * @param Time
   */
  public void XYGo(double ySpeed, double xSpeed, double Time) {
    DT.driveCartesian(ySpeed, xSpeed, 0); // There is no xRotation taken in
    Timer.delay(Time); // Sets a timer delay
    DriveTrain.Stop(); // Tells the robot to stop
  }

  /**
   * Straight driving with time. The ySpeed will be changed, so then the robot
   * will only drive in a striaght line
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
   * Will either go right [+ doubles] or left [- doubles] depending on the input
   * for xSpeed. Time is the parameter for the Timer.Delay method
   * 
   * @param xSpeed
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