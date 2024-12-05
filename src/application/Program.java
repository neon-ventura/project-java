package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){

		Scanner in = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
		
		System.out.print("Room number: ");
		int number = in.nextInt();
		System.out.print("Check-In date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(in.next());
		System.out.print("Check-Out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(in.next());

		Reservation r1 = new Reservation(number, checkIn, checkOut);
		System.out.println(r1);

		System.out.println();
		System.out.println("Enter a data to update the reservation:");
		System.out.print("Check-In date (dd/MM/yyyy): ");
		checkIn = sdf.parse(in.next());
		System.out.print("Check-Out date (dd/MM/yyyy): ");
		checkOut = sdf.parse(in.next());

		r1.updateDates(checkIn, checkOut);
		System.out.println(r1);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}

		in.close();
	}

}
