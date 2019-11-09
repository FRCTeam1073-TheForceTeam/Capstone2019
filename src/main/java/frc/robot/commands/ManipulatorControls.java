/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;
import frc.robot.*;

public class ManipulatorControls extends Command {
  public ManipulatorControls() {
    requires(Robot.manipulator);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // Robot.manipulator.leftCollector.set(Robot.oi.getOpAxis(1)*0.1);
    if (Robot.oi.driverControl.a.get()) {
      Robot.manipulator.openClaw();
    } else {
      Robot.manipulator.closeClaw();
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
