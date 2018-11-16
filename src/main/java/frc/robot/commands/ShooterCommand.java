package frc.robot.commands;

//imports
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class ShooterCommand extends Command {
  private Subsystem shooter = Robot.shoot;

  public ShooterCommand() {
    requires(shooter);
  }

  protected void initialize() {
    Shooter.kickerForward();
    Shooter.gateForward();
    Shooter.kickerForward();
  }

  protected void execute() {
  }

  protected boolean isFinished() {
    Shooter.kickerStop();
    Shooter.shootStop();
    Shooter.gateStop();
    return false;
  }

  protected void end() {
    Shooter.kickerStop();
    Shooter.shootStop();
    Shooter.gateStop();
  }

  protected void interrupted() {
    Shooter.kickerStop();
    Shooter.shootStop();
    Shooter.gateStop();
  }
}
