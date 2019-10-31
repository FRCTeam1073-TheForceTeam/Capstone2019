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

  private static final int LeftFirstDeviceID = 12;
  private static final int LeftSecondDeviceID = 14;
  private static final int LeftThirdDeviceID = 16;

  private static final int RightFirstDeviceID = 13;
  private static final int RightSecondDeviceID = 15;
  private static final int RightThirdDeviceID = 17;

  private static CANSparkMax m_LeftFirstMotor = new CANSparkMax(LeftFirstDeviceID, MotorType.kBrushless);
  private static CANSparkMax m_LeftSecondMotor = new CANSparkMax(LeftSecondDeviceID, MotorType.kBrushless);
  private static CANSparkMax m_LeftThirdMotor = new CANSparkMax(LeftThirdDeviceID, MotorType.kBrushless);
  
  private static CANSparkMax m_RightFirstMotor = new CANSparkMax(RightFirstDeviceID, MotorType.kBrushless);
  private static CANSparkMax m_RightSecondMotor = new CANSparkMax(RightSecondDeviceID, MotorType.kBrushless);
  private static CANSparkMax m_RightThirdMotor = new CANSparkMax(RightThirdDeviceID, MotorType.kBrushless);

	public static void init() {
    m_LeftFirstMotor.restoreFactoryDefaults();
    m_LeftSecondMotor.restoreFactoryDefaults();
    m_LeftThirdMotor.restoreFactoryDefaults();

    m_RightFirstMotor.restoreFactoryDefaults();
    m_RightSecondMotor.restoreFactoryDefaults();
    m_RightThirdMotor.restoreFactoryDefaults();
	}
}