package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.HeightMap;
import frc.robot.Robot;

public class H1MoveCommand extends Command {

    public H1MoveCommand() {

        super("Hatch1");
        requires(Robot.liftSubsystem);

    }

    @Override
    protected void initialize() {

        Robot.liftSubsystem.setSetpoint((double) HeightMap.Hatch1.rot);

    }

    @Override
    protected boolean isFinished() {
        return Robot.liftSubsystem.onTarget();
    }

}