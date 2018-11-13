package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class BasicAuto extends Command {
  private DriveTrain dt = Robot.DT;

  public BasicAuto() {
    requires(Robot.DT);
  }

  protected void initialize() {
    requires(Robot.DT);
    dt.GoStraight(0.5, 10);
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
