import java.util.Scanner;

/**
 * Created by alex on 2015-02-12.
 */
public class AI {
    public final Neuron n = new Neuron();
    public final int[][] trainingSchedule;

    public AI(int[][] trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }
    public void learnNeuron(int learnTimes) {
        for (int i = 0; i < learnTimes; i++) {
            //Train one weight at the time with all possible data
            for (int j = 0; j < trainingSchedule.length; j++) {
                n.learn(trainingSchedule[j][0], trainingSchedule[j][1], trainingSchedule[j][2]);
            }
            n.jump = !n.jump;
        }
    }


}

