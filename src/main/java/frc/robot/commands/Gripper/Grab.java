// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Gripper;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.Constants.*;
import frc.robot.subsystems.Gripper;

public class Grab extends Command {
  private Gripper gripper3;
  /** Creates a new Grab. */
  public Grab(Gripper grabGripper) {
    this.gripper3 = grabGripper;
    addRequirements(gripper3);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    gripper3.grab();
  }
  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    //gripper3.grab();
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
  // if (gripper3.isGripping()) {
  //   SmartDashboard.putBoolean("Grab-isFinished", true);
  //   return true;
  // } else {
  //   SmartDashboard.putBoolean("Grab-isNotFinished", true);
  //   return false;
  // }
    return false;
}











}
