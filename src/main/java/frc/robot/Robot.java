/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.EncoderType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Drivetrain drivetrain;
  public static Manipulator manipulator;
  public static OI oi;
  CANSparkMax motor1;
  // CANEncoder encoder1;

	protected Robot() {
    super(0.03); //cycle time
    // encoder1 = motor1.getEncoder(EncoderType.kHallSensor,4096);

	}

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    System.out.println("\t"+Utilities.deadzone(0, 0.5));
    System.out.println("\t"+Utilities.deadzone(-0.25, 0.5));
    System.out.println("\t"+Utilities.deadzone(-0.5, 0.5));
    System.out.println("\t"+Utilities.deadzone(-0.75, 0.5));
    System.out.println("\t" + Utilities.deadzone(-1, 0.5));
    System.out.println("\t"+Utilities.deadzone(0, 0.5));
    System.out.println("\t"+Utilities.deadzone(0.25, 0.5));
    System.out.println("\t"+Utilities.deadzone(0.5, 0.5));
    System.out.println("\t"+Utilities.deadzone(0.75, 0.5));
    System.out.println("\t" + Utilities.deadzone(1, 0.5));
    RobotMap.init();

    drivetrain = new Drivetrain();

    manipulator = new Manipulator();

    oi = new OI();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    drivetrain.telemetryPeriodic();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
		Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
		Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
    Scheduler.getInstance().run();
  }
  
  @Override
  public void disabledInit() {
    System.out.println("\t"+Utilities.deadzone(0, 0.5));
    System.out.println("\t"+Utilities.deadzone(0.25, 0.5));
    System.out.println("\t"+Utilities.deadzone(0.5, 0.5));
    System.out.println("\t"+Utilities.deadzone(0.75, 0.5));
    System.out.println("\t"+Utilities.deadzone(1, 0.5));
    
  } 
}
