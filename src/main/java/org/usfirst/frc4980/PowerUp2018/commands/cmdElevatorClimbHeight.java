package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmdElevatorClimbHeight extends Command {
	double height;
	
    public cmdElevatorClimbHeight(double heightIn) {
    	height = heightIn;
    	if(heightIn<17.5){
    		height = 17.5;
    	} else if(heightIn>76.5){
    		height = 76.5;
    	}
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    public cmdElevatorClimbHeight(){
    	height = 30.0;
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.elevator.setUpPIDController();
    	Robot.elevator.enablePIDController();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.setElevatorHeight(height);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
       return Robot.elevator.pidOnTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.stop();
    	Robot.elevator.disablePID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
