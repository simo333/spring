package pl.simo333.task1_4;

import pl.simo333.task1_2.CustomerLogger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;

public class FileCustomerLogger implements CustomerLogger {
    private final String filename;

    public FileCustomerLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void log() {
        LocalDateTime actualDateTime = LocalDateTime.now();
        byte[] logMsg = (actualDateTime + ": Customer operation\n").getBytes();
        try {
            Files.write(Paths.get(filename), logMsg, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
