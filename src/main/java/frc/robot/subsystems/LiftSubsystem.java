package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
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

	private final DigitalInput bottomLimiter = new DigitalInput(RobotMap.liftLimiter);

	private final Timer resetTimer = new Timer();

	private double resetTime = 0;

	//The Direction of the motor
	private boolean direction = true;
	//The target height for the lift
	private double setPoint;

    public LiftSubsystem() {

		encoder.setMaxPeriod(0.1);
		encoder.setDistancePerPulse(1D/(RobotMap.rotationsPerInch*RobotMap.liftGearBox*RobotMap.countsPerRotation));
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

		if(bottomLimiter.get() && resetTimer.get()-resetTime >= 5) {

			liftMotor.set(0);
			encoder.reset();
			resetTime = resetTimer.get();
			return;
			
		}

		if(setPoint > encoder.getDistance()){
			direction = true;
		} else {
			direction = false;
		}
		
		if(onTarget()) {
			liftMotor.set(0);
		} else if(Math.abs(setPoint-encoder.getDistance()) > RobotMap.percentErrorLow) {
			liftMotor.set(direction ? RobotMap.liftSlow : -RobotMap.liftSlow);
		} else if(Math.abs(setPoint-encoder.getDistance()) > RobotMap.percentErrorHigh) {
			liftMotor.set(direction ? RobotMap.liftFast : -RobotMap.liftFast);
		}
	}

	public double getRot() {
		return encoder.getDistance();
	}

	public void log() {

		SmartDashboard.putData("Height Setting", this);

	}

} 