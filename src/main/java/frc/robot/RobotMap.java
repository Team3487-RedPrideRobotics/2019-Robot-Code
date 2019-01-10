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

 /*
 Jacob, before you start to make changes in every document (which yes I will admit is good)
 you MUST talk to me about it.  Changing 34 thousand things and then expecting me to understand is not okay.
 This is a necessary change, please abide by it.  I will be putting this on all docs
 in case you don't visit this one.
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

  public static int liftMotor = 4;

  public static int leftDrive1 = (0);
  public static int leftDrive2 = 1;
  
  public static int rightDrive1 =(2);
  public static int rightDrive2 =(3);

}
