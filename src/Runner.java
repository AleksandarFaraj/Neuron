import java.util.Scanner;

/**
 * Created by aleksandarfaraj on 15-06-24.
 */
public class Runner {
    private static int[][] exampleTrainingSchedule = {{0, 0, 0}, {0, 1, 1}, {1, 0, 1}, {1, 1, 1}};
    private static Scanner scanner = new Scanner(System.in);
    private static AI ai;


    private  static void showCurrentTrainingSchedule() {
        System.out.println("\nTraining Schedule set");
        System.out.println("------");
        System.out.printf("%3s: %6s %6s %6s\n", "i", "input", "input", "output");
        for (int i = 0; i < ai.trainingSchedule.length; i++) {

            System.out.printf("%3d: %6d %6d %6d\n", i, ai.trainingSchedule[i][0], ai.trainingSchedule[i][1], ai.trainingSchedule[i][2]);
        }
        System.out.println("------\n");
    }

    private static void learnNeuron() {
        ai.n.clear();
        System.out.println("How many times to train the Neuron?");
        int learnTimes = Integer.parseInt(scanner.nextLine());
        ai.learnNeuron(learnTimes);
    }
    public static void enterTrainingSchedule() {
        for (int i = 0; i < ai.trainingSchedule.length; i++) {
            enterTrainingSchedule(i);
        }
        System.out.println("Created schedule.");
    }

    public static void enterTrainingSchedule(int i) {
        System.out.println("Write 3 inputs and press enter, <input> <input> <expected output>");
        int inputA = scanner.nextInt();
        int inputB = scanner.nextInt();
        int expectedOutput = Integer.parseInt(scanner.nextLine().trim());
        ai.trainingSchedule[i] = new int[3];
        ai.trainingSchedule[i][0] = inputA;
        ai.trainingSchedule[i][1] = inputB;
        ai.trainingSchedule[i][2] = expectedOutput;
    }

    public static void testNeuron() {
        System.out.println("Write 2 inputs and press enter to test, <input> <input>");
        int inputA = scanner.nextInt();
        int inputB = Integer.parseInt(scanner.nextLine().trim());
        System.out.printf("You got:%d\n", (int) (ai.n.process(inputA, inputB)));
    }
    public static void main(String[] args) {
        ai = new AI(ai.trainingSchedule);
        while (true) {
            try {
                showCurrentTrainingSchedule();
                System.out.println("1. Learn the algorithm");
                System.out.println("2. Test the Neuron");
                System.out.println("3. Fill learning schedule");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1:
                        learnNeuron();
                        break;
                    case 2:
                        testNeuron();
                        break;
                    case 3:
                        enterTrainingSchedule();
                        break;
                }
                System.out.println("Press enter to continue");
                scanner.nextLine();
            } catch (Exception e) {

            }
        }

    }

}
