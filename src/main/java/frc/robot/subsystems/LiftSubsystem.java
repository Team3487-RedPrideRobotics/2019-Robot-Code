package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class LiftSubsystem extends PIDSubsystem {

    public LiftSubsystem() {

        super(1,0,0);

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