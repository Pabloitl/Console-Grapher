import java.util.HashMap;

public class BoxSelector {
    private static final String[] BOXELEMENTS = {
        " ",
        "▁",
        "▂",
        "▃",
        "▄",
        "▅",
        "▆",
        "▇",
        "▒",
        "▓",
        "█"
    };

    private static final HashMap<String, String> BOXDRAWINGS;
    static {
        BOXDRAWINGS = new HashMap<String, String>();

        BOXDRAWINGS.put("Horizontal", "▔");
        BOXDRAWINGS.put("Vertical", "│");
        BOXDRAWINGS.put("Horizontal Dotted", "╸");
        BOXDRAWINGS.put("Vertical Tee", "┤");
        BOXDRAWINGS.put("Horizontal Middle", "─");
    }

    public static String getBoxElement(int n) {
        return BOXELEMENTS[n];
    }

    public static String getBoxDrawing(String name) {
        return BOXDRAWINGS.get(name);
    }
}
