package ua.engine;

import org.jsoup.nodes.Element;

import java.util.LinkedList;

public class TreePrinter {

    public void print(Element element) {
        LinkedList<Element> elements = new LinkedList<>(element.parents());
        while (!elements.isEmpty()) {
            Element poll = elements.pollLast();

            System.out.print(poll.tagName() + "[" + poll.className() + "]" + " > ");
        }
        System.out.println(element.tag());
    }
}
