package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgLeftScaleAutoLeft extends CommandGroup {

    public cgLeftScaleAutoLeft() {
    	
    	
    	addSequential(new cmdCubeHold());
    	addParallel(new cgLeftScaleAutoDriving());
        addSequential(new cmdElevatorUp(2.9, 1.0));
        addSequential(new cmdElevatorCubeDeposit(0.5));
        addSequential(new cmdDriveForwardNoEase(1.5, -0.5));
        addParallel(new cmdElevatorReset(2.9, 1.0));
//        addSequential(new cmdDriveTurnToAngleTime(.5, 0.75));
        //addSequential(new cmdTogglePivot());
        addSequential(new cmdIntakeArmsOpen(.2));
    	
    	
    	
    	
    	
    	
    	
//    	addParallel(new cgLeftScaleAutoDriving());
//        //addParallel(new cmdIntakeArmsOpen(1.0));
//        addSequential(new cmdElevatorUp(2.9, 1.0));
//        addSequential(new cmdElevatorCubeDeposit(0.5));
//        addSequential(new cmdDriveForwardNoEase(.5, -0.5));
//        addSequential(new cmdElevatorReset(2.9, 1.0));
//        addSequential(new cmdDriveTurnToAngleTime(.5, 0.8));
//        addSequential(new cmdTogglePivot());
//        
        requires(Robot.driveSystem);
        requires(Robot.elevator);
        requires(Robot.intake);
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
