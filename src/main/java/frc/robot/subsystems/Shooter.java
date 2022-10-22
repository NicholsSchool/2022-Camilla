package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Shooter extends SubsystemBase {
    private WPI_TalonFX shooter;

    public Shooter()
    {
        shooter = new WPI_TalonFX( RobotMap.SHOOTER_ID ); 

        shooter.configFactoryDefault();
        shooter.setInverted( false );

        shooter.setNeutralMode( NeutralMode.Coast );
    }

    public void move( double speed )
    {
        shooter.set( speed ); 
    }

    public void stop()
    {
        shooter.stopMotor();
    }

    public double getVelocity()
    {
        return shooter.getSelectedSensorVelocity();
    }

    public void setVelocity( double velocity )
    {
        shooter.set( ControlMode.Velocity, velocity ); 
    }

}
