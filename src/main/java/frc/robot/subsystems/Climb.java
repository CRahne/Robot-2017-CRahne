package frc.robot.subsystems;

//imports
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * The climb subsystem deals with the two motors involved with the climbing
 * motion. Either the ALT motor or Main motor is used
 */
public class Climb extends Subsystem {

  private static Talon main = RobotMap.CLIMB_MOTOR;
  private static Talon alt = RobotMap.CLIMB_ALT;

  /** Sets the climb motors to go up */
  public void up() {
    main.set(1.0);
    alt.set(1.0);
  }

  /** Sets the climb motors to go down */
  public void down() {
    main.set(-1.0);
    alt.set(-1.0);
  }

  /** Sets the climb motors to stop. Always use in the end() of the command */
  public void stop() {
    main.set(0);
    alt.set(0);
  }

  /** @return main motor of the climb mechanism */
  public Talon getMotorMain() {
    return main;
  }

  /** @return alternate motor of the climb mechancism */
  public Talon getMotorAlt() {
    return alt;
  }

  @Override
  public void initDefaultCommand() {
  }
}
