import lejos.nxt.*;
import lejos.robotics.navigation.*;

public class Shooter {
	public static void main(String[] args) throws Exception {
		TouchSensor touchSensor2 = new TouchSensor(SensorPort.S2);
		TouchSensor touchSensor3 = new TouchSensor(SensorPort.S3);
        Motor.B.setSpeed(200);
        Motor.B.forward();
        while(!touchSensor2.isPressed());
        Motor.B.stop();
        Motor.C.setSpeed(200);
        Motor.C.forward();
        while(!touchSensor3.isPressed());
        Motor.C.rotate(180);
        Motor.C.stop();
		Pilot pilot = new TachoPilot(1.0f, 2.4f, Motor.B, Motor.C);
		pilot.forward();
		while(pilot.getTravelDistance() < 24.5);
		pilot.stop();
		Motor.C.resetTachoCount();
		Motor.B.forward();
        while(!touchSensor2.isPressed());
        Motor.B.rotate(216);
        Motor.C.setSpeed(900);
        Motor.C.forward();
        while(!touchSensor3.isPressed());
        Motor.C.forward();
        while(Motor.C.getTachoCount() < 3240);
        Motor.C.stop();
        Motor.A.setSpeed(600);
        Motor.A.rotate(1440);
	}
}