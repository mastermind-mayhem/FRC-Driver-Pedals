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
  private final Joystick joystick = new Joystick(2);

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
    double turns = 0;
    if (joystick.getRawAxis(0) < 0.1 && joystick.getRawAxis(0) > -0.1) {
      turns = 0;
    } else {
      turns = joystick.getRawAxis(0);
    }
    double turn = joystick.getRawAxis(3)*turns*0.65;
    // double turn = turns*0.65;
    double speed = joystick.getRawAxis(3);
    // double speed = 1.0;
    
    if (Constants.GEAR == 1) {
      speed = speed * -0.4;
    } else if (Constants.GEAR == 2)  {
      speed = speed * 0.4;
    } else if (Constants.GEAR == 3){
      speed = speed * 0.6;
    } else {
      speed = speed * 0.9;
    } 
    m_subsystem.driveTheBot(speed, turn);
    Constants.SPEED_AXIS = speed;
    Constants.TURN_AXIS = turn;
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
