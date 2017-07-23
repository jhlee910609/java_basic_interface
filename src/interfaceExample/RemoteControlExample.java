package interfaceExample;

public class RemoteControlExample {
	
	public static void main(String args[]){
	
		// interface에 구현된 static 메소드의 경우 바로 참조 가능하다. 
		RemoteControl.changeBattery();
		
		RemoteControl rc = new Audio();
		rc.setMute(true);
		rc.setMute(false);
	}
}
