package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.HeightMap;
import frc.robot.Robot;
import frc.robot.subsystems.LiftSubsystem;

public class SetLiftCommand extends Command {

    private double rot;

    public SetLiftCommand(HeightMap rotations) {

        super("Hatch1");
        requires(Robot.liftSubsystem);
        this.rot = rotations.rot;

    }

    @Override
    protected void initialize() {
        System.out.println("Setting setpoint to "+rot);
        Robot.liftSubsystem.setSetpoint(rot);

    }

    @Override
    protected void execute() {
        System.out.println("Current Setpoint "+Robot.liftSubsystem.getSetpoint());
        System.out.println("Current Position " + Robot.liftSubsystem.getPosition());
    }

    @Override
    protected boolean isFinished() {
        return Robot.liftSubsystem.onTarget();
    }

}