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
  private static double Speed = 0.5;
  private static double negSpeed = -0.5;

  /** Sets the gate talon going forward */
  public static void gateForward() {
    GATE.set(Speed);
  }

  /** Sets the gate talon going backward */
  public static void gateBackward() {
    GATE.set(negSpeed);
  }

  /** Tells the gate motor to stop */
  public static void gateStop() {
    GATE.set(-0.0);
  }

  /** Sets the Shooter to go forward 0.5 volts */
  public static void shootForward() {
    SHOOT.set(Speed);
  }

  /** Sets the Shooter to go Reverse 0.5 volts */
  public static void shootReverse() {
    SHOOT.set(negSpeed);
  }

  /** Tells the shooter to stop */
  public static void shootStop() {
    SHOOT.set(-0.0);
  }

  /** Sets the Kicker to Forward 0.5 volts */
  public static void kickerForward() {
    KICKER.set(Speed);
  }

  /** Sets the Kicker to Reverse 0.5 volts */
  public static void kickerReverse() {
    KICKER.set(negSpeed);
  }

  /** Tells the Kicker motor to stop */
  public static void kickerStop() {
    KICKER.set(-0.0);
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
