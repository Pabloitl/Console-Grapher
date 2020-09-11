import java.util.Arrays;

public class Graph {
    private final int N_COLUMNS = 12, N_ROWS = 11;
    private final int GRAPH_OFFSET = 2;

    private String[][] graph;
    private int mean;

    public Graph() {
        graph = new String[N_ROWS][N_COLUMNS];
        for (String[] strings : graph) {
            Arrays.fill(strings, " ");
        }

        makeTicks();
    }

    public void plot(int[] values) {
        if (values == null)
            throw new NullPointerException("Error at ploting values");

        mean = (int) Math.round(
            Arrays.stream(values).summaryStatistics().getAverage());

        for (int i = GRAPH_OFFSET; i < N_COLUMNS; i++) {
            for (int j = N_ROWS - GRAPH_OFFSET; j >= 0; j--) {
                graph[j][i] = BoxSelector.getBoxElement(
                    Math.min(
                        Math.max(
                            values[i - 2] + (10 * (j - N_ROWS + GRAPH_OFFSET)),
                            0),
                        10)
                );
            }
        }
        drawMean();
    }

    private void makeTicks() {
        makeXTicks();
        makeYTicks();
    }

    private void makeXTicks() {
        graph[N_ROWS - 1][0] = "   ";
        for (int i = GRAPH_OFFSET - 1; i < N_COLUMNS; i++) {
            graph[N_ROWS - 1][i] = BoxSelector.getBoxDrawing("Horizontal");
        }
    }

    private void makeYTicks() {
        int counter = 95;

        for (int i = 0; i <= N_ROWS - GRAPH_OFFSET; i++) {
            graph[i][0] = String.format("%4d", counter);
            graph[i][1] = BoxSelector.getBoxDrawing("Vertical Tee");
            counter -= 10;
        }
    }

    private void drawMean() {
        String separator = getMeanSeparator();

        for (int i = 0; i < N_COLUMNS; i++) {
            if (graph[N_ROWS - (mean / 10) - 2][i].equals(" ")) {
                graph[N_ROWS - (mean / 10) - 2][i] = separator;
            }
        }
    }

    private String getMeanSeparator() {
        if (mean % 10 <= 2) {
            return BoxSelector.getBoxElement(1);
        } else if (mean % 10 < 8) {
            return BoxSelector.getBoxDrawing("Horizontal Middle");
        } else {
            return BoxSelector.getBoxDrawing("Horizontal");
        }
    }

    public void show() {
        String separator;

        for (String[] row : graph) {
            if (row == graph[N_ROWS - 1])
                separator = BoxSelector.getBoxDrawing("Horizontal");
            else if (row == graph[N_ROWS - (mean / 10) - 2])
                separator = getMeanSeparator();
            else
                separator = " ";
            for (String token : row) {
                System.out.print(token + separator);
            }
            System.out.println();
        }
        System.out.println("Mean: " + mean);
    }
}
