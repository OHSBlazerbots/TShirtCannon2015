package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.DriveAngleAdjusterWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AngleAdjuster extends Subsystem {
 
	//one jaguar is used
	Victor jag;

	
	public AngleAdjuster(int jag1)
	{
		jag = new Victor(jag1);
	 	
	}
	
	//sets jaguar speed to a given speed
	public void setAngleSpeed(double setSpeed)
	{
		jag.set(setSpeed);
	}
	
	//returns the current speed 
	public double getSpeed()
	{
	  return jag.get();	
	}
	
	//moves angle w/ joystick (parameter- which joystick?)
	public void driveWithJoystick(Joystick stick) {
		this.setAngleSpeed(stick.getY() * 1);
	}
	
	//default command is to drive w/ joystick
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveAngleAdjusterWithJoystick());
	}

}
