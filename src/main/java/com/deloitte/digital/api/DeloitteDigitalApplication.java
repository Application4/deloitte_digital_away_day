package com.deloitte.digital.api;

import java.util.List;

/**
 * Hello world!
 *
 */
public class DeloitteDigitalApplication {

	public static int getTeamCount(String input) {
		List<String> data = CollectorUtil.extractTextToList(input);
		for (String line : data) {
			System.out.println(line);
		}
		return 0;
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Hello World!");
		getTeamCount("activities.txt");
	}
}
