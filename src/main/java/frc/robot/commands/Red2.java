package frc.robot.commands;

//imports
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

/** Tells the robot ot go to Red 2 */
public class Red2 extends Command {
  private DriveTrain dt = Robot.DT;

  public Red2() {
    requires(Robot.DT);
  }

  @Override
  protected void initialize() {
    requires(Robot.DT);
    dt.driveComplex(0, 0.75, 0, 1.2);
    dt.driveComplex(0.0, 0.8, 0.0, 0.3);
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    dt.Stop();
  }

  protected void interrupted() {
    dt.Stop();
  }
}
