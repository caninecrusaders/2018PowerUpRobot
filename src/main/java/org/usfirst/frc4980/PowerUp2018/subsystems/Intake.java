package org.usfirst.frc4980.PowerUp2018.subsystems;

import org.usfirst.frc4980.PowerUp2018.Robot;
import org.usfirst.frc4980.PowerUp2018.RobotMap;
import org.usfirst.frc4980.PowerUp2018.commands.cmdIntakeSpeedXbox;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */ /*intakeState 0 = none
	  intakeState 1 = open
	  intakeState 2 = closed
	  intakeState 3 = captured
	  intakeState 4 = pivoted
	  intakeState 5 = released
	*/
public class Intake extends Subsystem {
	private final WPI_TalonSRX intakeMotor1 = RobotMap.intakeMotor1;
	private final WPI_TalonSRX intakeMotor2 = RobotMap.intakeMotor2;
	private final DoubleSolenoid armSolenoidLeft = RobotMap.armSolenoidLeft;
	private final DoubleSolenoid armSolenoidRight = RobotMap.armSolenoidRight;
	private final DoubleSolenoid cubeArmPivot = RobotMap.cubeArmPivot;
	private final AnalogInput cubeDistance = RobotMap.cubeDistance;
	public boolean isArmsOpen = false;
	private boolean isLeftArmOpen = false;
	private boolean isRightArmOpen = false;
	private boolean isPivotedUp = true;
	double deadZone = 0.15;
	double duration = 0.0;
	public  int intakeState = 0;
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new cmdIntakeSpeedXbox());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void setSpeed(double speed){
    	intakeMotor1.set(speed);
    	intakeMotor2.set(speed);
    	
    }
    public void setSpeedXbox(){
    	double speed =  Robot.oi.xboxDriver2.getRawAxis(1);
    	double deadZone = 0.15;
    	double speedAdjustment = 1.0 - deadZone;
    	if(Math.abs(speed)< deadZone){
    		speed = 0.0;
    		setSpeed(speed);
    		return;
    	}
    	speed = (speed-(Math.abs(speed)/speed*deadZone)/speedAdjustment);
    	if(speed>0.5){
    		speed = 0.5;
    	}
//    	if(speed > 0) {
//    		double speedAdjustment = 0.8 - deadZone;
//    		speed = speedAdjustment * speed;
//    	} else {
//    		double speedAdjustment = 1.0 - deadZone;
//    		speed = speedAdjustment * speed;
//    	}
    	setSpeed(speed);
    	
    }
    public void stop(){
    	intakeMotor1.set(0);
    	intakeMotor2.set(0);
    }
    public void openArms (){
    	armSolenoidLeft.set(DoubleSolenoid.Value.kReverse);
    	armSolenoidRight.set(DoubleSolenoid.Value.kReverse);
    	isArmsOpen = true;
    	intakeState = 5;
    }
    public void closeArms(){
    	armSolenoidLeft.set(DoubleSolenoid.Value.kForward);
    	armSolenoidRight.set(DoubleSolenoid.Value.kForward);
    	isArmsOpen = false;
    }
    public void toggleArms(){
    	if(isArmsOpen){
    		closeArms();
    	} else {
    		openArms();
    	}
    	
    }
    public void toggleLeft(){
    	isLeftArmOpen = !isLeftArmOpen;
    	if(isLeftArmOpen){
    		armSolenoidLeft.set(DoubleSolenoid.Value.kReverse);
    	}else {
    		armSolenoidLeft.set(DoubleSolenoid.Value.kForward);
    	}
  
    	
    }
    public void toggleRight(){
    	isRightArmOpen = !isRightArmOpen;
    	if(isRightArmOpen){
    		armSolenoidRight.set(DoubleSolenoid.Value.kReverse);
    	}else {
    		armSolenoidRight.set(DoubleSolenoid.Value.kForward);
    	}
  
    }
    public void armsOff(){
    	armSolenoidLeft.set(DoubleSolenoid.Value.kOff);
    	armSolenoidRight.set(DoubleSolenoid.Value.kOff);
    }
    public void pivotUp(){
    	cubeArmPivot.set(DoubleSolenoid.Value.kForward);
    	isPivotedUp = true;
    }
    public void pivotDown(){
    	cubeArmPivot.set(DoubleSolenoid.Value.kReverse);
    	isPivotedUp = false;
    	intakeState = 0;
    }
    public void togglePivot(){
    	if(isPivotedUp){
    		pivotDown();
    	} else {
        	Robot.elevator.release();
    		pivotUp();
    	}
    }
    public void shakeLeft(){
    	double speed = Robot.oi.xboxDriver2.getRawAxis(1);
    	if(speed< 0.5){
    		speed = 0.5;
    	}
    	if(Math.abs(speed)< deadZone){
    		speed = 0.0;
    	}
    	setSpeed(speed);
    	intakeMotor1.set(-speed);
    	intakeMotor2.set(speed);
    }
    public void shakeRight(){
    	double speed = Robot.oi.xboxDriver2.getRawAxis(1);
    	if(speed<0.5){
    		speed = 0.5;
    	}
    	if(Math.abs(speed)< deadZone){
    		speed = 0.0;
    	}
    	setSpeed(speed);
    	intakeMotor1.set(speed);
    	intakeMotor2.set(-speed);
    }
    public void automateCubeIntake(){
    	duration--;
    	double speed = Robot.oi.xboxDriver2.getRawAxis(1);
    	double deadZone = 0.15;
    	if(Math.abs(speed)< deadZone){
    		speed = 0.0;
    	}
    	if(intakeState == 5){
    		//released open arms
    		openArms();
    		intakeState = 0;
    		return;
    	}
    	if(isPivotedUp || intakeState == 3){
    		//arms up no wheels no action until someone releases
    		setSpeed(0.0);
      		return;
    	}
    	if(intakeState == 2){
    		if(cubeDistance.getVoltage() > 1.6 ) {
    			//cube aquired 
        		setSpeed(0.0);
        		closeArms();
        		//intakeState = 3;//captured
        		pivotUp();
        		if(duration < 0){
        			intakeState = 3;
        			duration = 5;//transition to pivoted
        		}
    		}
    		return;
    	}
    	if(intakeState == 1){
    		if(cubeDistance.getVoltage() > 0.7 && duration < 0){
    			// close arms
    			setSpeed(1.0);
        		closeArms();
        		intakeState = 2;//closed
        		duration = 20;
    		}
    		
    		return;
    	}
    	if(cubeDistance.getVoltage() > 0.2 && intakeState == 0){
    		openArms();
    		intakeState = 1;//open
    		setSpeed(-1.0);
    		duration = 25;
    		return;
    	}
    	setSpeed(speed);
    	intakeState = 0;//none
    	duration = 0;
    	
    	
    }
}

