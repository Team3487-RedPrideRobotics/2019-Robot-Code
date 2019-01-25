package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;

/**
 * This is the Subsystem class that controls the lift/elevator on the robot.
 * @author Jacob Armstrong
 */
public class LiftSubsystem extends Subsystem {

	private final Encoder encoder = new Encoder(RobotMap.liftEncoder0, RobotMap.liftEncoder1, false, Encoder.EncodingType.k4X);
	private final Spark liftMotor = new Spark(RobotMap.liftMotor);

	//The Direction of the motor
	private boolean direction = true;
	//The target height for the lift
	private double setPoint;

    public LiftSubsystem() {

		encoder.setMaxPeriod(0.1);
		encoder.setDistancePerPulse(1D/(2D*64D*1024D));
		addChild("Encoder",encoder);
		addChild("Lift Motor", liftMotor);

  }

	@Override
	protected void initDefaultCommand() {}

	public void setSetpoint(double setPoint) {
		this.setPoint = setPoint;
		calculate();
	}

	public boolean onTarget() {
		if(encoder.getDistance() <= setPoint*1.05 && encoder.getDistance() >= setPoint*0.95) {
			return true;
		}
		return false;
	}

	public void calculate() {
		if(setPoint > encoder.getDistance()){
			direction = true;
		} else {
			direction = false;
		}
		
		if(onTarget()) {
			liftMotor.set(0);
		} else if(Math.abs(setPoint-encoder.getDistance()) > 0.01) {
			liftMotor.set(0.15);
		} else if(Math.abs(setPoint-encoder.getDistance()) > 0.)
	}

	public void log() {

		SmartDashboard.putData("Height Setting", this);

	}

} 