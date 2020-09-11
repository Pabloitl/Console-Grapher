import java.util.HashMap;

public class BoxSelector {
    private static final String[] BOXELEMENTS = {
        " ",
        "\u2581",
        "\u2582",
        "\u2583",
        "\u2584",
        "\u2585",
        "\u2586",
        "\u2587",
        "\u2592",
        "\u2593",
        "\u2588"
    };

    private static final HashMap<String, String> BOXDRAWINGS;
    static {
        BOXDRAWINGS = new HashMap<String, String>();

        BOXDRAWINGS.put("Horizontal",        "\u2594");
        BOXDRAWINGS.put("Vertical",          "\u258F");
        BOXDRAWINGS.put("Vertical Tee",      "\u2524");
        BOXDRAWINGS.put("Horizontal Middle", "\u2500");
    }

    public static String getBoxElement(int n) {
        return BOXELEMENTS[n];
    }

    public static String getBoxDrawing(String name) {
        return BOXDRAWINGS.get(name);
    }
}
