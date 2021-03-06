package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgCenterAutoRight extends CommandGroup {

    public cgCenterAutoRight() {
    	
    	requires(Robot.driveSystem);
    	addSequential(new cmdCubeHold());
    	addSequential(new cmdDriveCurve(1.0, 0.1, 45, .5));
    	addParallel(new cmdDriveForwardNoEase(.3, .8));
    	addParallel(new cmdIntakeArmsOpen(0.3));
    	addSequential(new cmdElevatorUp(0.6, 1.0));
    	addSequential(new cmdDriveCurve(0.35, 1.0, -45, .5));
    	addSequential(new cmdDriveForwardCollision(1.0, 0.25));
    	addSequential(new cmdElevatorCubeDeposit(1.0));
        addSequential(new cmdElevatorReset(0.6, 1.0));
        
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
