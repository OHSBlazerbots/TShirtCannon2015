package org.usfirst.frc.team3807.robot.subsystems;

import org.usfirst.frc.team3807.robot.RobotMap;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Relay.*;

public class Pneumatics extends Subsystem {

	//We are using spike to directly control the solenoids, which are a type of relay
	Relay spikeOne = new Relay(RobotMap.SPIKE1);
	Relay spikeTwo = new Relay(RobotMap.SPIKE2);
	Relay spikeThree = new Relay(RobotMap.SPIKE3);
	
	//Variables to control the While Loops
	int psi = -1;
	int x = 1;
	
	public Pneumatics()
	{
		fill();
		fireCannon();
	}
	
	public void fill() {
				//turn on SPIKE1
				spikeOne.set(Value.kForward);//kForward value should be checked by trained professional
				while (x == 1) { 			 //wait until filled to 120 PSI
					if (psi < 120) {
						x = -1;
					}
				}
				spikeOne.set(Value.kReverse);//kReverse value should be checked by trained professional
	}
	public void spike23(Value v) {
		spikeTwo.set(v);
		spikeThree.set(v);
	}
	
	public void fireCannon() {
		
		if (spikeOne.get() == Value.kOff) { //Make sure that SPIKE1 is off while SPIKE2 and SPIKE3 are open and vice versa
		
			spike23(Value.kForward);
		}
			//turn on SPIKE2 and SPIKE3
		//wait until secondary tanks are emptied
		//turn off SPIKE2
		//turn off SPIKE3
		
	}
	
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

}
