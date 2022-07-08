package datamunging;

import java.nio.file.Path;

public class TextFileReadException extends RuntimeException {

    private Path path;

    public TextFileReadException(String message, Throwable cause, Path path) {
        super(message, cause);
        this.path = path;
    }

    public Path getPath() {
        return path;
    }
}
