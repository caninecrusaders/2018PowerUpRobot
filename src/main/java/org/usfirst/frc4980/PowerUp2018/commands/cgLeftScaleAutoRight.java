package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgLeftScaleAutoRight extends CommandGroup {

    public cgLeftScaleAutoRight() {
    	
    	
    	addSequential(new cmdCubeHold());
    	addParallel(new cgWaitAndRaiseElevator());
        addSequential(new cgLeftScaleAutoRightDriving());
        addSequential(new cmdElevatorCubeDeposit(0.5));
        addSequential(new cmdDriveForwardNoEase(.3, -0.5));
        addParallel(new cmdElevatorReset(2.9, 1.0));
        addSequential(new cmdDriveTurnToAngleTime(.5, -0.75));
        addSequential(new cmdTogglePivot());
        addSequential(new cmdIntakeArmsOpen(0.5));

//        addSequential(new cmdDriveForwardNoEase(1.4, 1.0));
//        addSequential(new cmdDriveCurve(1.0, 0.25, 0, .6));
//        addSequential(new cmdDriveForwardNoEase(1.0, 1.0));
//        addSequential(new cmdDriveCurve(0.2, 1.0, 0, .55));
//        addSequential(new cmdElevatorUp(2.9, 1.0));
//        addSequential(new cmdDriveForwardNoEase(.2, 0.5));
//        addSequential(new cmdElevatorCubeDeposit(0.5));
//        addSequential(new cmdDriveForwardNoEase(.3, -0.5));
//        addParallel(new cmdElevatorReset(2.9, 1.0));
//        addSequential(new cmdDriveTurnToAngleTime(.5, -0.75));
        
        
        requires(Robot.driveSystem);
        requires(Robot.elevator);
        requires(Robot.intake);
        
    }
}
