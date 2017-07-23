# 인터페이스 (Interface)

###   1. 인터페이스란

- 자바에서 인터페이스는 객체의 사용 방법을 정의한 타입이다.
- 인터페이스는 객체의 교환성을 높여주기 때문에 다형성을 구현하는 매우 중요한 역할을 한다.
- 인터페이스는 개발 코드와 객체가 서로 통신하는 접점 역할을 한다.
- 인터페이스는 상속과 달리 클래스 상에 다중 구현이 가능하다. 



### 2. 인터페이스의 선언

- 인터페이스 내부에 '상수 필드 선언'과 '메소드 선언'을 한다.

```java
public interface interfaceExample {
  // 상수
  public int MAX_VOLUME = 10;
  public int MIN_VOLUME = 0;
  
  // 추상 메소드 - 메소드 선언부만 작성하고, 구체적인 로직은 작성하지 않는다. 
  public void turnOn();
  public void turnOff();
  public void setVolum(int volume);  
  
  // default 메소드 - 자바8에서 추가된 인터페이스의 새로운 멤버이다. (컴파일 시, 자동 public)
  default void setMute(boolean mute){
		if(mute){
			System.out.println("무음 처리합니다...");
		} else {
			System.out.println("무음 처리 해합니다...");
		}
	}
  
  // static 메소드 - 자바8에서 추가된 인터페이스의 새로운 멤버이다. (컴파일 시, 자동 public)
  static void changeBattery(){
		System.out.println("건전지를 교환합니다..");
	}
}
```

##### 1.1. Default 메소드

- default 메소드는 인터페이스에 선언되지만, 인터페이스에서 바로 사용할 수 없다.
- default 메소드는 추상 메소드가 아닌 인스턴스 메소드이므로 구현 객체가 있어야 사용할 수 있다.

```java
RemoteControl.setMute(true); // 바로 인터페이스의 디폴트 메소드 호출할 수 없다.

RemoteControl remoteControl = new Television();
remoteControl.setMute(true); // 구현 객체에서 @Override 하여 상황에 맞게 사용할 수 있다. 
```



##### 1.2. Static 메소드

- 인터페이스의 정적 메소드는 인터페이스로 바로 호출이 가능하다.

```java
public class RemoteControlExample {
  public static void main(String args[]){
    RemoteControl.changeBattery();
  }
}
```



### 3. 인터페이스의 구현

- 클래스 선언부에 `implements 인터페이스명` 을 명시해준다.

```java
public class ClassName implements interfaceName {
  
  // 메소드 @Override 형태로 구현된다.
  
}
```



### 4. 익명 객체 구현

- 일회성의 구현 객체를 만들기 위해 사용한다.
- 주로 안드로이드에서 event 처리, 임시 작업 스레드를 만들기 위해 익명 객체를 활용한다.

```java
인터페이스 변수 = new 인터페이스(){
  
  // 인터페이스에 선언된 추상 메소드를 구현한다.
  
};

```



### 5. 타입 변환과 다형성

##### 1.1. 다형성

-  하나의 타입에 대입되는 객체에 따라서 실행 결과가 다양한 형태로 나오는 성질


- 인터페이스도 상속처럼 다형성을 구현하는 기술이 사용된다.

> **'상속의 다형성'과 '인터페이스의 다형성'의 차이**
>
>   상속은 같은 종류의 하위 클래스를 만드는 기술이고, 인터페이스는 사용 방법이 동일한 클래스를 만드는 기술이라는 개념적 차이는 있지만 결국 둘 다 다형성을 구현하는 기술임에는 궤를 함께 한다. 



##### 1.2. 매개변수로 자주 사용되는 인터페이스

- 인터페이스 타입으로 매개 변수를 선언하면 메소드 호출 시, 매개값으로 여러 가지 종류의 구현 객체를 줄 수 있기 때문에 실행 결과가 다양하게 나온다.
- 다형성을 활용하여 특정 interface를 implements한 클래스가 **자동형변환(다운캐스팅)**되어 함수의 매개변수로 활용할 수 있다. 

> 아래의 예시에서는 `userRemoteControl(RemoteControl rc);` 함수를 통과할 때, `Audio` 클래스와 `Tv` 클래스 모두 `RemoteControl`로 다운캐스팅 된다. 

![interface](https://ws1.sinaimg.cn/large/006tKfTcgy1fhtyol2rnjj30sg0lc3zw.jpg)

