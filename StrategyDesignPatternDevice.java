interface TouchFeature {
    public void touchScreen();
}

class TouchFinger implements TouchFeature {
    public void touchScreen() {
        System.out.println("You can access touch screen feature through Fingers ");
    }
}

class Stylus implements TouchFeature {
    public void touchScreen() {
        System.out.println("You can access touch screen feature through Pen ");
    }
}

class NoTouchFeature implements TouchFeature {
    public void touchScreen() {
        System.out.println("This device does not have touch screen feature ");
    }
}

abstract class Device {
    
    TouchFeature touchFeature;
    
    public void setTouchFeature(TouchFeature tf) {
        touchFeature = tf;
    }
    
    public void showTouchFeature() {
        touchFeature.touchScreen();
    }
    
    public void display() {
        System.out.println("All Devices has a screen to display ");
    }
    
    public abstract void storage();
    //other common features of all devices 
}

class Tablet extends Device {
    Tablet() {
        touchFeature = new Stylus();
    }
    
    public void storage() {
        System.out.println("Tablet has 256GB of storage ");
    }
}

class KeyPadPhone extends Device {
    KeyPadPhone() {
        touchFeature = new NoTouchFeature();
    }
    
    public void storage() {
        System.out.println("Keypad Phone has 32GB of storage ");
    }
}

class SmartPhone extends Device {
    SmartPhone() {
        touchFeature = new TouchFinger();
    }
    
    public void storage() {
        System.out.println("Smart Phone has 128GB of storage ");
    }
}

public class Main
{
	public static void main(String[] args) {
		Device smartPhoneDevice = new SmartPhone();
		smartPhoneDevice.showTouchFeature();
		smartPhoneDevice.storage();
		smartPhoneDevice.setTouchFeature(new Stylus()); //you can change touch feature at run time
		smartPhoneDevice.showTouchFeature();

		Device keyPadDevice = new KeyPadPhone();
		keyPadDevice.showTouchFeature();
		keyPadDevice.storage();
	}
}

