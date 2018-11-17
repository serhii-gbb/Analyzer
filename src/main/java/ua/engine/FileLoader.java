package ua.engine;

import org.jsoup.Jsoup;

import java.io.IOException;
import java.nio.file.Path;

public class FileLoader {


    public DomMatcher loadToMatcher(Path file) throws IOException {
        return new DomMatcher(Jsoup.parse(file.toUri().toURL().openStream(), "UTF-8", ""));
    }

}
