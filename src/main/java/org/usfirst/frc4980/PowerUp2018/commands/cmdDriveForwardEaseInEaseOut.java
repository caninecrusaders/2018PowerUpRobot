package org.usfirst.frc4980.PowerUp2018.commands;

import java.util.Date;

import org.usfirst.frc4980.PowerUp2018.Robot;


import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmdDriveForwardEaseInEaseOut extends Command {
	Date startTime;
	double commandDuration = 3; //seconds
	double speed = 0.5;

    public cmdDriveForwardEaseInEaseOut() {
    	requires(Robot.driveSystem);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public cmdDriveForwardEaseInEaseOut(double duration, double speedIn){
    	requires(Robot.driveSystem);
    	speed = speedIn;
    	commandDuration = duration;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
    	startTime = new Date();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double currentSpeed = speed;
    	Date now = new Date();
    	double duration = commandDuration/2.0;
    	double startValue = 0.0;
    	double changeInValue = speed;
    	double currentTime = now.getTime()-startTime.getTime();
    	currentSpeed = Robot.driveSystem.easeInOut(currentTime, startValue, changeInValue, commandDuration);
    	if(currentTime>commandDuration){
    		currentSpeed = 0.0;
    		
    	}
    	
    	 Robot.driveSystem.drive(currentSpeed);
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	Date now = new Date();
    	double t = now.getTime()-startTime.getTime();
    	if(t>=commandDuration){
    		return true;
    	}	
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
