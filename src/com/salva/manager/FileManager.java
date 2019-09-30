package com.salva.manager;

import com.salva.bean.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	//  Singleton
	private static FileManager fManager = null;

	public static FileManager getInstance() {
		if (fManager == null) {
			fManager = new FileManager();
			return fManager;
		} else {
			return fManager;
		}
	}

	public void processFile(String peopleFile) {

		//  Store de people data....
		try {
			BufferedReader buffReader = new BufferedReader(new FileReader(peopleFile));

			//  Skip first header line
			buffReader.readLine();
			String personLine;
			Person person;
			//  We assume that file data does not contain errors
			while ((personLine = buffReader.readLine()) != null) {
				if (!personLine.isEmpty()) {
					String[] dataPerson = personLine.split(",");
					person = new Person();
					person.setName(dataPerson[0]);
					person.setSurnames(dataPerson[1]);
					person.setAge(Integer.parseInt(dataPerson[2]));
					person.setGender(dataPerson[3]);
					//  Add person to computer...
					StatisticalComputer.getInstance().addPerson(person);
				}
			}
		} catch (IOException e) {
			System.out.println("Error while processing file");
		}

	}


	public static class StatisticalComputer {

		//  Singleton
		private static StatisticalComputer sComputer = null;

		// Data structure
		private ArrayList<Person> peopleArray;

		// Stat variables
		private double totalAge;
		private int menCount;
		private int womenCount;
		private int youngestManAge;
		private int olderWomanAge;
		private boolean brotherOrSisterFound;

		public static StatisticalComputer getInstance() {
			if (sComputer == null) {
				sComputer = new StatisticalComputer();
				return sComputer;
			} else {
				return sComputer;
			}
		}

		private StatisticalComputer() {
			peopleArray = new ArrayList<>(10);
			totalAge = 0;
			menCount = 0;
			womenCount = 0;
			brotherOrSisterFound = false;
		}

		public void addPerson(Person person) {
			peopleArray.add(person);
			computeData(person);
		}

		private void computeData(Person person) {

			totalAge = totalAge + person.getAge();

			if (person.getGender().equals("M")) {
				menCount++;
				youngestManAge = peopleArray.size() == 1 ? person.getAge() : Math.min(youngestManAge, person.getAge());
			} else {
				womenCount++;
				olderWomanAge = peopleArray.size() == 1 ? person.getAge() : Math.max(olderWomanAge, person.getAge());
			}

			brotherOrSisterFound = surnamesExists(person);
		}

		private boolean surnamesExists(Person person) {
			for (Person personIt : peopleArray) {
				if (!person.getName().equals(personIt.getName()) && person.getSurnames().equals(personIt.getSurnames())) return true;
			}
			return false;
		}

		public void showResults() {
			System.out.println("***********************************************");
			System.out.println("Mean age: " + totalAge / peopleArray.size());
			System.out.println("Difference between men ("+menCount+") and women ("+womenCount+"):" + Math. abs(menCount - womenCount));
			System.out.println("Difference between older woman ("+olderWomanAge+") and youngest man ("+youngestManAge+"): " + Math. abs(olderWomanAge - youngestManAge));
			System.out.println("Brothers or sisters found: " + brotherOrSisterFound);
			System.out.println("***********************************************");
		}

	}
}
