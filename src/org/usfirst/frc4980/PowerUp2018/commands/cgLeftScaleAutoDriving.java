package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgLeftScaleAutoDriving extends CommandGroup {

    public cgLeftScaleAutoDriving() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	addSequential(new cmdDriveForwardNoEase(1.6, 1.0));
        addSequential(new cmdDriveCurve(0.9, 0.3, 0, .4));
        addSequential(new cmdDriveForwardNoEase(0.2, 1.0));
    	
    	
    	
//    	addSequential(new cmdDriveForwardNoEase(1.3, 1.0));
//        addSequential(new cmdDriveCurve(.9, .3, 0, .4));
//        addSequential(new cmdDriveCurve(.3, 0.9, 0, .4));
//        addSequential(new cmdDriveCurve(0.2, 0.2, 0, .9));
        
        
        requires(Robot.driveSystem);

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
