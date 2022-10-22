// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.commands.Drive;
import frc.robot.commands.IndexLow;
import frc.robot.commands.IndexUpper;
import frc.robot.commands.ShootHigh;
import frc.robot.commands.ShootLow;
import frc.robot.commands.TakeIn;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LowerIndexer;
import frc.robot.subsystems.Pistons;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.ShooterPistons;
import frc.robot.subsystems.UpperIndexer;
import frc.robot.util.JoystickController;
import frc.robot.util.XboxController;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  public static JoystickController j0;
	public static JoystickController j1;
  public static XboxController c0; 

  public static DriveTrain driveTrain;

  public static Shooter shooter; 
  public static LowerIndexer lowerIndexer; 
  public static UpperIndexer upperIndexer; 

  public static Intake intake;
  public static Pistons pistons; 
  public static ShooterPistons pistons2; 
  


  Compressor compressor;

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    driveTrain = new DriveTrain();

    j0 = new JoystickController( 0 );
		j1 = new JoystickController( 1 );

    c0 = new XboxController( 2 ); 


    shooter = new Shooter(); 
    intake = new Intake(); 
    lowerIndexer = new LowerIndexer(); 
    upperIndexer = new UpperIndexer(); 
    

    compressor = new Compressor(PneumaticsModuleType.CTREPCM); 
    pistons = new Pistons(); 
    pistons2 = new ShooterPistons(); 
    


    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    driveTrain.setDefaultCommand( new Drive() );

    j1.b1.whenPressed( new InstantCommand( () -> pistons.toggle() ) ); 
    j1.b1.whileHeld(new TakeIn() ); 
    j1.b1.whenReleased( new InstantCommand( () -> pistons.toggle() ) ); 

    c0.lBumper.whileHeld( new IndexLow() ); 
    c0.rBumper.whileHeld(new IndexUpper()); 

    c0.a.whenPressed( new InstantCommand( () -> pistons2.toggle() ) ); 

    c0.rTrigger.whileHeld( new ShootHigh() );
    c0.lTrigger.whileHeld( new ShootLow() ); 
    


  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return null; 
  }
}
