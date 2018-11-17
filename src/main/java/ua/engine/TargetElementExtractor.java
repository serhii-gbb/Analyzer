package ua.engine;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

public class TargetElementExtractor {

    private Path html;

    public TargetElementExtractor(Path html) {
        this.html = html;
    }


    public Element getElementById(String targetId) throws IOException {
        Document targetDom = Jsoup.parse(html.toUri().toURL().openStream(), "UTF-8", "");
        Element elementById = targetDom.getElementById(targetId);
        return Optional.ofNullable(elementById).orElseThrow(() -> new IllegalArgumentException("Element with ID: not found!"));
    }
}
