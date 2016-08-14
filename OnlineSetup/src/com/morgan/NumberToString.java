package com.morgan;

public class NumberToString {
	public static void main(String[] args) {
		System.out.println(ConvertNumberToString(-906));
	}
	
	static String string;
	static String ones[] = { "", "one", "two", "three", "four", "five", "six",
			"seven", "eight", "nine", };
	static String cons2[] = { "hundred", "thousand", "lakh", "crore" };
	static String tens[] = { "ten", "eleven", "twelve", "thirteen", "fourteen",
			"fifteen", "sixteen", "seventeen", "eighteen", "ninteen", };
	static String cons3[] = { "twenty", "thirty", "fourty", "fifty", "sixty",
			"seventy", "eighty", "ninety" };

	static String ConvertNumberToString(int num) {
		int n = 1;
		int word;
		string = "";
		int copy=num;
		if(num<0)
			num*=-1;
		
		while (num != 0) {
			switch (n) {
			case 1:
				word = num % 100;
				converter(word);
				if (num > 100 && num % 100 != 0) {
					display("and ");
					// System.out.print("ankit");
				}
				num /= 100;
				break;
			case 2:
				word = num % 10;
				if (word != 0) {
					display(" ");
					display(cons2[0]);
					display(" ");
					converter(word);
				}
				num /= 10;
				break;
			case 3:
				word = num % 100;
				if (word != 0) {
					display(" ");
					display(cons2[1]);
					display(" ");
					converter(word);
				}
				num /= 100;
				break;
			case 4:
				word = num % 100;
				if (word != 0) {
					display(" ");
					display(cons2[2]);
					display(" ");
					converter(word);
				}
				num /= 100;
				break;
			case 5:
				word = num % 100;
				if (word != 0) {
					display(" ");
					display(cons2[3]);
					display(" ");
					converter(word);
				}
				num /= 100;
				break;
			}
			n++;
		}
		String minus="";
		if(copy<0)
			minus="MINUS ";
		return minus+string.toUpperCase();

	}

	public static void converter(int number) {
		int word, q;
		if (number < 10) {
			display(ones[number]);
		}
		if (number > 9 && number < 20) {
			display(tens[number - 10]);
		}
		if (number > 19) {
			word = number % 10;
			if (word == 0) {
				q = number / 10;
				display(cons3[q - 2]);
			} else {
				q = number / 10;
				display(ones[word]);
				display(" ");
				display(cons3[q - 2]);
			}
		}
	}

	public static void display(String s) {
		String st;
		st = string;
		string = s;
		string += st;
	}
}
