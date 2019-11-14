package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class AdvancedDrive extends Command {
    private double speed;
    private double dist;
    private double timeout;
    private double originalDistance;

    public AdvancedDrive(double speed, double dist, double timeout) {
        this.speed = speed;
        this.dist = Math.abs(dist);
        this.timeout = timeout;
        originalDistance = encoder.getPosition();
    }

    protected void execute() {
        currentDistance = encoder.getPosition();
        double distanceTraveled = abs(currentDistance - originalDistance);
        if distanceTraveled >= dist {
            // Stop motors and return
        } else {
            // Continue the motors
        }
    }

    protected boolean isFinished() {
        return true;
    }
}