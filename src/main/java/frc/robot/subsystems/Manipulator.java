/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;

// import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
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
  // public Solenoid leftWrist = new Solenoid(1, 6);
  public WPI_VictorSPX leftCollector = new WPI_VictorSPX(22);
  public WPI_VictorSPX rightCollector = new WPI_VictorSPX(23);

  public Manipulator() {
    leftCollector.configFactoryDefault();
    leftCollector.setNeutralMode(NeutralMode.Brake);
    rightCollector.configFactoryDefault();
    rightCollector.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new ManipulatorControls());
    // setDefaultCommand(new ControlledMotorGroup(
    //                     new ControlledMotor[]{

    //                     },
    //                     Robot.oi.operatorCancel,
    //                     this));
  }
  public void set(double val){
    rightCollector.set(-Utilities.powerRamp(Utilities.deadzone(val,0.05)));
    leftCollector.set(Utilities.powerRamp(Utilities.deadzone(val,0.05)));
  }
}
