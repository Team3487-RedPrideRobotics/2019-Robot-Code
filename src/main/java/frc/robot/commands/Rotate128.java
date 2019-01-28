package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class Rotate128 extends Command {

    public Rotate128() {
        requires(Robot.test128);
    }

    @Override
    protected void execute() {
        System.out.println(Robot.test128.getRot());
    }

    @Override
    protected void initialize() {

        Robot.test128.reset();
        Robot.test128.drive(0.25D);

    }

    @Override
    protected void end() {
        Robot.test128.drive(0);
    }

    @Override
    protected boolean isFinished() {
        if(Robot.test128.getRot() >=64*2*1024) {
            return true;
        }
        return false;
    }



}