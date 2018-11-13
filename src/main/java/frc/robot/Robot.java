package frc.robot;

//imports
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Sweeper;
import frc.robot.commands.OPDrive;

/**
 * Robot Class is the class that tells the robot what to run and when
 */
public class Robot extends TimedRobot {

  // Subs
  public static DriveTrain DT = new DriveTrain();
  public static OI oi = new OI();
  public static Sweeper sweep = new Sweeper();
  public static Shooter shoot = new Shooter();
  public static Climb climb = new Climb();

  // AutoCommand
  public Command autonomousCommand;
  public Command OPDrive;

  public void robotInit() {
    OPDrive = new OPDrive();
  }

  public void robotPeriodic() {
  }

  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void autonomousInit() {
    oi = new OI();
    autonomousCommand = oi.getAutonomous(oi.chooser.getSelected());
    SmartDashboard.putData("Auto mode", autonomousCommand);

    if (autonomousCommand != null) {
      autonomousCommand.start();
    }
    System.out.println("Autonomous Starting");
  }

  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {
    OPDrive.start();

    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  public void testPeriodic() {
  }
}
