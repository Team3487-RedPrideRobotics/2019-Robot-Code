package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ClawControlCommand;

public class ClawSubsystem extends Subsystem {

    //Claw Motor
    private Spark redLine = new Spark(RobotMap.clawMotor);
    
    private DigitalInput limitSwitch = new DigitalInput(RobotMap.clawLimiter);
    
    private Timer resetTimer = new Timer();

    private int resetTime = 0;

    //Constructor
    public ClawSubsystem() {
        addChild(redLine);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ClawControlCommand(RobotMap.clawSpeed));
    }

    public void setMotor(double speed) {

        if(limitSwitch.get() && resetTimer.get() - resetTime == 5 && speed > 0) {
            
            redLine.set(0);
            return;
        
        }
        redLine.set(speed);

    }



}