package frc.robot;

//imports
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.Constants;

/**
 * The RobotMap class contains the virtual representations of the components so
 * we can program them
 */
public class RobotMap {
  public Constants c = new Constants();
  
  // Climb motors
  public static Talon CLIMB_MOTOR;
  public static Talon CLIMB_ALT;

  // Drivetrain Motors
  public static Talon DT_LEFTFRONT;
  public static Talon DT_LEFTREAR;
  public static Talon DT_RIGHTFRONT;
  public static Talon DT_RIGHTREAR;
  // Drivetrain others
  public static ADXRS450_Gyro DT_GYRO;
  public static MecanumDrive DRIVETRAIN;

  // Gear Parts
  public static UsbCamera GEAR_CAM;
  public static DigitalInput GEAR_SWITCH;

  // Shooter Parts
  public static UsbCamera SHOOT_CAM;
  public static Talon SHOOT_MOTOR;
  public static Encoder SHOOT_ENCODER;
  public static Talon SHOOT_KICKER;
  public static Talon GATE;
  public static Talon SWEEP_MOTOR;

  /**
   * the initialize where everything is created and added to the runtime window
   */
  public static void init() {
    Constants c = new Constants();
    // Climb motors inits
    CLIMB_MOTOR = new Talon(c.ClimbMainMotorTalonNumber);

    CLIMB_ALT = new Talon(c.ClimbAltMotorTalonNumber);

    // Drivetrain motors
    DT_LEFTFRONT = new Talon(c.DTLeftFrontTalonInteger);

    DT_RIGHTFRONT = new Talon(c.DTRightFrontTalonInteger);

    DT_LEFTREAR = new Talon(c.DTLeftRearTalonInteger);

    DT_RIGHTREAR = new Talon(c.DTRightRearTalonInteger);
    // Drivetrain others
    DT_GYRO = new ADXRS450_Gyro();
    DT_GYRO.reset();
    DT_GYRO.calibrate();

    DRIVETRAIN = new MecanumDrive(DT_LEFTFRONT, DT_LEFTREAR, DT_RIGHTFRONT, DT_RIGHTREAR);

    // Gear Parts
    GEAR_CAM = CameraServer.getInstance().startAutomaticCapture("GEAR", 0);
    GEAR_CAM.setBrightness(0);
    GEAR_CAM.setResolution(160, 120);
    GEAR_CAM.setFPS(30);

    GEAR_SWITCH = new DigitalInput(0);

    // Shooter Stuff
    SHOOT_CAM = CameraServer.getInstance().startAutomaticCapture("SHOOTER", 1);
    SHOOT_CAM.setBrightness(0);
    SHOOT_CAM.setResolution(160, 120);

    SHOOT_KICKER = new Talon(c.ShootKickerTalonInteger);

    SHOOT_MOTOR = new Talon(c.ShootMotorTalonInteger);

    GATE = new Talon(c.GateTalonInteger);

    SWEEP_MOTOR = new Talon(c.SweepMotorTalonInteger);
  }
}
