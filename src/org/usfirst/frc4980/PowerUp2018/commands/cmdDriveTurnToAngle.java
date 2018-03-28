package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmdDriveTurnToAngle extends Command {
	double toAngle;
    public cmdDriveTurnToAngle(double timeOutS, double angleIn) {
    	toAngle = angleIn;
    	requires(Robot.driveSystem);
    	setTimeout(timeOutS);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSystem.setUpPIDController();
    	Robot.driveSystem.rotateToAngle(toAngle);
    	Robot.driveSystem.enablePIDController();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.rotateToAngle(toAngle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(isTimedOut() || Robot.driveSystem.isOnTargetAngle()){
            return true;
    	}
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.stop();
    	Robot.driveSystem.disablePIDController();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
