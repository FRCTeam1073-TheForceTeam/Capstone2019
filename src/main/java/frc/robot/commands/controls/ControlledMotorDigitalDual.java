/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.controls;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.Robot;
import frc.robot.Utilities;
import frc.robot.XboxController;

/**
 * @author Ben
 * Like ControlledMotorDigital, except with two buttons.
 */
public class ControlledMotorDigitalDual extends ControlledMotor {
    private CANSparkMax motor;
    private XboxController controller;
    private JoystickButton button;
    private JoystickButton button2;
    private double valueOff = 0;
    private double valueOn = 0.5;
    private double valueOn2 = -0.5;

    /**
     * @param motor_ The CANSparkMax to be controlled.
     * @param button_ The axis on the selected controller to be mapped to motor output.
     */
    public ControlledMotorDigitalDual(CANSparkMax motor_, XboxController controller_, JoystickButton button_,
            JoystickButton button2_) {
        this(motor_, controller_, button_, button2_, 0.0, 1.0, -1.0);
    }

    public ControlledMotorDigitalDual(CANSparkMax motor_, XboxController controller_, JoystickButton button_,
            JoystickButton button2_, double amt) {
        this(motor_, controller_, button_, button2_, 0.0, amt, -amt);
    }
    

    /**
     * @param motor_ The CANSparkMax to be controlled.
     * @param button_ The axis on the selected controller to be mapped to motor output.
     * @param off The motor value when the button is not pressed.
     * @param on The motor value when the button is pressed.
     */
    public ControlledMotorDigitalDual(CANSparkMax motor_, XboxController controller_, JoystickButton button_, JoystickButton button2_, double off, double on,double on2) {
        motor = motor_;
        controller = controller_;
        button = button_;
        button2 = button2_;
        valueOff = off;
        valueOn = on;
        valueOn2 = on2;
    }

    public void init() {
        motor.set(0);
    }

    public void execute() {
        if (button.get()) {
            motor.set(valueOn);
        } else if (button2.get()) {
            motor.set(valueOn2);
        } else {
            motor.set(valueOff);
        }
    }

}
