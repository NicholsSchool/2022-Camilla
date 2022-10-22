package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class Pistons extends SubsystemBase {

    private Solenoid pistons;

    public Pistons() {
        pistons = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.INTAKE_SOLENOID_CHANNEL);
        toggle();   
    }

    public void toggle() {
        boolean pistonsState = pistons.get();
        pistons.set(!pistonsState);
    }
}