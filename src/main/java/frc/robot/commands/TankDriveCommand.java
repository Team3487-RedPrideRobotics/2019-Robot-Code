package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

<<<<<<< Updated upstream:src/main/java/frc/robot/commands/TankDrive.java
public class TankDrive extends Command {
=======
public class TankDriveCommand extends Command {
    
    public TankDriveCommand() {

        requires(Robot.driveSubsystem);
>>>>>>> Stashed changes:src/main/java/frc/robot/commands/TankDriveCommand.java

    

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