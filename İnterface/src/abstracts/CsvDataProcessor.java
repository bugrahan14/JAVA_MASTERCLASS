package abstracts;

public class CsvDataProcessor extends DataProcessor {

    @Override
    protected void readData() {
        System.out.println("[CsvDataProcessor] readData");
    }

    @Override
    protected void transform() {
        System.out.println("[CsvDataProcessor] transform");
    }
}
