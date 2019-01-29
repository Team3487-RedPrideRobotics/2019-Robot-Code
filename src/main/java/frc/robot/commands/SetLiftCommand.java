package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.HeightMap;
import frc.robot.Robot;

public class SetLiftCommand extends Command {

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

    @Override
    protected boolean isFinished() {
        return Robot.liftSubsystem.onTarget();
    }

}