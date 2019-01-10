package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class DriveSubsystem extends Subsystem {
 /*
 Jacob, before you start to make changes in every document (which yes I will admit is good)
 you MUST talk to me about it.  Changing 34 thousand things and then expecting me to understand is not okay.
 This is a necessary change, please abide by it.  I will be putting this on all docs
 in case you don't visit this one.
*/
    private Spark backLeftMotor = new Spark(RobotMap.leftDrive2);
    private Spark frontLeftMotor = new Spark(RobotMap.leftDrive1);

    private Spark backRightMotor = new Spark(RobotMap.rightDrive2);
    private Spark frontRightMotor = new Spark(RobotMap.rightDrive1);

    private SpeedControllerGroup leftDrive = new SpeedControllerGroup(backLeftMotor,frontLeftMotor);
    private SpeedControllerGroup rightDrive = new SpeedControllerGroup(backRightMotor, frontRightMotor);

    //WE ARE NOT USING DIFFERENTIAL DRIVE I'VE SAID THIS SO MANY TIMES NO


    public DriveSubsystem() {
        super();
        frontLeftMotor.setInverted(true);

        //By the way, only the right side motors should be inverted.  I can explain but I look stupid doing it.
        frontRightMotor.setInverted(true);
        addChild("Drive", m_drive);

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    



};