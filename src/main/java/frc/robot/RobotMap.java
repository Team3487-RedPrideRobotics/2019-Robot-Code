/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  /**
   * 
   * PORTS
   *      Used for motors, switches, sensors, etc.
   * 
  **/

  //DIO
  public static final int liftEncoder0 = 0;
  public static final int liftEncoder1 = 1;

  public static final int liftLimiter = 2;

  public static final int clawLimiter = 3; 

  //PWM
  public static final int liftMotor = 6;

  public static final int leftDrive1 = 3; //Front Side
  public static final int leftDrive2 = 4; //Back Side
  
  public static final int rightDrive1 = 8; //Front Side
  public static final int rightDrive2 = 9; //Back Side

  public static final int clawMotor = 7;

  /**
   * 
   * CONSTANTS  
   *    Used for setting speed constants, etc.
   * 
  **/

  //Claw Speed
  public static final double clawSpeed = 0.2;

  // Lift Speeds - Absolute values (Up and Down)
  public static final double liftSlow = 0.2; //Precision
  public static final double liftFast = 0.8; //Move!

  public static final double low = 0;

  /** 
   * Heigths are doubled because the numbers are rotations, and
   * rotations are 1/2".
  */
  public static final double hatch1 = 19*2;
  public static final double cargo1 = 27.5*2;
  public static final double hatch2 = 47*2;
  public static final double cargo2 = 55.5*2;
  public static final double hatch3 = 75*2;
  public static final double cargo3 = 83.5*2;


}
