package interfaces;

public class PdfReport implements Reportable {

    private final String title;
    private final String content;

    public PdfReport(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getContent() {
        return content;
    }
}
