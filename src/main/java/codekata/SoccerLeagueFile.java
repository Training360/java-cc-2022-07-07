package codekata;

import lombok.AllArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;

@AllArgsConstructor
public class SoccerLeagueFile {

    private Path path;

    public static void main(String[] args) {
        String team = new SoccerLeagueFile(Path.of("src/main/resources/football.dat")).getSmallestGoalDifference();
        System.out.println(team);
    }

    public String getSmallestGoalDifference() {
        try (var lines = Files.lines(path);) {
            return lines
                    .skip(1)
                    .filter(s -> !s.contains("---"))
                    .map(this::parseLine)
                    .min(Comparator.comparing(Values::getDifference))
                    .orElseThrow(() -> new IllegalArgumentException("No line"))
                    .getLabel();
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }

    private Values parseLine(String line) {
        var label = line.substring(7, 23).trim();
        var max = Integer.parseInt(line.substring(43, 46).trim());
        var min = Integer.parseInt(line.substring(50, 53).trim());
        var values = new Values(label, max, min);
        System.out.println(values);
        return values;
    }
}
