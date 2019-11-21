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
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.*;
import frc.robot.commands.*;
import frc.robot.commands.controls.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Drivetrain Subsystemvf
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

    left.setSmartCurrentLimit(50);
    right.setSmartCurrentLimit(50);
    leftFollower1.setSmartCurrentLimit(50);
    rightFollower1.setSmartCurrentLimit(50);

    left.setIdleMode(IdleMode.kBrake);
    right.setIdleMode(IdleMode.kBrake);
    leftFollower1.setIdleMode(IdleMode.kBrake);
    rightFollower1.setIdleMode(IdleMode.kBrake);

    leftEncoder = left.getEncoder();
    rightEncoder = right.getEncoder();
    leftController = left.getPIDController();
    leftController.setFeedbackDevice(leftEncoder);
    double P = 2e-4, I = 1.5e-6, D = 0;
    leftController.setP(P);
    leftController.setI(I);
    leftController.setD(D);
    leftController.setFF(0);
    leftController.setIZone(0);
    leftController.setOutputRange(-0.9, 0.9);

    rightController = right.getPIDController();
    rightController.setFeedbackDevice(rightEncoder);
    rightController.setP(P);
    rightController.setI(I);
    rightController.setD(D);
    rightController.setFF(0);
    rightController.setIZone(0);
    rightController.setOutputRange(-0.9, 0.9);

    //    rightController.setFeedbackDevice(rightEncoder);
  }

  public void setMotors(double val1, double val2) {
    leftController.setReference(val1, ControlType.kDutyCycle);
    rightController.setReference(-val2, ControlType.kDutyCycle);
  }


  public void setMotorsPID(double val1, double val2) {
    // left.set(val1*0.5);
    // right.set(-val2*0.5);
      // leftController.setReference(val1 * 0.1, ControlType.kDutyCycle);
      // rightController.setReference(-val2 * 0.1, ControlType.kDutyCycle);
    leftController.setReference(val1 * 3500, ControlType.kVelocity);
    rightController.setReference(-val2 * 3500, ControlType.kVelocity);
    System.out.println("target:" + val1 * 3500 + ", actual:" + leftEncoder.getVelocity());
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
  public void telemetryPeriodic() {

    // Creates Dashboard-Widget for Positions of Encoders
    SmartDashboard.putNumber("Left Encoder Position", leftEncoder.getPosition());
    SmartDashboard.putNumber("Right Encoder Position", rightEncoder.getPosition());
   
    // Creates Dashboard-Widget for Velocities of Encoders
    SmartDashboard.putNumber("Left Encoder Velocity", leftEncoder.getVelocity());
    SmartDashboard.putNumber("Right Encoder Velocity", rightEncoder.getVelocity());

    // Creates Dashboard-Widget for Temperatures of the Motors
    SmartDashboard.putNumber("Left Leader Temperature", left.getMotorTemperature());
    SmartDashboard.putNumber("Left Follower Temperature", leftFollower1.getMotorTemperature());
    SmartDashboard.putNumber("Right Leader Temperature", right.getMotorTemperature());
    SmartDashboard.putNumber("Right Follower Temperature", rightFollower1.getMotorTemperature());
    
    // Creates Dashboard-Widget for Output-Currents of the Motors
    SmartDashboard.putNumber("Left Leader Current", left.getMotorTemperature());
    SmartDashboard.putNumber("Left Follower Current", leftFollower1.getMotorTemperature());
    SmartDashboard.putNumber("Right Leader Current", right.getMotorTemperature());
    SmartDashboard.putNumber("Right Follower Current", rightFollower1.getMotorTemperature());
  }
}