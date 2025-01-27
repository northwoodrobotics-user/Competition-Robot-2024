package frc.robot.commands;



import frc.robot.subsystems.Climber;
import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;

import java.util.function.DoubleSupplier;


public class TeleClimber extends Command {

      private final Climber m_climber;
      private DoubleSupplier pwr;


  public TeleClimber(Climber climber, DoubleSupplier pwr) {

      m_climber = climber;
      this.pwr = pwr;
      addRequirements(m_climber);

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void initialize() {
  }

   // Called every time the scheduler runs while the command is scheduled.
   @Override
   public void execute() {
     m_climber.move(MathUtil.applyDeadband(pwr.getAsDouble(),0.1));
   }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Always return false so the command never ends on it's own. In this project we use the
    // scheduler to end the command when the button is released.
    return false;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    // Stop the wheels when the command ends.
    m_climber.stop();
  }
}