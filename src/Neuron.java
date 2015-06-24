public class Neuron {
    double weightA = 0;
    double weightB = 0;
    final double alpha = 0.0005; //learning speed, higher is faster but worse.
    boolean jump;   // will be used to set on and off to train weight a or weight b.
                    // It's bad yes, but it's easier to understand weightA weight B than weight[

    public void learn(int inputA, int inputB, int expectedOutput) {
        double output = learnProcess(inputA, inputB);
        double error = expectedOutput - output;
        if (jump) {
            weightA += (alpha * error);
        } else {
            weightB += (alpha * error);
        }
    }

    private double learnProcess(int inputA, int inputB) {
        double output = ((inputA * weightA) + (inputB * weightB));
        return output;
    }

    public int process(int inputA, int inputB) {
        int output = (int) ((inputA * weightA) + (inputB * weightB) + 0.5);
        return output;
    }
}
