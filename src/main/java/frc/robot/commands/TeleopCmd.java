// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.DrivetrainSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Constants;

/** An example command that uses an example subsystem. */
public class TeleopCmd extends CommandBase {
  // @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final DrivetrainSubsystem m_subsystem;
  private final Joystick joystick = new Joystick(0);

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public TeleopCmd(DrivetrainSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double turn = 0;
    if (joystick.getRawAxis(0) < 0.1 && joystick.getRawAxis(0) > -0.1) {
      turn = 0;
    } else {
      turn = joystick.getRawAxis(0);
      // turn = turn*joystick.getRawAxis(3);
    }
    
    if (Constants.GEAR == 1) {
      m_subsystem.driveTheBot(joystick.getRawAxis(3)*-0.6, joystick.getRawAxis(3)*turn*0.65);
    } else {
      m_subsystem.driveTheBot(joystick.getRawAxis(3)*0.6, joystick.getRawAxis(3)*turn*0.65);
    }
    
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
