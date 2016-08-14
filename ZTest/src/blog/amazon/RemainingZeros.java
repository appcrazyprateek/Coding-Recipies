package blog.amazon;

import java.util.Arrays;

public class RemainingZeros {

	public static void main(String[] args) {
		int[] arr = { 3, 13, 15 };
		encode(arr);
	}

	public static String encode(int[] sequence) {
		for (int i = sequence.length - 1; i > 0; i--) 
			sequence[i] -= sequence[i - 1];

		StringBuilder result = new StringBuilder("");
		for (int i = 0; i < sequence.length; i++) {
			String num = Integer.toBinaryString(sequence[i]).substring(1);
			int[] ones = new int[num.length()];
			Arrays.fill(ones, 1);

			StringBuilder builder = new StringBuilder();
			for (int s : ones)
				builder.append(s + "");

			builder.append("0" + num);
			result.append(builder.toString());
		}

		return result.toString();
	}
}
