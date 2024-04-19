package aut.utcluj.demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentGradesManager {
    private static final String SERIALIZED_FILE_PATH = "studentGrades.ser";

    // Method to read the CSV and serialize the data
    public static void readCSVAndSerialize(String csvFilePath) throws IOException {
        Map<String, Double> studentGrades = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String studentCode = parts[0].trim();
                    Double grade = Double.parseDouble(parts[1].trim());
                    studentGrades.put(StudentCodeGenerator.getClassCode(studentCode), grade);
                }
            }
        }

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(SERIALIZED_FILE_PATH))) {
            out.writeObject(studentGrades);
        }
    }

    // Method to deserialize and get grade by student code
    public static Double getGradeByStudentCode(String studentCode) throws IOException, ClassNotFoundException {
        Map<String, Double> studentGrades;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(SERIALIZED_FILE_PATH))) {
            studentGrades = (Map<String, Double>) in.readObject();
        }

        return studentGrades.getOrDefault(studentCode, null);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        try {
            // Example: serialize data from CSV
            readCSVAndSerialize("demo_note.txt");

            // Example: retrieve and print a grade by student code
            Double grade = getGradeByStudentCode(StudentCodeGenerator.getClassCode("vadan.li.gabriel@student.utcluj.ro"));
            if (grade != null) {
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("Student code not found.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
