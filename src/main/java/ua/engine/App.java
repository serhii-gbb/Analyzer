package ua.engine;

import org.jsoup.nodes.Element;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


public class App {

    private static String targetId = "make-everything-ok-button";

    public static void main(String[] args) {
        try {
            ArgsValidator.validate(args);

            targetId = args.length == 3 ? args[2] : targetId;


            Path path = Paths.get(args[0]);
            Path pathDiff = Paths.get(args[1]);


            Element elementById = new TargetElementExtractor(path).getElementById(targetId);

            FileLoader fileLoader = new FileLoader();
            Element matchElement = fileLoader.loadToMatcher(pathDiff).matchElement(elementById);

            System.out.println("\nTarget: " + elementById + "\nFound: " + matchElement + "\n\n");

            new TreePrinter().print(matchElement);

        } catch (IOException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}
