package frc.robot;

//imports
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap class contains the virtual representations of the components so
 * we can program them
 */
public class RobotMap {
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
    // Climb motors inits
    CLIMB_MOTOR = new Talon(4);
    LiveWindow.addActuator("Climb", "Motor 1", CLIMB_MOTOR);

    CLIMB_ALT = new Talon(7);
    LiveWindow.addActuator("Climb", "Motor 2", CLIMB_ALT);

    // Drivetrain motors
    DT_LEFTFRONT = new Talon(2);
    LiveWindow.addActuator("DriveTrain", "DT_LEFTFRONT", DT_LEFTFRONT);

    DT_RIGHTFRONT = new Talon(1);
    LiveWindow.addActuator("DriveTrain", "DT_RIGHTFRONT", DT_RIGHTFRONT);

    DT_LEFTREAR = new Talon(0);
    LiveWindow.addActuator("DriveTrain", "DT_LEFTREAR", DT_LEFTREAR);

    DT_RIGHTREAR = new Talon(3);
    LiveWindow.addActuator("DriveTrain", "DT_RIGHTREAER", DT_RIGHTREAR);
    // Drivetrain others
    DT_GYRO = new ADXRS450_Gyro();
    DT_GYRO.reset();
    DT_GYRO.calibrate();
    LiveWindow.addSensor("DriveTrain", "DT_GYRO", DT_GYRO);

    DRIVETRAIN = new MecanumDrive(DT_LEFTFRONT, DT_LEFTREAR, DT_RIGHTFRONT, DT_RIGHTREAR);

    // Gear Parts
    GEAR_CAM = CameraServer.getInstance().startAutomaticCapture("GEAR", 0);
    GEAR_CAM.setBrightness(0);
    GEAR_CAM.setResolution(160, 120);
    GEAR_CAM.setFPS(30);

    GEAR_SWITCH = new DigitalInput(0);
    LiveWindow.addSensor("GEAR SWITCH", 0, GEAR_SWITCH);

    // Shooter Stuff
    SHOOT_CAM = CameraServer.getInstance().startAutomaticCapture("SHOOTER", 1);
    SHOOT_CAM.setBrightness(0);
    SHOOT_CAM.setResolution(160, 120);

    SHOOT_KICKER = new Talon(1);
    LiveWindow.addActuator("Shooter", "Kicker", SHOOT_KICKER);

    SHOOT_MOTOR = new Talon(6);
    LiveWindow.addActuator("Shooter", "Motor", (Talon) SHOOT_MOTOR);

    GATE = new Talon(0);
    LiveWindow.addActuator("Shooter", "Gate", GATE);

    SWEEP_MOTOR = new Talon(5);
    LiveWindow.addActuator("Sweeper", "Motor", (Talon) SWEEP_MOTOR);
  }
}
