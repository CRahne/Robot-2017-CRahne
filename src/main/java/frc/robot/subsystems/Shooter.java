package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 * The shooter subsystem is where all the components of the shoot mechanism are
 * given methods
 */
public class Shooter extends Subsystem {

  // Components
  public static Talon SHOOT = RobotMap.SHOOT_MOTOR;
  public static Talon KICKER = RobotMap.SHOOT_KICKER;
  public static Encoder Encoder1 = RobotMap.SHOOT_ENCODER;
  public static Talon GATE = RobotMap.GATE;
  private double Speed = 0.5;
  private double negSpeed = -0.5;

  /** Sets the gate talon going forward */
  public void gateForward() {
    GATE.set(0.5);
  }

  /** Sets the gate talon going backward */
  public void gateBackward() {
    GATE.set(-0.5);
  }

  /**
   * Sets the Shooter to go forward 0.5 volts
   */
  public void shootForward() {
    SHOOT.set(Speed);
  }

  /**
   * Sets the Shooter to go Reverse 0.5 volts
   */
  public void shootReverse() {
    SHOOT.set(negSpeed);
  }

  /**
   * Sets the Kicker to Forward 0.5 volts
   */
  public void kickerForward() {
    KICKER.set(Speed);
  }

  /**
   * Sets the Kicker to Reverse 0.5 volts
   */
  public void kickerReverse() {
    KICKER.set(negSpeed);
  }

  /** Returns Shoot Motor */
  public Talon getShoot() {
    return SHOOT;
  }

  /** Returns Gate Talon */
  public Talon getGate() {
    return GATE;
  }

  /** Returns Kicker Motor */
  public Talon getKicker() {
    return KICKER;
  }

  /** Returns Kicking Mechanism Encoder */
  public Encoder getEncoder() {
    return Encoder1;
  }

  public void initDefaultCommand() {
  }
}
