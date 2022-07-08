package codekata;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

@AllArgsConstructor
public class WeatherDataFile {

    private Path path;

    public static void main(String[] args) {
        String day = new WeatherDataFile(Path.of("src/main/resources/weather.dat")).getSmallestTemperatureSpreadDay();
        System.out.println(day);
    }

    public String getSmallestTemperatureSpreadDay() {
        try (var lines = Files.lines(path);) {
            return lines
                    .skip(2)
                    .filter(s -> !s.contains("mo"))
                    .map(this::parseLine)
                    .min(Comparator.comparing(Values::getDifference))
                    .orElseThrow(() -> new IllegalArgumentException("No line"))
                    .getLabel();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private Values parseLine(String line) {
        var label = line.substring(0, 5).trim();
        var max = Integer.parseInt(line.substring(12, 14).trim());
        var min = Integer.parseInt(line.substring(15, 21).trim());
        var values = new Values(label, max, min);
        System.out.println(values);
        return values;
    }
}
