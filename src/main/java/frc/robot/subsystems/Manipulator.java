/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.commands.controls.*;

/**
 * Manipulator Subsystem
 * Methods:
 * 
 */
public class Manipulator extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public Manipulator() {

  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new ControlledMotorGroup(
    //                     new ControlledMotor[]{

    //                     },
    //                     Robot.oi.operatorCancel,
    //                     this));
  }
}
