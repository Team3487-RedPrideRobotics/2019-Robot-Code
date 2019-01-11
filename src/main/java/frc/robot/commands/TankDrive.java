package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDrive extends Command {
    
    public TankDrive() {

        requires(Robot.driveSubsystem);

    }

    @Override
    protected void execute() {
        
        Robot.driveSubsystem.drive(Robot.m_oi.getStick(true),Robot.m_oi.getStick(false));

    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void finalize() throws Throwable {
        
    }



}