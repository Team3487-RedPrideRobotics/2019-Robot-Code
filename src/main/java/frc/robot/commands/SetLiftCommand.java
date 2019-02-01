package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.HeightMap;
import frc.robot.Robot;

public class SetLiftCommand extends Command {

    //The rotations to be set
    private double rot;

    public SetLiftCommand(HeightMap rotations) {

        super("Hatch1");
        requires(Robot.liftSubsystem);

        this.rot = rotations.rot;

    }

    @Override
    protected void initialize() {

        Robot.liftSubsystem.setSetpoint(rot);

    }

    /**
     * This gets called almost non-stop, so this is checking everytime
     * making sure the lift is on target.
    */
    @Override
    protected void execute() {
        Robot.liftSubsystem.calculate();
    }

    @Override
    protected boolean isFinished() {
        return Robot.liftSubsystem.onTarget();
    }

}