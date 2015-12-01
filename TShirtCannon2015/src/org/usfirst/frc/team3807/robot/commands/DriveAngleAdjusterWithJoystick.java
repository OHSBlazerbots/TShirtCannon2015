package org.usfirst.frc.team3807.robot.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriveAngleAdjusterWithJoystick extends CommandBase {
     JoystickButton button;
	
     @Override
	protected void initialize() {
		// TODO Auto-generated method stub
     requires(angleAdjuster);
     button = new JoystickButton(oi.getCoDriverJoystick(), 1);
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		if (!button.get()) {
			angleAdjuster.driveWithJoystick(oi.getCoDriverJoystick());
		} else {
			angleAdjuster.setAngleSpeed(0);
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
		angleAdjuster.setAngleSpeed(0);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		angleAdjuster.setAngleSpeed(0);
	}

}
