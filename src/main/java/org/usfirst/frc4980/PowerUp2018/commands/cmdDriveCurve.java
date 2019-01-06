package org.usfirst.frc4980.PowerUp2018.commands;

import java.sql.Date;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.TimedCommand;

/**
 *
 */
public class cmdDriveCurve extends Command {
	double max;
	double min;
	double a;
	
    public cmdDriveCurve(double leftSpeed, double rightSpeed, double angle, double timeOutS) {
    	requires(Robot.driveSystem);
    	setTimeout(timeOutS);
    	max = leftSpeed;
    	min = rightSpeed;
    	a = angle;
    	
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.driveSystem.setUpPIDController();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.curve(max, min, a);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	//|| Robot.driveSystem.pidOnTarget()
    	if(isTimedOut()){
    		return true;
    	}
        return false;
    }
//    	double t = now.getTime()-startTime.getTime();
//    	if(t>=duration){
//    		return true;
//    	}
//        return false;

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
