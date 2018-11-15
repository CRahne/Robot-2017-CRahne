package frc.robot;

//imports
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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

/** Where buttons and joysticks are created */
public class OI {

  public Joystick OpStick = new Joystick(0);// Main controller joystick

  // buttons
  private JoystickButton ClimbUp;
  private JoystickButton ClimbDown;
  private JoystickButton SweeperForward;
  private JoystickButton SweeperReverse;

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

  /** Made only for autos */
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

    // My guess at an auto chooser
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
