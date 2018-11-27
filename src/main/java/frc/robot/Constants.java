package frc.robot;

/** 
 * Will contain all constants for the motor. Will be the basis of an acceleration program that I will try to make.
 * 
 * TODO IN DEVOLPMENT
*/
public class Constants {

    // DRIVETRAIN SUBSYSTEM
    public Double DTForwardSpeedMax = 0.7;
    public Double DTForwardSpeedMin = 0.3;
    public Double DTReverseSpeedMax = -0.7;
    public Double DTReverseSpeedMin = -0.3;
    
    public Integer DTLeftRearTalonInteger = 0;
    public Integer DTRightFrontTalonInteger = 1;
    public Integer DTLeftFrontTalonInteger = 2;
    public Integer DTRightRearTalonInteger = 3;

    // CLIMB MOTORS
    public Integer ClimbMainMotorTalonNumber = 4;
    public Integer ClimbAltMotorTalonNumber = 7;

    // SHOOTER SUBSYSTEM
    public Integer ShootKickerTalonInteger = 1;
    public Integer ShootMotorTalonInteger = 6;

    // GATE + SWEEPER
    public Integer GateTalonInteger = 0;
    public Integer SweepMotorTalonInteger = 5;


}