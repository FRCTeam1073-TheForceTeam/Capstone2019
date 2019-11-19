package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.*;
import java.lang.Math;

public class AdvancedDrive extends Command {
    private double speed;
    private double dist;
    private double timeout;
    private double originalDistance;
    private Drivetrain m_drive;
    private double currentDistance;
    private double dist;

    public AdvancedDrive(double speed, double dist, double timeout, Drivetrain drive) {
        this.speed = speed;
        this.dist = Math.abs(dist);
        this.timeout = timeout;
        m_drive = drive;
        originalDistance = drive.getPosition();
    }

    protected void execute() {
        currentDistance = m_drive.getPosition();
        double distanceTraveled = Math.abs(currentDistance - originalDistance);
        if (distanceTraveled >= dist) {
            // Stop motors and return
        } else {
            // Continue the motors
        }
    }

    protected boolean isFinished() {
        return true;
    }
}