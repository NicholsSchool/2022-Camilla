package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class UpperIndexer extends SubsystemBase {
    private WPI_TalonSRX upperIndexer; 

    public UpperIndexer()
    {
        upperIndexer = new WPI_TalonSRX( RobotMap.UPPER_INDEXER_ID ); 
        upperIndexer.configFactoryDefault(); 
        upperIndexer.setInverted( false );
    }

    public void move( double speed )
    {
        upperIndexer.set( speed );
    }
    public void stop()
    {
        upperIndexer.stopMotor();
    } 
}