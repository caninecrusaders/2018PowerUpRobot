// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4980.PowerUp2018.subsystems;

import org.usfirst.frc4980.PowerUp2018.Robot;
import org.usfirst.frc4980.PowerUp2018.RobotMap;
import org.usfirst.frc4980.PowerUp2018.commands.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class driveSystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	private final WPI_TalonSRX frontLeftMotor = RobotMap.driveSystemfrontLeftMotor;
    private final WPI_TalonSRX frontRightMotor = RobotMap.driveSystemfrontRightMotor;
    private final WPI_TalonSRX backLeftMotor = RobotMap.driveSystembackLeftMotor;
    private final WPI_TalonSRX backRightMotor = RobotMap.driveSystembackRightMotor;

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new drive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
    public void tankDriveXbox() {
    	double left = - Robot.oi.xboxController.getRawAxis(1);
    	double right = Robot.oi.xboxController.getRawAxis(5);
    	Robot.driveSystem.frontRightMotor.set(ControlMode.Current, right);
    	frontLeftMotor.set(ControlMode.Current, left);
    	frontRightMotor.set(ControlMode.Current, right);
   	    backRightMotor.set(ControlMode.Current, right);
   	    backLeftMotor.set(ControlMode.Current, left);
    	
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

