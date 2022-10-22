package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LowerIndexer extends SubsystemBase {
    private WPI_TalonSRX lowerIndexer; 

    public LowerIndexer()
    {
        lowerIndexer = new WPI_TalonSRX( RobotMap.LOWER_INDEXER_ID ); 
        lowerIndexer.configFactoryDefault(); 
        lowerIndexer.setInverted( false );
    }

    public void move( double speed )
    {
        lowerIndexer.set( speed );
    }
    public void stop()
    {
        lowerIndexer.stopMotor();
    } 
}
