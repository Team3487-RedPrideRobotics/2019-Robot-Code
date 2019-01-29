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

  //DIO
  public static int liftEncoder0 = 0;
  public static int liftEncoder1 = 1;

  public static int liftLimiter = 2;

  public static int clawLimiter = 3; 

  //PWM
  public static int liftMotor = 0;

  public static int leftDrive1 = 3; //Front
  public static int leftDrive2 = 4; //Back
  
  public static int rightDrive1 = 8; //Front
  public static int rightDrive2 = 9; //Back

  public static int clawMotor = 7;

  //Constants
  public static double clawSpeed = 0.2;

  public static double liftSlow = 0.2;
  public static double liftFast = 0.4;

}
