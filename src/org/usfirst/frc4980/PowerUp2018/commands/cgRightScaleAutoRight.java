package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgRightScaleAutoRight extends CommandGroup {

    public cgRightScaleAutoRight() {
    	
    	addSequential(new cmdCubeHold());
      //  addSequential(new cmdDriveForwardNoEase(1.2, 1.0));
//        addSequential(new cmdDriveCurve(0.3, .9, 0, .4));
//        addSequential(new cmdDriveCurve(.9, 0.3, 0, .4));
    	addParallel(new cgRightScaleAutoDriving());
        addParallel(new cmdIntakeArmsOpen(1.0));
        addSequential(new cmdElevatorUp(2.9, 1.0));
       // addSequential(new cmdDriveCurve(0.2, 0.3, 0, .9));
        addSequential(new cmdElevatorCubeDeposit(0.5));
        addSequential(new cmdDriveForwardNoEase(.5, -0.5));
        addSequential(new cmdElevatorReset(2.9, 1.0));
        addSequential(new cmdDriveTurnToAngleTime(.5, -0.8));
        addSequential(new cmdTogglePivot());
  
    	
    	
    	
    	
    	//addSequential(new cmdDriveTurnToAngleTime(0.6, -0.40));
//        addSequential(new cmdDriveForwardNoEase(0.5, 0.5));
//        addSequential(new cmdWait(0.5));
//        addSequential(new cmdElevatorCubeDeposit(0.5));
//        addSequential(new cmdElevatorReset(2.0, 1.0));
        
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
