/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.commands.controls.*;

/**
 * Drivetrain Subsystem
 * Methods:
 * 
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public CANSparkMax left;
  public CANSparkMax right;

  public CANSparkMax leftFollower1;
  public CANSparkMax rightFollower1;

  public CANEncoder leftEncoder;
  public CANEncoder rightEncoder;

  public CANPIDController leftController;
  public CANPIDController rightController;

  public Drivetrain() {
    left = new CANSparkMax(12, MotorType.kBrushless);
    right = new CANSparkMax(13, MotorType.kBrushless);

    leftFollower1 = new CANSparkMax(14, MotorType.kBrushless);
    rightFollower1 = new CANSparkMax(15, MotorType.kBrushless);

    left.restoreFactoryDefaults();
    right.restoreFactoryDefaults();
    leftFollower1.restoreFactoryDefaults();
    rightFollower1.restoreFactoryDefaults();

    leftFollower1.follow(left);
    rightFollower1.follow(right);

    left.setSmartCurrentLimit(60);
    right.setSmartCurrentLimit(60);
    leftFollower1.setSmartCurrentLimit(60);
    rightFollower1.setSmartCurrentLimit(60);

    leftEncoder = left.getEncoder();
      // rightEncoder = left.getEncoder();
    leftController = left.getPIDController();
    leftController.setFeedbackDevice(leftEncoder);
    // rightController = right.getPIDController();
    leftController.setP(5e-6);
    leftController.setI(1e-6);
    leftController.setD(0);
    leftController.setFF(0);
    leftController.setIZone(0);
    leftController.setOutputRange(-0.2, 0.2);
//    rightController.setFeedbackDevice(rightEncoder);
  }

  public void setMotors(double val1, double val2) {
   leftController.setReference(val1*5, ControlType.kVelocity);
    // left.set(val1);
//    right.set(-val2);
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new ControlledMotorGroup(
    //   new ControlledMotor[] {
    //     new ControlledMotorAnalog(left,1),
    //     new ControlledMotorAnalog(right,5),
    //   }, 
    // this));
   setDefaultCommand(new DriveControls());
  }
}