package org.usfirst.frc4980.PowerUp2018.subsystems;

import org.usfirst.frc4980.PowerUp2018.OI;
import org.usfirst.frc4980.PowerUp2018.Robot;

import edu.wpi.first.networktables.EntryListenerFlags;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Vision extends Subsystem {
	int[] filters;
	int index = 0;
	public NetworkTable visionTable;
    public NetworkTable filterTable;
    double h;
    double s;
    double v;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Vision(NetworkTableInstance tableInstance){
	//visionTable.addEntryListener("VisionResults", OI::VisionResultsChanged, EntryListenerFlags.kUpdate);
		filterTable = tableInstance.getTable("hsvFilter");
		filters = new int[]{0,27,33,25,255,15,255};
		filterTable.getEntry("minH").setNumber(filters[1]);
        filterTable.getEntry("maxH").setNumber(filters[2]);
        filterTable.getEntry("minS").setNumber(filters[3]);
        filterTable.getEntry("maxS").setNumber(filters[4]);
        filterTable.getEntry("minV").setNumber(filters[5]);
        filterTable.getEntry("maxV").setNumber(filters[6]);
        
	        
	}

    public void initDefaultCommand() {
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void incrementFilter(){
//    	filters[index]++;
    	setFilters();
    }
    public void decrementFilter(){
//    	filters[index]--;
    	setFilters();
    }
    public void incrementIndex(){
//    	index = (index+1)%filters.length;
    	setFilters();
    }
    public void setFilters(){
    	filters[1] = (int) SmartDashboard.getNumber("minH", filters[1]);
        filters[2] = (int) SmartDashboard.getNumber("maxH", filters[2]);
        filters[3] = (int) SmartDashboard.getNumber("minS", filters[3]);
        filters[4] = (int) SmartDashboard.getNumber("maxS", filters[4]);
        filters[5] = (int) SmartDashboard.getNumber("minV", filters[5]);
        filters[6] = (int) SmartDashboard.getNumber("maxV", filters[6]);
    	filterTable.getEntry("minH").setNumber(filters[1]);
        filterTable.getEntry("maxH").setNumber(filters[2]);
        filterTable.getEntry("minS").setNumber(filters[3]);
        filterTable.getEntry("maxS").setNumber(filters[4]);
        filterTable.getEntry("minV").setNumber(filters[5]);
        filterTable.getEntry("maxV").setNumber(filters[6]);
        SmartDashboard.putNumber("minH", filters[1]);
        SmartDashboard.putNumber("maxH", filters[2]);
        SmartDashboard.putNumber("minS", filters[3]);
        SmartDashboard.putNumber("maxS", filters[4]);
        SmartDashboard.putNumber("minV", filters[5]);
        SmartDashboard.putNumber("maxV", filters[6]);
        }
}

