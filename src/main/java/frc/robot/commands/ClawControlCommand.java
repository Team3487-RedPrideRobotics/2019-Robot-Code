package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ClawControlCommand extends Command {

    double speed = 0;

    @Override
    protected boolean isFinished() {
        return false;
    }

    public ClawControlCommand (double speed) {
        requires(Robot.clawSubsytem);
        this.speed = speed;
    }

    @Override
    protected void execute() {

        if(Robot.m_oi.closeClaw.get()) {
            Robot.clawSubsytem.setMotor(-speed);
        } else if (Robot.m_oi.openClaw.get()) {
            Robot.clawSubsytem.setMotor(speed);
        } else {
            Robot.clawSubsytem.setMotor(0);
        }

    }

    @Override
    protected void end() {
        Robot.clawSubsytem.setMotor(0);
    }



}