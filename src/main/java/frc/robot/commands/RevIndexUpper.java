// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotContainer;
import frc.robot.RobotMap;

public class RevIndexUpper extends CommandBase {
  /** Creates a new IndexUpper. */
  public RevIndexUpper() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements( RobotContainer.upperIndexer );
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    RobotContainer.upperIndexer.move( -RobotMap.UPPER_INDEXER_SPEED );

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    RobotContainer.upperIndexer.stop();

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
