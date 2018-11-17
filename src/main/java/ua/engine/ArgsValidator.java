package ua.engine;

public class ArgsValidator {

    public static void validate(String... args) {
        if (args.length < 2 || args.length > 3)
            throw new IllegalArgumentException("Wrong number of arguments");
        else if (args[0].isEmpty() || args[1].isEmpty())
            throw new IllegalArgumentException("Arguments can't be a blank");
    }
}
