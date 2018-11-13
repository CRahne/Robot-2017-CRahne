package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Sweeper extends Subsystem {

  public static Talon MOTOR = RobotMap.SWEEP_MOTOR;

  public void initDefaultCommand() {
  }

  public Talon getMotor() {
    return MOTOR;
  }
}