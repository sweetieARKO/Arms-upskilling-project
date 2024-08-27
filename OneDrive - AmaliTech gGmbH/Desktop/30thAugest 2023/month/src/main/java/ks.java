public class ks {
    public static void main(String[] args) {
   long previous = 66;
    long current =60; 
    double percentageChange = calculatePercentageChange(current, previous);
    System.out.println("Percentage Change: " + percentageChange + "%");
}

    private static double calculatePercentageChange(long current, long previous){
    if (previous == 0){
        return current > 0 ? 100.0 : 0.0;
    }
    return ((double)(current - previous)/previous )*100;
    }
}