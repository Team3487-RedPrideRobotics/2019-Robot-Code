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

	private final Encoder liftEncoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
  	private final Spark liftMotor = new Spark(RobotMap.liftMotor);

    public LiftSubsystem() {

		super(1,0,0);

		liftEncoder.setMaxPeriod(0.1);

		addChild("Lift Encoder",liftEncoder);
		addChild("Lift Motor", liftMotor);

    }

	@Override
	protected double returnPIDInput() {
        //Use the encoder for the PID input
        return liftEncoder.pidGet();
	}

	@Override
	protected void usePIDOutput(double output) {

		liftMotor.pidWrite(output);
		
	}

	@Override
	protected void initDefaultCommand() {
		
	}

	public void log() {

		//TODO Put SmartDashboard Data here

	}



}