package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The sweeper mechanism subsystem with the methods included for only 3 small
 * payments of $29.99! And that's not all, if you read this in the next five
 * minutes, you can get the comments too!
 */
public class Sweeper extends Subsystem {
  // Components
  public static Talon MOTOR = RobotMap.SWEEP_MOTOR;

  /** Sets the Sweeper motor to forward 0.5 volts */
  public void kforward() {
    MOTOR.set(0.5);
  }

  /** Sets the Sweeper motor to Reverse 0.5 volts */
  public void kreverse() {
    MOTOR.set(-0.5);
  }

  /** Returns the Sweeper Motor */
  public Talon getMotor() {
    return MOTOR;
  }

  public void initDefaultCommand() {
  }
}