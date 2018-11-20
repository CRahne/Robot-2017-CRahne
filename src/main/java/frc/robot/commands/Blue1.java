package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
//imports
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.DriveTrain;

/** Tells the robot to go to Blue 1 */
public class Blue1 extends Command {
  private DriveTrain dt = Robot.DT;

  public Blue1() {
    requires(Robot.DT);
  }

  protected void initialize() {
    requires(Robot.DT);
    dt.driveComplex(0, 0.75, 0, 1.2);
    dt.Stop();
    dt.Forward();
    Timer.delay(.3);
    dt.Stop();
    Timer.delay(0.9);

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
