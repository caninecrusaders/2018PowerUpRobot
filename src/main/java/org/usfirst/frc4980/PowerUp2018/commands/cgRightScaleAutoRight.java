package org.usfirst.frc4980.PowerUp2018.commands;

import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgRightScaleAutoRight extends CommandGroup {

    public cgRightScaleAutoRight() {
    	
    	addSequential(new cmdCubeHold());
    	addParallel(new cgRightScaleAutoDriving());
        addSequential(new cmdElevatorUp(2.9, 1.0));
        addSequential(new cmdElevatorCubeDeposit(0.5));
        addSequential(new cmdDriveForwardNoEase(1.5, -0.5));
        addParallel(new cmdElevatorReset(2.9, 1.0));
       // addSequential(new cmdDriveTurnToAngleTime(.5, -0.75));
      //  addSequential(new cmdTogglePivot());
        addSequential(new cmdIntakeArmsOpen(.2));
        
  
    	
        requires(Robot.driveSystem);
        requires(Robot.elevator);
        requires(Robot.intake);
       
    }
}
