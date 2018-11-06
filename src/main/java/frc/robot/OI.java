/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.BasicAuto;
import frc.robot.commands.Blue1;
import frc.robot.commands.Blue2;
import frc.robot.commands.Blue3;
import frc.robot.commands.Red1;
import frc.robot.commands.Red2;
import frc.robot.commands.Red3;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until ist is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());

  public Joystick OpStick = new Joystick(0);

  public SendableChooser<String> chooser = new SendableChooser<>();
  public String defaultAuto = "Default";
  public String X1 = "1X";
  public String AB1 = "1AB";
  public String CF1 = "1CF";
  public String IH1 = "1IH";
  public String X2 = "2X";
  public String AB2 = "2AB";
  public String CD2 = "2CD";
  public String AB3 = "3AB";
  public String DE3 = "3DE";
  public String GJ3 = "3GJ";
  private Command autoCommand;

  public OI() {

    chooser.addDefault("Default Auto", defaultAuto);
    chooser.addObject("1X", X1);
    chooser.addObject("1AB", AB1);
    chooser.addObject("1CF", CF1);
    chooser.addObject("2X", X2);
    chooser.addObject("2AB", AB2);
    chooser.addObject("2CD", CD2);
    chooser.addObject("3AB", AB3);
    chooser.addObject("3DE", DE3);
    SmartDashboard.putData("Auto Chooser", chooser);
  }

  public Command getAutonomous(String autoChoice) {
    String gameData = DriverStation.getInstance().getGameSpecificMessage();
    SmartDashboard.putString("Game Data", gameData);
    SmartDashboard.putString("AutoSelect", autoChoice);

    switch (autoChoice) {
    case "1AB":
      if (gameData.length() > 0) {
        if (gameData.charAt(0) == 'L') {
          autoCommand = new Red1();
        }
      }
      break;
    case "1CF":
      if (gameData.length() > 0) {
        if (gameData.charAt(0) == 'L') {
          autoCommand = new Red2();
        }
      }
      break;
    case "2X":
      autoCommand = null;
      break;
    case "2AB":
      if (gameData.length() > 0) {
        if (gameData.charAt(0) == 'L') {
          autoCommand = new Red3();
        }
      }
      break;
    case "2CD":
      if (gameData.length() > 0) {
        if (gameData.charAt(0) == 'L') {
          autoCommand = new Blue1();
        }
      }
      break;
    case "3AB":
      if (gameData.length() > 0) {
        if (gameData.charAt(0) == 'L') {
          autoCommand = new Blue2();
        }
      }
      break;
    case "3DE":
      if (gameData.length() > 0) {
        if (gameData.charAt(0) == 'L') {
          autoCommand = new Blue3();
        }
      }
      break;
    case "Default":
    default:
      autoCommand = new BasicAuto();
      break;
    }
    return autoCommand;

  }
}
