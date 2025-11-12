public class Main {
    public static void main(String[] args) {
        System.out.println("There were " + args.length + " command line arguments");
        for (String arg : args) {
            System.out.println("Argument: " + arg);
        }
    }
}
