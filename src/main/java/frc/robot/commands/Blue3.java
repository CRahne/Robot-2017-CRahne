package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

public class Blue3 extends Command {
  private DriveTrain dt = Robot.DT;

  public Blue3() {
    requires(Robot.DT);
  }

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
