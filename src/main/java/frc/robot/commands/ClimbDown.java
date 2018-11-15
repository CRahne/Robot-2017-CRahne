package frc.robot.commands;

//imports
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Climb;

/** Climb down? I think this is pretty self-explanatory */
public class ClimbDown extends Command {
  private Climb Climb = Robot.climb;

  public ClimbDown() {
    requires(Climb);
  }

  protected void initialize() {
  }

  protected void execute() {
    Climb.up();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Climb.stop();
  }

  protected void interrupted() {
    Climb.stop();
  }
}
