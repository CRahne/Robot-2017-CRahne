package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

/**
 * Vision Subsystem with methods for checking vision in Autonomous
 */
public class Vision extends Subsystem {
  private DriveTrain dt = Robot.DT;

  /** Vision Check for Auto Blue 1 */
  public void checkVisionBlue1(double targetX) {
    Integer x;
    x = 0;
    if (targetX < 60) {
      dt.driveComplex(0.35, 0, 0, 0.04);
      dt.Stop();
    } else if (targetX < 70) {
      dt.driveComplex(-0.35, 0, 0, 0.04);
      dt.Stop();
    } else if (targetX > 60 && targetX < 70) {
      dt.driveComplex(0, 0.3, 0, 0.04);
      dt.Stop();
    } else {
      x = 1;
      dt.driveComplex(0, -0.75, 0, 0.75);
      dt.Stop();
    }
    if (x == 1) {
      dt.driveComplex(0, -0.75, 0, 0.75);
      dt.Stop();
    }
    dt.Stop();
  }

  /** Checks the Vision for Auto Blue 2 */
  public void checkVisionBlue2(double targetX) {
    Integer x;
    x = 0;
    if (targetX < 60) {
      dt.driveComplex(0.35, 0, 0, 0.04);
      dt.Stop();
    } else if (targetX < 70) {
      dt.driveComplex(-0.35, 0, 0, 0.04);
      dt.Stop();
    } else if (targetX > 60 && targetX < 70) {
      dt.driveComplex(0, 0.3, 0, 0.04);
      dt.Stop();
    } else {
      x = 1;
      dt.driveComplex(0, 0.3, 0, 0.25);
      dt.Stop();
      Timer.delay(0.25);
    }
    if (x == 1) {
      dt.driveComplex(0, -0.75, 0, 0.75);
      dt.Stop();
    }
    dt.Stop();
  }

  /** Checks Vision for Blue 3 still needs work */
  public void checkVisionBlue3(double targetX) {
    Integer x;
    x = 0;
    if (targetX < 60) {
      dt.driveComplex(0.35, 0, 0, 0.04);
      dt.Stop();
    } else if (targetX < 70) {
      dt.driveComplex(-0.35, 0, 0, 0.04);
      dt.Stop();
    } else if (targetX > 60 && targetX < 70) {
      dt.driveComplex(0, 0.3, 0, 0.04);
      dt.Stop();
    } else {
      x = 1;
      dt.driveComplex(0, -0.75, 0, 0.75);
      dt.Stop();
    }
    if (x == 1) {
      dt.driveComplex(0, -0.75, 0, 0.75);
      dt.Stop();
    }
    dt.Stop();
  }

  public void initDefaultCommand() {
  }
}
