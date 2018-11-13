package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Robot;

public class OPDrive extends Command {
  private DriveTrain drivetrain = Robot.DT;
  private Joystick OpStick = Robot.oi.OpStick;

  public OPDrive() {
    requires(drivetrain);
  }

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