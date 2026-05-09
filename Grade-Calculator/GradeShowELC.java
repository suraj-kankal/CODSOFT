public class GradeShowELC {
    public static void main(String[] args) {
        GradeCalculate calc = new GradeCalculate();

        IO.println("=== Student Grade Portal ===");

        int numSubjects = readInt("Enter the number of subjects: ");
        int[] marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            int score = readInt("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            if (score < 0 || score > 100) {
                IO.println("Invalid marks! Please enter a value between 0 and 100.");
                i--; 
            } else {
                marks[i] = score;
            }
        }

        int totalMarks = calc.calculateTotal(marks);
        double averagePercent = calc.calculateAverage(totalMarks, numSubjects);
        String grade = calc.determineGrade(averagePercent);

        IO.println("\n>>> FINAL REPORT CARD <<<");
        IO.println("Total Marks:      " + totalMarks + " / " + (numSubjects * 100));
        IO.println(String.format("Average Percent:  %.2f%%", averagePercent));
        IO.println("Assigned Grade:   " + grade);
        IO.println("-------------------------");
    }

    private static int readInt(String prompt) {
        while (true) {
            String input = getUserInput(prompt);
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                IO.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static String getUserInput(String prompt) {
        IO.print(prompt);
        if (System.console() != null) {
            return System.console().readLine();
        }

        try {
            return new java.io.BufferedReader(new java.io.InputStreamReader(System.in)).readLine();
        } catch (Exception e) {
            return "";
        }
    }
}
