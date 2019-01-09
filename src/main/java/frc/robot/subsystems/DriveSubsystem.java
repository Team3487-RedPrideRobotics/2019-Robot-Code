package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TankDrive;

public class DriveSubsystem extends Subsystem {

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
        frontRightMotor.setInverted(true);
        addChild("Drive", m_drive);

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    



};