public class GradeCalculate {

    public int calculateTotal(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return sum;
    }

    public double calculateAverage(int total, int numberOfSubjects) {
        if (numberOfSubjects == 0) return 0;
        return (double) total / numberOfSubjects;
    }

    public String determineGrade(double percentage) {
        if (percentage >= 90) return "A+ (Excellent)";
        if (percentage >= 80) return "A (Very Good)";
        if (percentage >= 70) return "B (Good)";
        if (percentage >= 60) return "C (Average)";
        if (percentage >= 50) return "D (Pass)";
        return "F (Fail)";
    }
} 
    

