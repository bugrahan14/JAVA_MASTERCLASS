package interfaces;

/**
 * Rapor üretebilen nesnelerin sözleşmesi.
 * Temel interface: getTitle, getContent; default getSummary, static createEmpty.
 */
public interface Reportable {

    String getTitle();

    String getContent();

    default String getSummary() {
        String content = getContent();
        int maxLen = Math.min(50, content.length());
        return getTitle() + ": " + content.substring(0, maxLen) + (content.length() > 50 ? "..." : "");
    }

    static Reportable empty(String title) {
        return new Reportable() {
            @Override
            public String getTitle() {
                return title;
            }

            @Override
            public String getContent() {
                return "";
            }
        };
    }
}
