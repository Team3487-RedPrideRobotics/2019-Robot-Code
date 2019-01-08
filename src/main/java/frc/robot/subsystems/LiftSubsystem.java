package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
/**
 * This is the Subsystem class that controls the lift/elevator on the robot.
 * @author Jacob Armstrong
 */
public class LiftSubsystem extends PIDSubsystem {

	Encoder counter;
	Spark liftMotor;

    public LiftSubsystem() {

		super(1,0,0);
		counter = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
		counter.setMaxPeriod(.1);

		this.liftMotor = RobotMap.liftMotor;

    }

	@Override
	protected double returnPIDInput() {
        //Use the encoder for the PID input
        return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		
	}

	@Override
	protected void initDefaultCommand() {
		
	}



}