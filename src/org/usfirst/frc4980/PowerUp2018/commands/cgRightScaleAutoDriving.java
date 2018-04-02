package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgRightScaleAutoDriving extends CommandGroup {

    public cgRightScaleAutoDriving() {
    	
    	
        addSequential(new cmdDriveForwardNoEase(1.6, 1.0));
        addSequential(new cmdDriveCurve(0.3, .9, 0, .5));
        
        
        
 // West Valley Scale      
//        addSequential(new cmdDriveForwardNoEase(1.3, 1.0));
//        addSequential(new cmdDriveCurve(0.3, .9, 0, .4));
//        addSequential(new cmdDriveCurve(.9, 0.3, 0, .4));
//        addSequential(new cmdDriveCurve(0.2, 0.2, 0, .9));
        
        requires(Robot.driveSystem);

    }
}
