import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class AITest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        int[][] orGate = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 0, 1},
                {1, 1, 1}};

        int[][] andGate = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 0},
                {1, 1, 1}};
        int[][] rightGate = {
                {0, 0, 0},
                {0, 1, 1},
                {1, 0, 0},
                {1, 1, 1}};
        int[][] leftGate = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 0, 1},
                {1, 1, 1}};
        return Arrays.asList(new Object[][]{ // array with different types of trainingschedules for gates
                {orGate},
                {andGate},
                {rightGate},
                {leftGate}});
    }

    private int[][] trainingSchedule;

    public AITest(int[][] trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }

    public int countCorrectGuesses(AI ai) {
        int count = 0;
        for (int[] dataSet : trainingSchedule) {
            int expect = dataSet[2];
            int actual = ai.n.process(dataSet[0], dataSet[1]);

            if (expect == actual) {
                count++;
            }
        }
        return count;
    }

    @Test
    public void freshNeuronShouldFail() {
        AI ai = new AI(trainingSchedule);
        int correctGuesses = countCorrectGuesses(ai);
        assertNotEquals(trainingSchedule.length, correctGuesses);
    }

    @Test
    public void trainedNeuronPasses() {
        AI ai = new AI(trainingSchedule);
        ai.learnNeuron(10000);
        int correctGuesses = countCorrectGuesses(ai);
        assertEquals(trainingSchedule.length, correctGuesses);
    }
}