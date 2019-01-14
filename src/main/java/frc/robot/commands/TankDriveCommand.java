package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TankDriveCommand extends Command {
    
    public TankDriveCommand() {

        requires(Robot.driveSubsystem);
    
    }

    

    @Override
    protected void execute() {
        
    }

    @Override
    protected boolean isFinished() {
        return false;
    }

    @Override
    protected void end() {
        Robot.driveSubsystem.drive(0,0);
    }

}