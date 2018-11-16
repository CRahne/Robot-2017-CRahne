package frc.robot.commands;

//imports
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Robot;

/**
 * The operator drive allows the joystick to command the robot's movements after
 * the end of the autonomous period. This is done through the drivetrain
 * subsystem method called "drive" and the OP stick from the OI
 */
public class OPDrive extends Command {
  private DriveTrain drivetrain = Robot.DT;
  private Joystick OpStick = Robot.oi.OpStick;

  public OPDrive() {
    requires(drivetrain);
  }

  /**
   * He He, I Cole Rahne!!!!
   */

  protected void initialize() {
    drivetrain.drive(OpStick);
  }

  protected void execute() {
    drivetrain.drive(OpStick);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
  }

  protected void interrupted() {
    end();
  }
}