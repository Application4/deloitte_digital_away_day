package com.deloitte.digital.api;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Santosh Kumar Hota
 *
 */
public class CollectorUtil {

	/**
	 * This method will reduce the round trip between our java application with File
	 * IO Stream
	 *
	 */
	public static List<String> extractTextToList(String input) {
		List<String> datas = new ArrayList<>();
		String line = "";
		try (BufferedReader br = new BufferedReader(new FileReader(new File(input)));) {
			while ((line = br.readLine()) != null) {
				datas.add(line);
			}
		} catch (Exception e) {

		}
		return datas;
	}

	private static Map<String, Integer> activitieMappper(String input) {
		List<String> datas = extractTextToList(input);
		Map<String, Integer> activitieMap = new ConcurrentHashMap<>();
		String value = "";
		String key = "";
		int min = 0;
		for (String data : datas) {
			String[] s = data.split(" ");
			key = String.join(" ", Arrays.stream(s).collect(Collectors.toList())).trim().replace(s[s.length - 1], "");
			value = s[s.length - 1].replace("min", "");
			if (value.equals("sprint")) {
				min = 15;
			} else {
				min = Integer.parseInt(value);
			}
			activitieMap.put(key, min);
		}
		System.out.println(activitieMap.size());
		System.out.println(activitieMap.values().stream().mapToInt(i->i).sum());
		return activitieMap;
	}

	public static void main(String[] args) {
		activitieMappper("activities.txt");
	}
}
