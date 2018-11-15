package frc.robot.commands;

//imports
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Sweeper;
import frc.robot.Robot;

/** Tells the sweeper to go in reverse */
public class SweeperReverse extends Command {
  private Sweeper Sweeper = Robot.sweep;

  public SweeperReverse() {
    requires(Sweeper);
  }

  protected void initialize() {
    Sweeper.kreverse();
  }

  protected void execute() {
    Sweeper.kreverse();
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
