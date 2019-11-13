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
  
  /** If you are using multiple modules, make sure to define both the port
  * number and the module. For example you with a rangefinder:
  * public static int rangefinderPort = 1;
  * public static int rangefinderModule = 1;
  */
  
  // Setting motor IDs
  /* private static final int LeftFirstDeviceID = 12;
  private static final int LeftSecondDeviceID = 14;
  private static final int LeftThirdDeviceID = 16;

  private static final int RightFirstDeviceID = 13;
  private static final int RightSecondDeviceID = 15;
  private static final int RightThirdDeviceID = 17; */

  // Initializing the objects for the motors :)
  // private static CANSparkMax m_LeftFirstMotor = new CANSparkMax(LeftFirstDeviceID, MotorType.kBrushless);
  // private static CANSparkMax m_LeftSecondMotor = new CANSparkMax(LeftSecondDeviceID, MotorType.kBrushless);
  // private static CANSparkMax m_LeftThirdMotor = new CANSparkMax(LeftThirdDeviceID, MotorType.kBrushless);
  
  // private static CANSparkMax m_RightFirstMotor = new CANSparkMax(RightFirstDeviceID, MotorType.kBrushless);
  // private static CANSparkMax m_RightSecondMotor = new CANSparkMax(RightSecondDeviceID, MotorType.kBrushless);
  // private static CANSparkMax m_RightThirdMotor = new CANSparkMax(RightThirdDeviceID, MotorType.kBrushless);

  public static ADXRS450_Gyro gyro;

	public static void init() {
    // Resets motors to default
    // m_LeftFirstMotor.restoreFactoryDefaults();
    // m_LeftSecondMotor.restoreFactoryDefaults();
    // m_LeftThirdMotor.restoreFactoryDefaults();

    // m_RightFirstMotor.restoreFactoryDefaults();
    // m_RightSecondMotor.restoreFactoryDefaults();
    // m_RightThirdMotor.restoreFactoryDefaults();
    gyro.calibrate();
    gyro.reset();
    System.out.println("[Success] Gyro calibrated at " + gyro.getAngle());
  }
  public void telemetryGyro(){

    // creates Dashboard-Widgets for the gyro angle and the rotation
    SmartDashboard.putNumber("Gyro Angle", gyro.getAngle());
    SmartDashboard.putNumber("Gyro Rotation", gyro.getRate());

  }
}