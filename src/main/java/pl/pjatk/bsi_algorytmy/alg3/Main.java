package pl.pjatk.bsi_algorytmy.alg3;

/**
 * What is the highest failure rate for a product if it is to have a reliability (or probability of survival) of 98 percent at 5000 hours?
 * Assume that the time to failure follows an exponential distribution.
 * @author Aleksander Konieczny
 */
class Main {
    public static void main(String[] args) {
        int hours = 5000;
        float percentage = 0.98f;
        System.out.format("%.8f",Math.log(percentage)/hours * -1);
    }
}