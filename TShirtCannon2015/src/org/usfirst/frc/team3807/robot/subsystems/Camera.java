/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.RobotValues;
import org.usfirst.frc.team3807.robot.commands.DriveCamWithJoystick;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.vision.AxisCamera;

/**
 *
 * @author blazerbots
 */
public class Camera extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	Servo tilt;
	Servo pan;
	private static AxisCamera cam;

	public Camera(int pan_port1, int tilt_port1) {
		// CameraServer server = CameraServer.getInstance();
		// server.startAutomaticCapture("cam1");
		
		//if there is an assigned port, set it to the corresponding Servo motor 
		if (tilt_port1 != -1) {
			tilt = new Servo(tilt_port1);
		}
		if (pan_port1 != -1) {
			pan = new Servo(pan_port1);
		}
		
		//if the servo motors exist, then set it to initial postion
		if (tilt != null)
			tilt.setAngle(150);
		if (pan != null)
			pan.setAngle(105);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveCamWithJoystick());
	}

	public void snapShot() {
		try {
			cam.getImage().write("/tmp/snapShot.jpg");
		} catch (NIVisionException ex) {
			ex.printStackTrace();
		}
	}

	//control camera1 with the joystick
	public void driveCam1WithJoyStick(Joystick joy) {
		// System.out.print("Driving Cam...");
		
		//the x value of the joystick controls pan (left and right); the y value controls tilt (up and down)
		double x = RobotValues.PAN_CONSTANT * joy.getX();
		double y = RobotValues.TILT_CONSTANT * joy.getY();
		// System.out.println(" X: " + x + " Y: " + y);
		// System.out.println(RobotValues.PAN_CONSTANT);
		// System.out.println("DWJ: (" + x + "," + y + ")");
		try {
			pan.setAngle(pan.getAngle() + x);
			tilt.setAngle(tilt.getAngle() + y);
		} catch (NullPointerException e) {

		}
	}
	
}
