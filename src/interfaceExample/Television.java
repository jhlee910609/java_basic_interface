package interfaceExample;

/**
 * @author JunHee
 *
 */
/**
 * @author JunHee
 *
 */
public class Television implements RemoteControl {
	
	private int tvVolume = 0;

	@Override
	public void turnOn() {
		System.out.println("turn on TV");	
	}

	@Override
	public void turnOff() {
		System.out.println("turn off TV");	
	}

	@Override
	public void setVolume(int volume) {
		if(volume > RemoteControl.MAX_VOLUME){
		this.tvVolume = RemoteControl.MAX_VOLUME;
	} else if(volume < RemoteControl.MIN_VOLUME) {
		this.tvVolume = RemoteControl.MIN_VOLUME;
	} else {
		this.tvVolume = volume;
	}
	System.out.println("현재 tv 볼륨 : " + volume);
	}
}
