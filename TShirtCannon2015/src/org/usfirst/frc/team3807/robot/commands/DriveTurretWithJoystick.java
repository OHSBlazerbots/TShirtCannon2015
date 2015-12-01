package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.subsystems.Turret;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriveTurretWithJoystick extends CommandBase {

	JoystickButton button;
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
	     requires(turret);
	     button = new JoystickButton(oi.getCoDriverJoystick(), 1);

	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (!button.get()) {
			turret.driveWithJoystick(oi.getCoDriverJoystick());
		} else {
			turret.setTurretSpeed(0);
		}

	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		turret.setTurretSpeed(0);

	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		turret.setTurretSpeed(0);

	}

}
