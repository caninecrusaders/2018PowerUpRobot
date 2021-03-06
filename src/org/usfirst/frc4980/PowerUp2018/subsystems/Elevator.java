package org.usfirst.frc4980.PowerUp2018.subsystems;

import org.usfirst.frc4980.PowerUp2018.Robot;
import org.usfirst.frc4980.PowerUp2018.RobotMap;
import org.usfirst.frc4980.PowerUp2018.commands.cmdElevatorStop;
import org.usfirst.frc4980.PowerUp2018.commands.cmdElevatorXbox;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends Subsystem {
	private final WPI_TalonSRX elevatorMotor = RobotMap.elevatorMotor;
	private final WPI_TalonSRX elevatorMotor2 = RobotMap.ElevatorMotor2;
	private final DoubleSolenoid elevatorDepositSolenoid = RobotMap.elevatorDepositSolenoid;
	private final AnalogInput pot = RobotMap.pot;
	private boolean isExtended = false;
	private boolean isHeld = false;
	private final DoubleSolenoid elevatorHolder = RobotMap.elevatorHolder;
	//private final double elevatorMax;
	//private final double elevatorMin;
	double deadZone = 0.15;
	//PIDController elevatorPID;
	//PIDController elevatorPID2;
	static final double kP = 2.0;
	static final double kI = 0.00;
	static final double kD = 0.00;
    static final double kF = 0.00;
    static final double kTolerance = 0.1;
    public static final double maxHeight = 2.9; //3.85; //2.2
    public static final double minHeight = 1.09; //2.2; //0.6
    private double moveToHeight = -1;
    
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
//    public Elevator(){
//    	super("Elevator", kP,kI,kD);
//    	////setAbsoluteTolerance(kTolerance);
//    	getPIDController().setContinuous(false);
//    	getPIDController().setEnabled(false);
//    }
//    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new cmdElevatorXbox());
    }
    public void elevatorXbox(){
    	double down = Robot.oi.xboxDriver2.getRawAxis(2);
    	double up =  Robot.oi.xboxDriver2.getRawAxis(3);
    	double speed = 0.0;
    	
//    	if(getPIDController().isEnabled() && getPIDController().onTarget()){
//    	    //FINISHED
//    	    //////getPIDController().reset();
//    	   // getPIDController().setEnabled(false);
//    	    moveToHeight = -1;
//    	    SmartDashboard.putString("ElevatorStatus", "Finished");
//    	}
//    	SmartDashboard.putNumber("POV", Robot.oi.xboxDriver2.getPOV());
//    	if(Robot.oi.xboxDriver2.getPOV() >= 0){
//    	    if(Robot.oi.xboxDriver2.getPOV() >= 315 || Robot.oi.xboxDriver2.getPOV() <= 45){
//    	        //UP
//    	        // 48in (4ft)  Low - 56in (4ft 8in) Balance - 72in (6ft) High
//    	        moveToHeight = 20;//60; //4 inches above Balance
//    	    }else if(Robot.oi.xboxDriver2.getPOV() > 45 &&  Robot.oi.xboxDriver2.getPOV() <= 135){
//    	        //RIGHT
//    	        moveToHeight = 30;//75;//4 inches above High
//    	    }else if(Robot.oi.xboxDriver2.getPOV() > 135 && Robot.oi.xboxDriver2.getPOV() <= 225){
//    	        //DOWN
//    	        moveToHeight = 1;//inch?
//    	    }else if(Robot.oi.xboxDriver2.getPOV() > 225 || Robot.oi.xboxDriver2.getPOV() < 315){
//    	        //LEFT
//    	        // climbing height bar at 80.5 in.
//    	        moveToHeight = 10;//52;//4 inches above Low.
//    	    }
//    	}
//
//    	if(moveToHeight > 0){
//    	    //Enable the controller and start moving the elevator to proper height.
//    	    //controller.reset();//Do we need to reset in case of changing set point while elevator is moving?
//    		//getPIDController().setEnabled(true);
//    		//double targetPot = getPotValueForElevatorHeight(moveToHeight);//Inch conversion
//    		//getPIDController().setSetpoint(targetPot);
//    	    SmartDashboard.putString("ElevatorStatus", "Running");
//    	   // SmartDashboard.putNumber("elevator set point", targetPot);
//    	    return;//Do not run the elevator motors below allow the PID controller to supply the values to the elevator.
//    	}
    	
    	
    	if(Math.abs(down)<deadZone){
      		 down = 0.0;
      	    }
    	if(Math.abs(up)<deadZone){
    		up = 0.0;
    	}
    	if(up > 0.0){
    		elevatorUp(up);
    	}else if (down > 0.0){
        	elevatorDown(down);
    	}else{
    		stop();
    	}
    }
    public void elevatorUp(double speed){
    	double current = pot.getVoltage();
    	speed = Math.abs(speed);
    	if(current < maxHeight){
    		if(current < 1.3 && Robot.intake.intakeState == 4){
    			Robot.intake.intakeState = 5;//release
    		}
    	elevatorMotor.set(speed);
        elevatorMotor2.set(speed);
        hold();
        if(Robot.intake.isArmsOpen){
        	Robot.intake.openArms();
        }
     }else{
    	 stop();
     }
    }
    public void elevatorDown(double speed){
    	double current = pot.getVoltage();
    	speed = Math.abs(speed);
    	if(current > minHeight){
    	elevatorMotor.set(-speed);
        elevatorMotor2.set(-speed);
//        if(Robot.intake.isArmsOpen){
//        Robot.intake.closeArms();
//       }
//        Robot.intake.pivotDown();
     }else{
    	 stop();
     }
    }
    public void elevatorSetHeight(double heightCM){
    	//not implemented
    	
    }
    public void stop(){
    	elevatorMotor.set(0);
        elevatorMotor2.set(0);
    }
    public void extend(){
    	elevatorDepositSolenoid.set(DoubleSolenoid.Value.kForward);
    	isExtended = true;
    	elevatorHolder.set(DoubleSolenoid.Value.kReverse);

    }
    public void retract(){
    	elevatorDepositSolenoid.set(DoubleSolenoid.Value.kReverse);
    	isExtended = false;
    }
    public void hold(){
    	elevatorHolder.set(DoubleSolenoid.Value.kForward);
    	isHeld = true;
    }
    public void release(){
    	elevatorHolder.set(DoubleSolenoid.Value.kReverse);
    	isHeld = false;
    }
    public void toggleHold(){
    	if(isHeld){
    		release();
    	}else{
    		hold();
    	}
    }
    public void toggleDeposit(){
    	if(isExtended){
    		retract();
    	}else {
    		extend();
    	}
    }
    public void elevatorPotCount(){
    	
    }
   // public void setUpPIDController(){
   // 	elevatorPID = new PIDController(kP, kI, kD, kF, pot, elevatorMotor);
   // 	//elevatorPID.setInputRange(minHeight,  maxHeight);
   // 	elevatorPID.setOutputRange(-0.5, 0.5);
   // 	elevatorPID.setAbsoluteTolerance(kTolerance);
   // 	elevatorPID.setContinuous(false);
    	
    	
//    	elevatorPID2 = new PIDController(kP, kI, kD, kF, pot, elevatorMotor2);
//    	//elevatorPID.setInputRange(minHeight,  maxHeight);
//    	elevatorPID2.setOutputRange(-0.5, 0.5);
//    	elevatorPID2.setAbsoluteTolerance(kTolerance);
//    	elevatorPID2.setContinuous(false);
    //}
    public void enablePIDController(){
    	//getPIDController().enable();
    }
    public void disablePID(){
    	////getPIDController().disable();
    }
    
    public double getPotValueForElevatorHeight(double inches){
    	double potValue = 0.021335*inches + 1.85285;
    	return potValue;
    }
    
    public void setElevatorHeight(double inches){
    	double potValue = getPotValueForElevatorHeight(inches);
    	// x = pot y = inches
    	// Linear equation y = 45.7914 * inches - 15.3094
    	// X = 0.021838 * Y + 0.334329
    	if(potValue < maxHeight && potValue > minHeight){
    		//Set the set point to move the elevator to.
    		//getPIDController().setSetpoint(potValue);
    		SmartDashboard.putNumber("elevator set point", potValue);
        }else {
        	//Cancel setting it
        	////getPIDController().reset();
     	   // getPIDController().setEnabled(false);
     	    moveToHeight = -1;
     	    SmartDashboard.putString("ElevatorStatus", "Finished");
        }
    }
    
    public void usePIDOutput(double output) {
//		// TODO Auto-generated method stub
//    	SmartDashboard.putNumber("elevator PIDOutput", output);
//	    
//		if(pot.getAverageVoltage() > maxHeight || pot.getAverageVoltage() < minHeight || getPIDController().onTarget()){
//			//We are either outside the safe range or on target.
//			SmartDashboard.putString("Elevator Motor", "stopped");
//			elevatorMotor.set(0.0);
//			elevatorMotor2.set(0.0);
//			getPIDController().reset();
//     	    getPIDController().setEnabled(false);
//     	    moveToHeight = -1;
//     	    SmartDashboard.putString("ElevatorStatus", "Finished");
//			return;
//		}
//		SmartDashboard.putString("Elevator Motor", "running");
//		elevatorMotor.pidWrite(output); 
//		elevatorMotor2.pidWrite(output);
//		SmartDashboard.putNumber("elevator pid output", output);
	}
	public boolean pidOnTarget(){
		return true;
		//return getPIDController().onTarget();
	}
	protected double returnPIDInput() {
		//Lets us know where our elevator is.
//		if(Robot.elevator != null && Robot.elevator.pot != null){
//			return Robot.elevator.pot.getAverageVoltage();
//		} 
		return 0;
		
	}
	
}
