package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmdElevatorReset extends Command {
	private double speed;
    public cmdElevatorReset(double timeOutS, double speedIn) {
    	requires(Robot.elevator);
    	speed = speedIn;
    	setTimeout(timeOutS);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize(double speed) {
    	Robot.elevator.release();
    	Robot.elevator.retract();
    	Robot.elevator.elevatorDown(speed);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.elevatorDown(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isTimedOut()){
        return true;
        }
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
