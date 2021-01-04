package pl.pjatk.bsi_algorytmy;

public class AlgorithmCaster {

    private Algorithm algorithm;

    public void cast(){
        algorithm.use();
    }

    public void setAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
}
