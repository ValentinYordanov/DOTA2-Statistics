package com.fmi.uni.Views;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.fmi.uni.Commands.Command;
import com.fmi.uni.Commands.CommandFactory;

public class ConsoleView {

	Command command;

	private long getProfileIdFromInput() {

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Hello, please enter your OpenDota account id:");
			long profile_id;

			try {
				profile_id = sc.nextLong();
			} catch (InputMismatchException ex) {
				System.out.println("Wrong input type! Please try again with a long type");
				continue;
			}
			return profile_id;
		}

	}

	private String getCommandFromInput() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter command:");
		return sc.nextLine();

	}

	public void start() {

		long profile_id = getProfileIdFromInput();

		while (true) {
			String command = getCommandFromInput();
			if (command.split(" ")[0].equals("exit")) {
				break;
			}
			Command cmd = null;
			try {
				cmd = CommandFactory.getCommandInstance(command, profile_id);
			} catch (NumberFormatException ex) {
				System.out.println("Please input number!");
				continue;
			}
			try {
				cmd.execute();
			} catch (NullPointerException ex) {
				System.out.println("there is no such command, please try again!");
			}
		}
		// sc.close();

	}

	public static void main(String[] args) throws ParseException {

		ConsoleView view = new ConsoleView();
		view.start();

	}

}
