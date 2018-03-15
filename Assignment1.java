import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
import java.util.Collections;

class BMICalculator {

	public BMICalculator() {
		// no code required
	}

	public double value( double weight, double height ) {

		DecimalFormat df = new DecimalFormat("0.#");
		double bmi = weight/(height * height);
		return  Double.parseDouble(df.format(bmi));
	}

	public String classification8( double bmi ) {
		// return the 8 category (Wikipedia) classification for this BMI

			if(bmi <= 15) {
				return	"Very severely underweight";

			} else if(bmi > 15 && bmi <= 16) {
				return "Severely underweight";

			} else if (bmi > 16 && bmi <= 18.5) {
				return "Underweight";

			} else if (bmi > 18.5 && bmi <= 25) {
				return "Normal (healthy weight)";

			} else if (bmi > 25 && bmi <= 30) {
				return "Normal (healthy weight)";

			} else if (bmi > 30 && bmi <= 35) {
				return "Moderately obese";

			} else if (bmi > 35 && bmi <= 40) {
				return "Severely obese";

			} else if(bmi >= 40) {
				return "Very severely obese";

			} else {
				return "Unknown";
			}
	}

	public String classification3( double bmi ) {
		// return the 3 category (high, normal, low) classification for this BMI
		if (bmi <= 18.5) {
			return "low";
		} else if (bmi > 18.5 && bmi <= 25) {
			return "normal";
		} else {
			return "high";
		}
	}
}
public class Assignment1 {
	// no attributes required
	public static void main(String[] args) {
		// local variable declarations go here
		final int N = 10;
		double totalBMI = 0;
		double averageBMI;
		double bmiValue;
		double height;
		double weight;
		ArrayList<Double> bmiCollection;
		ArrayList<String> avgBMICollection;
		BMICalculator bmi;
		Scanner reader;
		bmiCollection = new ArrayList<>();
		avgBMICollection = new ArrayList<>();
		bmi = new BMICalculator();
		reader = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.#");

		// display welcome message
		System.out.println("Welcome to BMI calculator");
		// loop to input an individual’s height and weight and calculate and display BMI, calculate summary values

		for(int i = 0; i < N; i++) {
			System.out.print("Height for person " + i + " (m): ");
			height = reader.nextDouble();
			System.out.print("Weight for person " + i + " (kgs): ");
			weight = reader.nextDouble();
			bmiValue = bmi.value(weight, height);
			System.out.print("BMI for person "+ i +": " + bmiValue +
			" which is " + bmi.classification8(bmiValue)+ "\n");
			bmiCollection.add(bmiValue);
		}

		// generate and display summary
		System.out.println("\n******************\nSummary\n******************");
		System.out.println("Lowest BMI : " + Collections.min(bmiCollection));
		System.out.println("Lowest BMI : " + Collections.max(bmiCollection));
		for(int i = 0; i < bmiCollection.size(); i++){
			totalBMI += bmiCollection.get(i);
		}
		averageBMI = totalBMI / bmiCollection.size();
		System.out.println("Average BMI : " + Double.parseDouble(df.format(averageBMI)));

		for (Double eachBMI : bmiCollection) {
			avgBMICollection.add(bmi.classification3(eachBMI));
		}

		System.out.println("Number with low BMI: " + Collections.frequency(avgBMICollection, "low"));
		System.out.println("Number with normal BMI: " + Collections.frequency(avgBMICollection, "normal"));
		System.out.println("Number with high BMI: " + Collections.frequency(avgBMICollection, "high"));
		// display exit message
		System.out.println("\n******* Thank you for calculating BMI *******\n");

	}
}
