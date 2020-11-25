package pl.pjatk.bsi_algorytmy;

/**
 * @author Aleksander Konieczny
 */
public class AlgorithmCaster {

    private Algorithm algorithm;

    public void cast() {
        algorithm.use();
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
