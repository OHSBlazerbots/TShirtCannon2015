package org.usfirst.frc.team3807.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Turret extends Subsystem {

	Victor jag;
	
	public Turret(int jag1){
		jag = new Victor (jag1);
	}
	
	public void setTurretSpeed(double setSpeed) {
		jag.set(setSpeed);
	}
	
	public double getSpeed(){
		return jag.get();
	}
	
	public void driveWithJoystick(Joystick stick) {
		this.setTurretSpeed(stick.getZ() * 1);
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
