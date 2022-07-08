package datamunging;

public class WeatherFileFormat implements TextFileFormat {

    @Override
    public Values parseLine(String line) {
        var label = Integer.parseInt(line.substring(0, 5).trim());
        var max = Integer.parseInt(line.substring(12, 14).trim());
        var min = Integer.parseInt(line.substring(15, 21).trim());
        return new Temperatures(label, max, min);
    }

    @Override
    public boolean lineToProcess(String s) {
        return !s.contains("mo");
    }

    @Override
    public int numberOfHeaderLines() {
        return 2;
    }
}
