import java.util.HashMap;
import java.util.Map;


class Tester {

    public static void main(String args[]) {
        Map<String, Double> studentMarks = new HashMap<>();
        studentMarks.put("Lily", 90.0);
        studentMarks.put("Robin", 68.0);
        studentMarks.put("Marshall", 76.5);
        studentMarks.put("Neil", 67.0);
        studentMarks.put("Ted", 92.0);
        
        Map<String, Double> maxMinScorers = Student.findMaxMinScorers(studentMarks);
        
        System.out.println("Details of Top Scorers & Low Scorers\n====================================");
        for (Map.Entry<String, Double> entry : maxMinScorers.entrySet()) {
            System.out.println(entry.getKey() + " -- " + entry.getValue());
        }
        
    }
}

class Student {
    
    public static Map<String, Double> findMaxMinScorers(Map<String, Double> studentMarks) {
        Map<String, Double> maxMinScorers = new HashMap<>();
        
        // Initialize variables to track max and min scores
        double maxScore = Double.MIN_VALUE;
        double minScore = Double.MAX_VALUE;
        
        // Iterate through the entries to find max and min scores
        for (Map.Entry<String, Double> entry : studentMarks.entrySet()) {
            double score = entry.getValue();
            String studentName = entry.getKey();
            
            // Update max score and corresponding student(s)
            if (score > maxScore) {
                maxScore = score;
                maxMinScorers.clear(); // Clear previous max scorers
                maxMinScorers.put(studentName, score);
            } else if (score == maxScore) {
                maxMinScorers.put(studentName, score);
            }
            
            // Update min score and corresponding student(s)
            if (score < minScore) {
                minScore = score;
                maxMinScorers.put(studentName, score);
            } else if (score == minScore) {
                maxMinScorers.put(studentName, score);
            }
        }
        
        return maxMinScorers;
    }

}
