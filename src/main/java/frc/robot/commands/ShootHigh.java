package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class ShootHigh extends CommandBase
{
    public ShootHigh() 
    {
        addRequirements( RobotContainer.shooter, RobotContainer.upperIndexer );
    }

    @Override
    public void initialize() 
    {
        RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
    }

    @Override
    public void execute()
    {
        if( RobotContainer.shooter.getVelocity() < Constants.HIGH_GOAL_VELOCITY )
            RobotContainer.shooter.move( Constants.SHOOTER_SPEED );
        else
            RobotContainer.upperIndexer.move( Constants.INDEXER_SPEED );
    }

    @Override
    public void end( boolean interrupted ) 
    {
        RobotContainer.shooter.stop();
        RobotContainer.upperIndexer.stop();
    }

    @Override
    public boolean isFinished() 
    {
        return false;
    }
}