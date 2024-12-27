package com.assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringCalculator {

	// method to extract numbers in the string(+ve & -ve)
	private List<Integer> extractNumbers(String str) {
		str += " ";
		List<String> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c) || (sb.length() == 0 && c == '-')) {
				sb.append(c);
			} else {
				if (sb.length() > 0) {
					arr.add(sb.toString());
					sb = new StringBuilder();
				}
				if (c == '-') {
					sb.append(c);
				}
			}
		}
		return arr.stream().map(Integer::parseInt).collect(Collectors.toList());
	}

	public int Add(String numbers) {

		if (null == numbers || numbers.isBlank())
			return 0;
		int sum = 0;
		List<Integer> pVeList = new ArrayList<>();
		List<Integer> nVeList = new ArrayList<>();
		List<Integer> nums = extractNumbers(numbers);
		for (Integer num : nums) {
			if (num < 0)
				nVeList.add(num);
			else {
				if (num > 1000)
					num = 0;
				pVeList.add(num);
			}
		}
		if (!nVeList.isEmpty()) {
			StringJoiner nVeStr = new StringJoiner(",");
			for (Integer nVeValue : nVeList) {
				nVeStr.add(String.valueOf(nVeValue));
			}
			throw new IllegalArgumentException("negatives not allowed- " + nVeStr);
		}
		for (Integer pVeNum : pVeList) {
			sum += pVeNum;
		}
		return sum;
	}

}
