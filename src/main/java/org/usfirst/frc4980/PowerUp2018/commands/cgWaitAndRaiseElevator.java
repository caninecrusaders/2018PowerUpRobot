package org.usfirst.frc4980.PowerUp2018.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cgWaitAndRaiseElevator extends CommandGroup {

    public cgWaitAndRaiseElevator() {
    	
    	 addSequential(new cmdWait(1.0));
    	 addSequential(new cmdElevatorUp(2.9, 1.0));
    }
}
