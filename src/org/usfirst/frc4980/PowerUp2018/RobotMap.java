// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4980.PowerUp2018;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
	public static Talon driveSystemfrontLeftMotor;
    public static Talon driveSystemfrontRightMotor;
    public static Talon driveSystembackLeftMotor;
    public static Talon driveSystembackRightMotor;
    public static Talon leftCubeArm;
    public static Talon rightCubeArm;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    @SuppressWarnings("deprecation")
	public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
          // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	driveSystemfrontLeftMotor = new Talon(2);
        LiveWindow.add(driveSystemfrontLeftMotor);
        
        driveSystemfrontRightMotor = new Talon(1);
        LiveWindow.add(driveSystemfrontRightMotor);
        
        driveSystembackLeftMotor = new Talon(0);
        LiveWindow.add(driveSystembackLeftMotor);
        
        driveSystembackRightMotor = new Talon(3);
        LiveWindow.add(driveSystembackRightMotor);
        
        leftCubeArm = new Talon(4);
        LiveWindow.add(leftCubeArm);
        
        rightCubeArm = new Talon(5);
        LiveWindow.add(rightCubeArm);
    }
}