package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.RobotMap;

public class Pistons extends SubsystemBase {
    private Solenoid pistons;

    public Pistons() {
        pistons = new Solenoid(PneumaticsModuleType.CTREPCM, RobotMap.INTAKE_SOLENOID_CHANNEL);
        SmartDashboard.putBoolean("pistons at instantiation", pistons.get());
    }

    public boolean get() {
        return pistons.get();
    }

    public void extend() {
        pistons.set(Constants.INTAKE_OUT);
        SmartDashboard.putBoolean("pistons state", pistons.get());

    }

    public void retract() {
        pistons.set(Constants.INTAKE_IN);
        SmartDashboard.putBoolean("pistons state", pistons.get());
    }

    public void toggle() {
        pistons.set(!pistons.get());
        SmartDashboard.putBoolean("pistons state", pistons.get());
    }
}