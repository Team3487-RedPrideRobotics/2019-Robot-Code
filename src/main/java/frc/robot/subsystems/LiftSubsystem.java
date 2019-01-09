package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * This is the Subsystem class that controls the lift/elevator on the robot.
 * @author Jacob Armstrong
 */
public class LiftSubsystem extends PIDSubsystem {

	private Encoder encoder;
	private Spark liftMotor;

    public LiftSubsystem() {

		super(1,0,0);
		this.liftMotor = RobotMap.liftMotor;
		this.encoder = RobotMap.liftEncoder;

		encoder.setMaxPeriod(0.1);

    }

	@Override
	protected double returnPIDInput() {
        //Use the encoder for the PID input
        return encoder.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {

		liftMotor.pidWrite(output);
		
	}

	@Override
	protected void initDefaultCommand() {
		
	}



}