/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package guessnumber;

import java.io.Serializable;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class UserNumberBean implements Serializable {

	private static final long serialVersionUID = 5443351151396868724L;
	Integer randomInt = null;
	private Integer userNumber = null;
	String response = null;
	private int maximum = 10;
	private int minimum = 0;

	public UserNumberBean() {
		Random randomGR = new Random();
		randomInt = new Integer(randomGR.nextInt(maximum + 1));
		// Print number to server log
		System.out.println("Duke's number: " + randomInt);
	}

	public void setUserNumber(Integer user_number) {
		userNumber = user_number;
	}

	public Integer getUserNumber() {
		return userNumber;
	}

	public String getResponse() {
		if ((userNumber == null) || (userNumber.compareTo(randomInt) != 0)) {
			String message = null;
			if (userNumber > randomInt) {
				message = "Lower number";
			} else {
				message = "Bigger Numer";
			}
			return "Sorry, " + userNumber + " is incorrect." + " " + message;
		} else {
			Random randomGR = new Random();
			randomInt = new Integer(randomGR.nextInt(maximum + 1));
			return "Yay! You got it!";
		}
	}

	public int getMaximum() {
		return (this.maximum);
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return (this.minimum);
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}
}
