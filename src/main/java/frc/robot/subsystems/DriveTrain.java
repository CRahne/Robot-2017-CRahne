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
 * ---> Acceleration Methods
 *      -->returnLFSpeed {returns the speed of the left front DT motor}
 *      -->returnLBSpeed {returns the speed of the left back DT motor}
 *      -->returnRFSpeed {returns the speed of the right front DT motor}
 *      -->returnRBSpeed {returns the speed of the right back DT motor}
 *      -->checkSpeeds {checks all the speeds of the motors to make sure they are okay}
 *      -->averageSpeed {will get all the speeds of each motor, then will return the average}
 *      -->speedUp {will increase the speed each motor by 0.1 volts}
 *      -->speedDown {will decrease the speed of each motor by 0.1 volts}
 *      -->endCheck {will take a TargetSpeed and Average Speed of the DT and increase or decrease dynammically if isn't correct}
 *      -->Accel {Will accelerate the robot}
 *      -->deAccel {Will deaccelerate the robot}
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
import frc.robot.Constants;
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
 * !Not finished yet!
 * TODO Acceleration Methods: Methods that are only made for accelerating during the
 * TODO autonomous period. These methods all work together to make a coherent program
 * TODO for our drivetrain
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
  private Constants c = new Constants();// Constants Class

  // Components
  public Talon LF = RobotMap.DT_LEFTFRONT;
  public Talon LB = RobotMap.DT_LEFTREAR;
  public Talon RF = RobotMap.DT_RIGHTFRONT;
  public Talon RB = RobotMap.DT_RIGHTREAR;
  public ADXRS450_Gyro GYRO = RobotMap.DT_GYRO;
  public MecanumDrive DT = RobotMap.DRIVETRAIN;

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
    DT.driveCartesian(0, 0, 0); // Tells the robot to stop
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
    DT.driveCartesian(0, 0, 0); // Tells the robot to stop
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
    DT.driveCartesian(0, 0, 0);
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
    DT.driveCartesian(0, 0, 0);
  }
  // /\
  // || Complex Driving Methods

  // || Acceleration Methods
  // \/ 
  // ! NOT DONE DON'T USE

  /** Gets the Left Front DriveTrain Motor Voltage (Speed) @return Voltage to Motor */
  public double returnLFSpeed() {
    final double LFSpeed = LF.getSpeed();
    return LFSpeed;
  }
  /** Gets the Left Back DriveTrain Motor Voltage (Speed) @return Voltage to Motor */
  public double returnLBSpeed() {
    final double LBSpeed = LB.getSpeed();
    return LBSpeed;
  }
  /** Gets the Right Front DriveTrain Motor Voltage (Speed) @return Voltage to Motor */
  public double returnRFSpeed() {
    final double RFSpeed = RF.getSpeed();
    return RFSpeed;
  }
  /** Gets the Right Back DriveTrain Motor Voltage (Speed) @return Voltage to Motor*/
  public double returnRBSpeed() {
    final double RBSpeed = RB.getSpeed();
    return RBSpeed;
  }
  /**
   * First step in acceleration program. Need to make this in order to make other methods in Robot.java
   * @return if it is good or not boolean
   */
  public Boolean checkSpeeds() {
    // INIT RETURN BOOLEAN
    Boolean isGood = false;

    // GET THE SPEEDS OF MOTORS
    final double LBCheck = returnLBSpeed();
    final double LFCheck = returnLFSpeed();
    final double RFCheck = returnRFSpeed();
    final double RBCheck = returnRBSpeed();

    // MAKES THE ARRAY FOR THE FOR LOOP
    double[] checks = {LFCheck,LBCheck,RFCheck,RBCheck};
    for(double x:checks) {
      // IF SPEED IS LESS THAN OR EQUAL TO FORWARD SPEED MAX AND MORE THAN EQUAL TO FORWARD SPEED MIN
      if(x <= c.DTForwardSpeedMax && x >= c.DTForwardSpeedMin) {
        isGood = true;
      }
      // IF SPEED IS LESS THAN OR EQUAL TO THE REVERSE SPEED MIN AND MORE THAN EQUAL TO REVERSE SPEED MAX
      // ! math is goofy trust me. check Constants.java for the values
      else if(x <= c.DTReverseSpeedMin && x >= c.DTReverseSpeedMax) {
        isGood = true;
      }else {
        isGood = false;
      }
    }
    return isGood;
  }

  /**
   * Will return the average speed of all four drivetrain motors
   * @return average speed as a double
   */
  public double averageSpeed() {
    final double LBSpeed = returnLBSpeed();
    final double LFSpeed = returnLFSpeed();
    final double RFSpeed = returnRFSpeed();
    final double RBSpeed = returnRBSpeed();

    final double totalSpeeds = LBSpeed + LFSpeed + RFSpeed + RBSpeed;
    final double averageSpeed = totalSpeeds / 4;

    return averageSpeed;
  }
  /**
   * Will speed the robot up by 0.1 volts for each motor
   */
  private void speedUp() {

    // GET THE SPEEDS OF THE MOTORS
    final double speedofLF = returnLFSpeed();
    final double speedofLB = returnLBSpeed();
    final double speedofRF = returnRFSpeed();
    final double speedofRB = returnRBSpeed();

    // SET SPEEDS OF THE MOTORS
    RF.set(speedofRF + 0.1);
    RB.set(speedofRB + 0.1);
    LF.set(speedofLF + 0.1);
    LB.set(speedofLB + 0.1);
  }

  /** Will decrease the speed of the robot by 0.1 volts on each motor */
  private void speedDown() {

    // GET SPEEDS OF MOTORS
    final double speedofLF = returnLFSpeed();
    final double speedofLB = returnLBSpeed();
    final double speedofRF = returnRFSpeed();
    final double speedofRB = returnRBSpeed();

    // SET SPEEDS OF MOTOR
    RF.set(speedofRF - 0.1);
    RB.set(speedofRB - 0.1);
    LF.set(speedofLF - 0.1);
    LB.set(speedofLB - 0.1);
  }

  /** The method for end the acceleration */
  private void endCheck(double TargetSpeed, double AverageSpeed) {
    while(TargetSpeed != AverageSpeed) {
      if(TargetSpeed > AverageSpeed) {
        speedDown();
      }
      else if(TargetSpeed < AverageSpeed) {
        speedUp();
      }else {
        DT.driveCartesian(0,0,0);
      }
    }
  }

  /** Accelerates the robot dynamically.
   * 
   * @param TargetSpeed will accerlerate to that speed
   * @param Time affects the time in between an acceleration
   */
  // TODO Docs of code and then place convert into deAccel method
  public void Accel(double TargetSpeed, Integer Time) { 
    final double averageSpeed = averageSpeed();
    final double difference = TargetSpeed - averageSpeed;
    final double intervels = difference * 10;
    final double TimeBetween = Time/(-(TargetSpeed - averageSpeed))
    if(TargetSpeed > 1 || TargetSpeed < -1) {
      DT.driveCartesian(0, 0, 0);
    }else{
      Integer x = 1;
      while(x < intervels) {
        x ++;
        speedUp();
        Timer.delay(TimeBetween);
      }
    }
    endCheck(TargetSpeed, averageSpeed);
  }
  
  public void deAccel(double TargetSpeed, Integer Time) {

  }
  // /\
  // || Acceleration Methods

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