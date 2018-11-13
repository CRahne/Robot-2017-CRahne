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

public class Shooter extends Subsystem {

  public static Talon SHOOT = RobotMap.SHOOT_MOTOR;
  public static Talon KICKER = RobotMap.SHOOT_KICKER;
  public static Encoder Encoder1 = RobotMap.SHOOT_ENCODER;
  public static Talon GATE = RobotMap.GATE;

  public Talon getShoot() {
    return SHOOT;
  }

  public Talon getGate() {
    return GATE;
  }

  public Talon getKicker() {
    return KICKER;
  }

  public Encoder getEncoder() {
    return Encoder1;
  }

  public void initDefaultCommand() {
  }
}
