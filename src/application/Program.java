package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entities.Candidate;

public class Program {

	public static void main(String[] main) {

		Scanner sc = new Scanner(System.in);

		Map<Candidate, Integer> urns = new HashMap<>();
		
		System.out.print("Enter file full path: ");
		File file = new File(sc.next());

		sc.close();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String line = br.readLine();
			while (line != null) {
				String[] vect = line.split(",");
				Candidate candidate = new Candidate(vect[0]);
				if (urns.containsKey(candidate)) {
					int sum = urns.get(candidate);
					sum += Integer.parseInt(vect[1]);

					urns.put(candidate, sum);
					line = br.readLine();
				} else {
					urns.put(candidate, Integer.parseInt(vect[1]));
					line = br.readLine();
				}
			}
			
			for (Candidate key : urns.keySet()) {
				System.out.println(key + ": " + urns.get(key));
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
