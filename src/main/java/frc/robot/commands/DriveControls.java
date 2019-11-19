/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.Utilities;
import frc.robot.subsystems.*;

public class DriveControls extends Command {

  public DriveControls() {
    requires(Robot.drivetrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    var forward = Utilities.deadzone(Robot.oi.driverControl.getRawAxis(1),0.075);
    var rotate = Utilities.deadzone(Robot.oi.driverControl.getRawAxis(4), 0.075);
    forward = Utilities.powerRamp(forward);
    rotate = Utilities.powerRamp(rotate);
    Robot.drivetrain.setMotorsPID((forward - rotate), (forward + rotate));
    System.out.println("Velocity:" + Robot.drivetrain.leftEncoder.getVelocity());
    // System.out.println("Encoder: "+Robot.drivetrain.leftEncoder.getPosition());
    // System.out.print("Left: temp"+Robot.drivetrain.left.getMotorTemperature()+", current "+Robot.drivetrain.left.getOutputCurrent()+"; ");
    // System.out.println("Right: temp"+Robot.drivetrain.right.getMotorTemperature()+", current "+Robot.drivetrain.right.getOutputCurrent());
    // System.out.print("Left follower: temp"+Robot.drivetrain.leftFollower1.getMotorTemperature()+", current "+Robot.drivetrain.leftFollower1.getOutputCurrent()+"; ");
    // System.out.println("Right follower: temp"+Robot.drivetrain.rightFollower1.getMotorTemperature()+", current "+Robot.drivetrain.rightFollower1.getOutputCurrent());
    // System.out.println("\t|||\t" + Robot.drivetrain.left.get());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }
}
