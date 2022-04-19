// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  WPI_VictorSPX m_left1 = new WPI_VictorSPX(Constants.LEFT_MOTOR_1_CANID);
  WPI_VictorSPX m_left2 = new WPI_VictorSPX(Constants.LEFT_MOTOR_2_CANID);

  MotorControllerGroup leftSide = new MotorControllerGroup(m_left1, m_left2);
  
  // in our robot we have two motors on right
  WPI_VictorSPX m_right1 = new WPI_VictorSPX(Constants.RIGHT_MOTOR_1_CANID);
  WPI_VictorSPX m_right2 = new WPI_VictorSPX(Constants.RIGHT_MOTOR_2_CANID);

  MotorControllerGroup rightSide = new MotorControllerGroup(m_right1, m_right2);
  
  DifferentialDrive m_robotDrive = new DifferentialDrive(leftSide, rightSide);
  public DrivetrainSubsystem() {
    rightSide.setInverted(true);
  }

  public void driveTheBot(double speed, double turn)
  {
    
    m_robotDrive.arcadeDrive(speed,turn);
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    String gear;
    if (Constants.GEAR == 1){
      gear = "Reverse";
    } else {
      gear = "Forward";
    }
    SmartDashboard.putString("Gear", gear);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
