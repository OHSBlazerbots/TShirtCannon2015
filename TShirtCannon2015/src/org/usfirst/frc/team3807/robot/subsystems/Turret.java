package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.commands.DriveTurretWithJoystick;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Turret extends Subsystem {

	//turret system uses one jaguar
	Jaguar jag;
	
	public Turret(int jag1){
		jag = new Jaguar(jag1);
	}
	
	//sets turret speed to a given speed
	public void setTurretSpeed(double setSpeed) {
		jag.set(setSpeed);
	}
	
	//return the speed 
	public double getSpeed(){
		return jag.get();
	}
	
	//drives turret w/ joystick
	public void driveWithJoystick(Joystick stick) {
		this.setTurretSpeed(stick.getZ() * 1);
	}
	
	
	//sets default command to drive w/ joystick
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new DriveTurretWithJoystick());
	}

}
