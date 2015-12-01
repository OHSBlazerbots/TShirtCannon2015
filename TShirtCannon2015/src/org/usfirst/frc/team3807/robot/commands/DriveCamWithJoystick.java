package org.usfirst.frc.team3807.robot.commands;

import org.usfirst.frc.team3807.robot.OI;

import edu.wpi.first.wpilibj.Joystick.ButtonType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveCamWithJoystick extends CommandBase {
	
    public DriveCamWithJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(camera);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    		camera.driveCam1WithJoyStick(oi.getCoDriverJoystick2());
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
