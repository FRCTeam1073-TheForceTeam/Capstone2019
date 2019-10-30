package frc.robot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

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
  
  /** I'm not sure how to set up MAX Sparks, so please put examples here ASAP! -Jack */

  private static final int leftDeviceID = 1;
  private static final int rightDeviceID = 2;

  private static CANSparkMax m_leftMotor = new CANSparkMax(leftDeviceID, MotorType.kBrushless);
  private static CANSparkMax m_rightMotor = new CANSparkMax(rightDeviceID, MotorType.kBrushless);

	public static void init() {
    m_leftMotor.restoreFactoryDefaults();
    m_rightMotor.restoreFactoryDefaults();
	}
}