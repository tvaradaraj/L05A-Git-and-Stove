/*
* Class: Burner: 
* Creates the burner and methods to change the setting and temperature.
* 
* Authors: Trisha, Marcus
* Date: 9/18/26
* Collaborators: N/A
* Sources: Java Documentation
*
*/

package basePackage;

public class Burner {
	
	public enum Temperature {
		BLAZING("VERY HOT! DON'T TOUCH"),
		HOT("CAREFUL"),
		WARM("warm"),
		COLD("coool");
		
		private String tempTxt;
		Temperature(String tempTxt) {
			this.tempTxt = tempTxt; // To save the custom texts 
		}
		
		@Override
		public String toString() {
			return tempTxt; // Converts Temperature enum to Text when with String
		}
	}
	
	private Temperature myTemperature;
	private Setting mySetting;
	private int timer;
	private static final int TIME_DURATION = 2;
	
	/*
	 * Constructor for Burner
	 * Set burner to off, cold, and no timer
	 */
	public Burner() {
		super();
		myTemperature = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;
	}
	
	/*
	 * Change setting based on what it currently is
	 * If already at highest setting, break
	 */
	 
	 public void display() {
		 System.out.println(mySetting + "...." + myTemperature);
	 }
	 
	 public Temperature getTemperature () {
		 return myTemperature;
	 }
	 
	public void plusButton() {
		switch (mySetting) {
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				break;
			
		}
		
		timer = TIME_DURATION;
	}
	
	/*
	 * Change setting based on what it currently is
	 * If already at lowest setting, break
	 */
	public void minusButton() {
		switch (mySetting) {
		case OFF:
			break;
		case LOW:
			mySetting = Setting.OFF;
			break;
		case MEDIUM:
			mySetting = Setting.LOW;
			break;
		case HIGH:
			mySetting = Setting.MEDIUM;
			break;
			
		}
		
		timer = TIME_DURATION;
	}

	/*
	 * Update the temperature of the burner based on its setting
	 */
	public void updateTemperature() {
		if (timer >0){
			timer--;
		}
		if (timer == 0){
			switch (mySetting) {
				
			case HIGH:
				if (myTemperature == Temperature.COLD) {
					myTemperature = Temperature.WARM;
				}
				else if (myTemperature == Temperature.WARM){
					myTemperature = Temperature.HOT;
					
				}
				else if (myTemperature == Temperature.HOT){
					myTemperature = Temperature.BLAZING;
				}
				break;
				
			case MEDIUM:
				if (myTemperature == Temperature.COLD) {
					myTemperature = Temperature.WARM;
				}
				else if (myTemperature == Temperature.WARM){
					myTemperature = Temperature.HOT;
					
				}
				else if (myTemperature == Temperature.BLAZING){
					myTemperature = Temperature.HOT;
				}
				break;
				
				
			case LOW:
				if (myTemperature == Temperature.COLD) {
					myTemperature = Temperature.WARM;
				}
				else if (myTemperature == Temperature.HOT || myTemperature == Temperature.BLAZING) {
					myTemperature = Temperature.WARM;
					}
				break;
				
			case OFF:
				if (myTemperature == Temperature.BLAZING) {
					myTemperature = Temperature.HOT;
				}
				else if (myTemperature == Temperature.HOT){
					myTemperature = Temperature.WARM;
					
				}
				else if (myTemperature == Temperature.WARM){
					myTemperature = Temperature.COLD;
				}
				break;
				
			}
		}
	}
	
	
}
