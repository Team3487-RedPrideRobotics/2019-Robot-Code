package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Rotate128 extends Command {

    public Rotate128() {
        requires(Robot.test128);
    }

    @Override
    protected void initialize() {

        Robot.test128.reset();
        Robot.test128.drive(1);

    }

    @Override
    protected void end() {
        Robot.test128.drive(0);
    }

    @Override
    protected boolean isFinished() {
        if(Robot.test128.getRot() >= 128) {
            return true;
        }
        return false;
    }



}