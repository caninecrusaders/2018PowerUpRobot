// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4980.PowerUp2018;

import org.usfirst.frc4980.PowerUp2018.commands.*;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTableValue;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton buttonA;
    public Joystick xboxController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton leftBumper;
    public JoystickButton rightBumper;
    public JoystickButton back;
    
	private NetworkTableInstance tableInstance;
    public NetworkTable visionTable;

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xboxController = new Joystick(0);
        
        buttonA = new JoystickButton(xboxController, 1);
        buttonA.whileHeld(new cmdDriveXbox());

        // SmartDashboard Buttons
        //SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("drive", new cmdDriveXbox());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        leftBumper = new JoystickButton(xboxController, 5);
        leftBumper.whileHeld(new cmdDriveSearchLeft());

        rightBumper = new JoystickButton(xboxController, 6);
        rightBumper.whileHeld(new cmdDriveSearchRight());

        back = new JoystickButton(xboxController, 7);
        back.whenPressed(new toggleInvert());
        
    	tableInstance = NetworkTableInstance.getDefault();
    	tableInstance.startClient("10.49.82.86", 1735);
        visionTable = tableInstance.getTable("CVResultsTable");
        visionTable.addEntryListener("VisionResults", OI::VisionResultsChanged, EntryListenerFlags.kUpdate);
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getxboxController() {
        return xboxController;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    
    public static void VisionResultsChanged(NetworkTable table, String key, NetworkTableEntry entry, NetworkTableValue value, int flags) {
    	String[] values = value.getString().split(",");
    	if (Integer.decode(values[1]) == 0) { cubeCoords.valid = false; return; }
    	
    	cubeCoords.valid = true;
    	cubeCoords.midpoint_x = Integer.decode(values[2]);
    	cubeCoords.midpoint_y = Integer.decode(values[3]);
    	cubeCoords.horizontalAngle = Double.parseDouble(values[16]);
   
    }
    public static class cubeCoords{
    	public static boolean valid = false;
    	public static int midpoint_x;
    	public static int midpoint_y;
    	public static double horizontalAngle;
    }
}

