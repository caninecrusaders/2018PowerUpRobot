package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmdIntakeArmsOpen extends Command {

    public cmdIntakeArmsOpen(double timeOut) {
    	requires(Robot.intake);
    	setTimeout(timeOut);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.intake.closeArms();
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
    	end();
    }
}
