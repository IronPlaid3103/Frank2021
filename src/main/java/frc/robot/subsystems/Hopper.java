// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.HopperConstants;
import frc.robot.util.Settings;

public class Hopper extends SubsystemBase {
  private final CANSparkMax _hopperMotor = new CANSparkMax(HopperConstants.hopperMotor, MotorType.kBrushless);
  private double _power = Constants.HopperConstants.defaultPower;

  /** Creates a new Hopper. */
  public Hopper() {}

  public void stop() {
    _hopperMotor.stopMotor();
  }

  public void hopperGo() {
    _hopperMotor.set(_power);
  }

  public void hopperBack() {
    _hopperMotor.set(-_power);
  }

  public void setPower(double power){
    _power = power;
  }

  public double getPower(){
    return _power;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    _power = Settings.getLiveDouble("Hopper", "Power", Constants.HopperConstants.defaultPower);
  }
}
