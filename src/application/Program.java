package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = in.nextInt();
		System.out.print("Check-In date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(in.next());
		System.out.print("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(in.next());
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error: the check-In is after of check-Out");
			in.close();
			return;
		}
		
		Reservation r1 = new Reservation(number, checkIn, checkOut);
		System.out.println(r1);
		
		System.out.println();
		System.out.println("Enter a data to update the reservation:");
		System.out.print("Check-In date (dd/MM/yyyy): ");
		checkIn = sdf.parse(in.next());
		System.out.print("Check-Out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(in.next());
		
		Date now = new Date();
		
		if (!checkOut.after(checkIn)) {
			System.out.println("Error: the check-In is after of check-Out");
			in.close();
			return;
		}
		
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error: the dates are before now!");
			in.close();
			return;
		}
		
		r1.updateDates(checkIn, checkOut);
		System.out.println(r1);
		
		in.close();
	}

}
