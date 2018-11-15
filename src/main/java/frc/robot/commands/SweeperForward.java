package frc.robot.commands;

//imports
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.Sweeper;

/** Tells the sweeper to go in forward */
public class SweeperForward extends Command {
  private Sweeper Sweeper = Robot.sweep;

  public SweeperForward() {
    requires(Sweeper);
  }

  protected void initialize() {
    Sweeper.kforward();
  }

  protected void execute() {
    Sweeper.kforward();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Sweeper.kstop();
  }

  protected void interrupted() {
    Sweeper.kstop();
  }
}
