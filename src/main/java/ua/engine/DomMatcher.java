package ua.engine;

import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Optional;

public class DomMatcher {

    private Document document;

    public DomMatcher(Document document) {
        this.document = document;
    }


    public Element matchElement(Element element) {
        Element matchedElem = null;
        Attributes targetAttributes = element.attributes();

        int maxMatches = 0;

        Elements elementsByTag = document.getElementsByTag(element.tagName());
        for (Element aTag : elementsByTag) {
            Attributes foundAttrs = aTag.attributes();

            long count = foundAttrs.asList().stream()
                    .filter(fattr -> targetAttributes.get(fattr.getKey()).equals(fattr.getValue()))
                    .count();

            if (count > maxMatches) {
                matchedElem = aTag;
                maxMatches = ((int) count);
            }
        }

        return Optional.ofNullable(matchedElem).orElseThrow(() -> new IllegalStateException("No matched elements"));
    }
}