package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;

public class Accelerate extends Command  {
  private DriveTrain DT = new DriveTrain();
  double TS = 0;
  double TM = 0;
  public Accelerate(double TargetSpeed, double Time) {
    requires(DT);
    TS = TargetSpeed;
    TM = Time;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    DT.Accelerate(TS, TM);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
