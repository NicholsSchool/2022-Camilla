package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ShooterPistons extends SubsystemBase {

    private Solenoid pistons;

    public ShooterPistons() {
        pistons = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.SHOOTER_SOLENOID_CHANNEL);  
    }

    public void toggle() {
        boolean pistonsState = pistons.get();
        pistons.set(!pistonsState);
    }
}