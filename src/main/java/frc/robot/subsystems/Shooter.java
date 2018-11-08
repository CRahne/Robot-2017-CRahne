/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Encoder;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  /** 
   * Why do you not use a final here and static in the DT or Climb
   * @Nate
   */
  public Talon SHOOT = RobotMap.SHOOT_MOTOR;
  public Talon KICKER = RobotMap.SHOOT_KICKER;
  public Encoder Encoder1 = RobotMap.SHOOT_ENCODER;
  public Talon GATE = RobotMap.GATE;

  /** 
   * Use comments
   * @Nate
   */
  public Talon getShoot() {
    return SHOOT;
  }

  /** 
   * Use comments
   * @Nate
   */
  public Talon getGate() {
    return GATE;
  }

  /** 
   * Use comments
   * @Nate
   */
  public Talon getKicker() {
    return KICKER;
  }

  /** 
   * Use comments
   * @Nate
   */
  public Encoder getEncoder() {
    return Encoder1;
  }

  /** 
   * Use comments
   * @Nate
   */
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
