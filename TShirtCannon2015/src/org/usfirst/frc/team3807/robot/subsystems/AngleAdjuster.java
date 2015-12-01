package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.DriveAngleAdjusterWithJoystick;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class AngleAdjuster extends Subsystem {
 
	Victor jag;

	
	public AngleAdjuster(int jag1)
	{
		jag = new Victor(jag1);
	 	
	}
	
	public void setAngleSpeed(double setSpeed)
	{
		jag.set(setSpeed);
	}
	
	public double getSpeed()
	{
	  return jag.get();	
	}
	
	
	
	public void driveWithJoystick(Joystick stick) {
		this.setAngleSpeed(stick.getY() * 1);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveAngleAdjusterWithJoystick());
	}

}
