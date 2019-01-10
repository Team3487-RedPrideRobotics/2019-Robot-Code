/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.SetLiftCommand;

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
  private final Joystick left = new Joystick(0);
  private final Joystick right = new Joystick(1);

  public OI() {
    
    SmartDashboard.putData("Set Lift To Cargo1", new SetLiftCommand(HeightMap.Cargo1));
    SmartDashboard.putData("Set Lift To Hatch1", new SetLiftCommand(HeightMap.Hatch1));
    SmartDashboard.putData("Set Lift To Cargo2", new SetLiftCommand(HeightMap.Cargo2));
    SmartDashboard.putData("Set Lift To Hatch2", new SetLiftCommand(HeightMap.Hatch2));
    SmartDashboard.putData("Set Lift To Cargo3", new SetLiftCommand(HeightMap.Cargo3));
    SmartDashboard.putData("Set Lift To Hatch3", new SetLiftCommand(HeightMap.Hatch3));
    SmartDashboard.putData("Set Lift To Base Height", new SetLiftCommand(HeightMap.Base));

    final Button cargo1Button = new JoystickButton(left, 8);
    cargo1Button.whenPressed(new SetLiftCommand(HeightMap.Cargo1));
 /*
 Jacob, before you start to make changes in every document (which yes I will admit is good)
 you MUST talk to me about it.  Changing 34 thousand things and then expecting me to understand is not okay.
 This is a necessary change, please abide by it.  I will be putting this on all docs
 in case you don't visit this one.
*/
    final Button hatch1Button = new JoystickButton(left, 7);
    hatch1Button.whenPressed(new SetLiftCommand(HeightMap.Hatch1));

    final Button cargo2Button =  new JoystickButton(left, 10);
    cargo2Button.whenPressed(new SetLiftCommand(HeightMap.Cargo2));

    final Button hatch2Button = new JoystickButton(left, 9);
    hatch2Button.whenPressed(new SetLiftCommand(HeightMap.Hatch2));

    final Button cargo3Button =  new JoystickButton(left, 12);
    cargo3Button.whenPressed(new SetLiftCommand(HeightMap.Cargo3));

    final Button hatch3Button = new JoystickButton(left, 11);
    hatch3Button.whenPressed(new SetLiftCommand(HeightMap.Hatch3));

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
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
  }

  public Joystick getStick(boolean isLeftStick) {

    if(isLeftStick) {
      return left;

    } else {
      return right;
    }

  }
}
