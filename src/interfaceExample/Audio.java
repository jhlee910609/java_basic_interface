package interfaceExample;

public class Audio implements RemoteControl {
	
	private int audioVolme = 0;

	@Override
	public void turnOn() {
		System.out.println("turn on Audio");
	}

	@Override
	public void turnOff() {
		System.out.println("turn off Audio");
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME){
			this.audioVolme = RemoteControl.MAX_VOLUME;
		} else if(volume < RemoteControl.MIN_VOLUME) {
			this.audioVolme = RemoteControl.MIN_VOLUME;
		} else {
			this.audioVolme = volume;
		}
		System.out.println("현재 Audio 볼륨 : " + audioVolme);
	}
}
