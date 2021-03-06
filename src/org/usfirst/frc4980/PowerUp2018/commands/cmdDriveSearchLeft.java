package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.OI;
import org.usfirst.frc4980.PowerUp2018.Robot;
import org.usfirst.frc4980.PowerUp2018.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmdDriveSearchLeft extends Command {

    public cmdDriveSearchLeft() {
       requires(Robot.driveSystem);
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSystem.setUpPIDController();
    	Robot.driveSystem.enablePIDController();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(!OI.cubeCoords.valid){
    		//Have not found cube keep rotating right
        	Robot.driveSystem.rotate(-0.25);
        }else{
        	//Found cube rotate until centered
        	double angle = OI.cubeCoords.horizontalAngle;
        	Robot.driveSystem.rotateToAngle(angle);
       }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
        
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.disablePIDController();
    	RobotMap.driveSystemfrontLeftMotor.set(0);
    	RobotMap.driveSystemfrontRightMotor.set(0);
   	    RobotMap.driveSystembackRightMotor.set(0);
   	    RobotMap.driveSystembackLeftMotor.set(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
