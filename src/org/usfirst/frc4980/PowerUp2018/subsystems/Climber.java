package org.usfirst.frc4980.PowerUp2018.subsystems;

import org.usfirst.frc4980.PowerUp2018.RobotMap;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {
	private final Talon climberMotor1 = RobotMap.climberMotor1;
	private final Talon climberMotor2 = RobotMap.climberMotor2;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

