package interfaceExample;

public interface RemoteControl {
	// 상수를 선언해둔다. 
	int MAX_VOLUME = 10;
	int MIN_VOLUME = 0;
	
	// 메소드를 선언만 해두고, 구체적인 구현은 implements 받는 곳에서 한다. 
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 자바8에서 새로 생긴 default 메소드 
	default void setMute(boolean mute){
		if(mute){
			System.out.println("무음 처리합니다...");
		} else {
			System.out.println("무음 처리 해합니다...");
		}
	}
	
	static void changeBattery(){
		System.out.println("건전지를 교환합니다..");
	}
}
