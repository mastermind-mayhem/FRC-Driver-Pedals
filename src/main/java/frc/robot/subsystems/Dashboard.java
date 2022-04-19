// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Add your docs here. */
public class Dashboard extends SubsystemBase  {
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    String gear;
    Double speed = Constants.SPEED_AXIS;
    Double turn = Constants.TURN_AXIS;
    if (Constants.GEAR == 1){
      gear = "Reverse";
    } else {
      gear = "Forward";
    }
    SmartDashboard.putString("Gear", gear);
    SmartDashboard.putNumber("Turn", turn);
    SmartDashboard.putNumber("Speed", speed);

  }
}
