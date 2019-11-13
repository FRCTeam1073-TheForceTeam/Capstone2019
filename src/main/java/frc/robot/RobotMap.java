package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  public static ADXRS450_Gyro gyro;

	public static void init() {
    gyro.calibrate();
    gyro.reset();
    System.out.println("[Success] Gyro calibrated at " + gyro.getAngle());
  }
  public static void telemetryGyro(){

    // creates Dashboard-Widgets for the gyro angle and the rotation
    SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    SmartDashboard.putNumber("Gyro Rotation", gyro.getRate());

  }
}