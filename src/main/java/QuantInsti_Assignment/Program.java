package QuantInsti_Assignment;

public class Program {

	static int sum = 0,num=1000;

	public static void main(String[] args) {

		for (int i = 1; i < num; i++) {

			if (i % 3 == 0 || i % 5 == 0)

				sum = sum + i;

		}

		System.out.println("The sum of 3 or 5 multiples below 1000 is : " + sum);

	}

}

