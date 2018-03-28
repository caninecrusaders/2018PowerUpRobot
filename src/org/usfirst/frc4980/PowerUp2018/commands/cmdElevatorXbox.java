package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class cmdElevatorXbox extends Command {
	public int i=0;
    public cmdElevatorXbox() {
    	requires(Robot.elevator);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Robot.TFMini.readString();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//SmartDashboard.putNumber("TFMini_ElevatorCount", i++);
    	
    	//if(i%100==0)
    	//{
//        	try {
//        		SmartDashboard.putNumber("TFMini_BytesReceived", Robot.TFMini.getBytesReceived());
//            	
//        		String read = Robot.TFMini.readString();
//        		//if(read.length()>0){
//        			SmartDashboard.putString("TFMini_ElevatorHeight",read );
//                	System.out.println(read);
//        		//}	
//            }
//            catch (Exception ex) {
//            	DriverStation.reportError("Error reading TFMini: "+ ex.getMessage(), true);
//            }
        	Robot.elevator.elevatorXbox();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
