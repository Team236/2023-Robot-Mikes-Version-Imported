// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autos;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drive;

public class DriveAtSetSpeed extends Command {

  private Drive drive;
  private double distance, speed, L, R, kPgyro, error;  
  private AHRS navX;

  /** Creates a new DriveToCS. */
  public DriveAtSetSpeed(Drive m_drive, double m_distance, double m_speed) {
    this.drive = m_drive;
    this.distance = m_distance;
    this.speed = m_speed;

    addRequirements(drive);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    navX = new AHRS();
    drive.resetLeftEncoder();
    drive.resetRightEncoder();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    kPgyro = 0.0;
    error = 0;//navX.getRate();

    if (speed > 0) {
      L = (speed - kPgyro*error);
      R = (speed + kPgyro*error);
    } else {
      L = (speed + kPgyro*error);
      R = (speed - kPgyro*error);
    }

    drive.setLeftSpeed(L);
    drive.setRightSpeed(R);
   // SmartDashboard.putNumber("Roll in degrees", drive.getRoll());
    //SmartDashboard.putBoolean("isLevel", drive.isLevel());
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.setBothSpeeds(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Math.abs(drive.getAvgDistance()) >= Math.abs(distance)) {
      return true;
    } else {
      return false;
       }
}
}
