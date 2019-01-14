package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.TankDriveCommand;

public class DriveSubsystem extends Subsystem {

    private Spark backLeftMotor = new Spark(RobotMap.leftDrive2);
    private Spark frontLeftMotor = new Spark(RobotMap.leftDrive1);

    private Spark backRightMotor = new Spark(RobotMap.rightDrive2);
    private Spark frontRightMotor = new Spark(RobotMap.rightDrive1);

    private SpeedControllerGroup leftDrive = new SpeedControllerGroup(backLeftMotor,frontLeftMotor);
    private SpeedControllerGroup rightDrive = new SpeedControllerGroup(backRightMotor, frontRightMotor);

    private DifferentialDrive m_drive = new DifferentialDrive(leftDrive, rightDrive);

    private Encoder leftEncoder = new Encoder(2, 3, false, Encoder.EncodingType.k4X);
    private Encoder rightEncoder = new Encoder(4, 5, false, Encoder.EncodingType.k4X);

    public DriveSubsystem() {
        super();
        frontLeftMotor.setInverted(true);
        frontRightMotor.setInverted(true);
        addChild("Drive", m_drive);
        addChild("Left Encoder", leftEncoder);
        addChild("Right Encoder", rightEncoder);

    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new TankDriveCommand());
    }

    public void drive(Joystick leftStick, Joystick rightStick) {

        m_drive.tankDrive(leftStick.getY(), rightStick.getY());

    }

    public void drive(double left, double right) {

        m_drive.tankDrive(left, right);

    }



};