package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Climb extends Subsystem {

  private static Talon M1 = RobotMap.CLIMB_MOTOR;
  private static Talon M2 = RobotMap.CLIMB_ALT;

  public Talon getMotorMain() {
    return M1;
  }

  public Talon getMotorAlt() {
    return M2;
  }

  @Override
  public void initDefaultCommand() {
  }
}
