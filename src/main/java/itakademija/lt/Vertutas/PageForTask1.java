package itakademija.lt.Vertutas;

import java.util.Random;

public class PageForTask1 {
	
	String firstName;
	String lastName;
	String emailAdress;
	String phoneNumber;
	
	public PageForTask1(String firstName, String lastName, String emailAdress, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAdress = firstName + lastName + createRandomString() + emailAdress;
		this.phoneNumber = phoneNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String createRandomString() {

		Random randomizer = new Random();

		String randomText = ("qwertyuioasdfghjkl");

		char[] text = new char[5];
		for (int i = 0; i < 5; i++) {
			text[i] = randomText.charAt(randomizer.nextInt(randomText.length()));
		}
		return new String(text);

	}
	@Override
	public String toString() {
		return "Account for [firstName=" + firstName + ", lastName=" + lastName + ", emailAdress=" + emailAdress
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
