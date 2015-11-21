package org.usfirst.frc.team1806.robot.commands.canSequenceCommands;

import org.usfirst.frc.team1806.robot.Constants;
import org.usfirst.frc.team1806.robot.Robot;
import org.usfirst.frc.team1806.robot.States;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PickupCan extends Command {
	
    public PickupCan() {
        requires(Robot.lift);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.lift.closeArms();
    	Robot.lift.moveUp();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if(Robot.lift.getLiftEncoder() > Constants.highCanHoldHeight){
    		Robot.lift.stop();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.statesObj.canSequenceStateTracker == States.canSequenceState.MOVETONEXT);
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    	Robot.lift.zeroPower();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.lift.zeroPower();
    }
}
