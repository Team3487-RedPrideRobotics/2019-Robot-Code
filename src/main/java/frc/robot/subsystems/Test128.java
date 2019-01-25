package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Test128 extends Subsystem {

    private final Encoder encoder = new Encoder(RobotMap.testEncoder0,RobotMap.testEncoder1);

    private final Spark redLine = new Spark(RobotMap.testMotor);
    
    public Test128() {
        addChild(encoder);
        addChild(redLine);
    }
    
    @Override
    protected void initDefaultCommand() {

    }

    public void drive(double speed) {
        redLine.set(speed);
    }

    public void reset() {
        encoder.reset();
    }

    public double getRot() {

        return ((double)encoder.getRaw())/128D;

    }

    

}