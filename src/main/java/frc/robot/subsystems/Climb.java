/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/** 
   * Why didn't you take this v advise
   * @Nate
   */
/**
 * Add your docs here.
 */
public class Climb extends Subsystem {
  /** 
   * Why do you use a final here and static in the DT
   * You are missing objects
   * @Nate
   */
  private final Talon M1 = RobotMap.CLIMB_MOTOR;
  private final Talon M2 = RobotMap.CLIMB_ALT;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  /** 
   * Delete standard comments from the template unless actually useful
   * @Nate
   */

  /** 
   * Use comments
   * @Nate
   */
  public Talon getMotorMain() {
    return M1;
  }

  /** 
   * Use comments
   * @Nate
   */
  public Talon getMotorAlt() {
    return M2;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
