package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgRightScaleAutoLeftDriving extends CommandGroup {

    public cgRightScaleAutoLeftDriving() {
    	
    	
        addSequential(new cmdDriveForwardNoEase(1.4, 1.0));
        addSequential(new cmdDriveCurve(0.2, 1.0, 0, .6));
        addSequential(new cmdDriveForwardNoEase(0.7, 1.0));
        addSequential(new cmdDriveCurve(1.0, .2, 0, .55));
        addSequential(new cmdDriveForwardNoEase(.2, 0.5));
        
        
        
        requires(Robot.driveSystem);
    }
}
