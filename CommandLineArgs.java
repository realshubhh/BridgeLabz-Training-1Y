// Topic: Accepting User Input - Command Line Arguments
// Run: java CommandLineArgs Alice 25 90.5

public class CommandLineArgs {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage: java CommandLineArgs <name> <age> <score>");
            return;
        }

        String name  = args[0];
        int    age   = Integer.parseInt(args[1]);
        double score = Double.parseDouble(args[2]);

        System.out.println("Name  : " + name);
        System.out.println("Age   : " + age);
        System.out.println("Score : " + score);
        System.out.println("Grade : " + (score >= 90 ? "A" : score >= 75 ? "B" : "C"));
    }
}
