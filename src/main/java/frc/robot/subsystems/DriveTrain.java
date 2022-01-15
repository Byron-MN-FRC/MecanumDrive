// RobotBuilder Version: 3.1
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;


// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
private WPI_VictorSPX rightFront;
private WPI_VictorSPX rightBack;
private WPI_VictorSPX leftFront;
private WPI_VictorSPX leftBack;
private MecanumDrive mecDrive;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    /**
    *
    */
    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
rightFront = new WPI_VictorSPX(2);
 
 

rightBack = new WPI_VictorSPX(3);
 
 

leftFront = new WPI_VictorSPX(0);
 
 

leftBack = new WPI_VictorSPX(1);
 
 

 mecDrive = new MecanumDrive(leftFront, leftBack,rightFront, rightBack);
 addChild("mecDrive",mecDrive);
 mecDrive.setSafetyEnabled(true);
mecDrive.setExpiration(0.1);
mecDrive.setMaxOutput(1.0);



    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void driveWithJoystick(Joystick pJoystick) {
        double y = -pJoystick.getY();
		double x = pJoystick.getX();
        double twist = pJoystick.getTwist();
        
     //   if (fMode) {
	//		y *= -1;
	//		x *= -1;
	//	}
        // 2017 code has slow/fast speed which should look at adding & has x/y reversed (not sure why)
        mecDrive.setRightSideInverted(true);
        mecDrive.driveCartesian(x, y, twist,0);

        
    }
}

