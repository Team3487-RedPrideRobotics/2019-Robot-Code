package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * This is the Subsystem class that controls the lift/elevator on the robot.
 * @author Jacob Armstrong
 */
public class LiftSubsystem extends PIDSubsystem {

	private final Encoder encoder = new Encoder(RobotMap.liftEncoder0, RobotMap.liftEncoder1, false, Encoder.EncodingType.k4X);
	
	private final Spark liftMotor = new Spark(RobotMap.liftMotor);

    public LiftSubsystem() {

		super(1,0,0);
		encoder.setPIDSourceType(PIDSourceType.kDisplacement);
		//TODO edit proportion to accurate value
		encoder.setDistancePerPulse(1D/(1024D*64D*2D));
		encoder.setMaxPeriod(0.1);
		this.setAbsoluteTolerance(0.01);
		this.getPIDController().setContinuous(false);

		addChild("Encoder",encoder);
		addChild("Lift Motor", liftMotor);

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

	public void log() {

		SmartDashboard.putData("Height Setting", this);

	}



}