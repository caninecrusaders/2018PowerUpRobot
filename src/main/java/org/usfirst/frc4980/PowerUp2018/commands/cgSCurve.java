package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgSCurve extends CommandGroup {

    public cgSCurve() {
    	requires(Robot.driveSystem);
    	addSequential(new cmdDriveCurve(1.0, 0.1, 45, .5));
    	addSequential(new cmdDriveForwardNoEase(.3, 1.0));
    	addSequential(new cmdDriveCurve(0.35, 1.0, -45, .5));
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
