/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3807.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;

/**
 * Deals with network assets.
 * @author sgoldman
 */
public class Network extends Subsystem{

    // Holds a reference to the SmartDashboard, where we get info from
    private NetworkTable server;
    
    /**
     * Creates the Network subsystem
     * Initializes private reference to SmartDashboard
     */
    public Network() {
        server = NetworkTable.getTable("RoboRealm");
    }
    
    /**
     * Default method for 
     */
    
    protected void initDefaultCommand() {
        // Starts the robot with the following non-terminating command
        //setDefaultCommand(new GetDistance());
    }
    
    /**
     * Returns a type double variable from RoboRealm 
     * 
     * @param s
     * @return double
     */
    public double getNetworkVariable(String s) {
        try {
            //Get number
            return server.getNumber(s, -1);
            
        }
        catch (TableKeyNotDefinedException exp){
        	server.putNumber(s, -42);
            return 0;
        }
    }
}
