public class Main {
    public static void main(String[] args) {
        ArrayList strings = new ArrayList(10);
        System.out.println(strings.size());
        System.out.println(strings.add("Zero"));
        System.out.println(strings.add("First"));
        System.out.println(strings.add("Second"));
        System.out.println(strings.add("Third"));
        System.out.println(strings.add("Fourth"));
        System.out.println(strings.toString(", "));
        System.out.println(strings.remove(2));
        System.out.println(strings.toString("||"));
        System.out.println(strings.add(2,"Insider"));
        System.out.println(strings.toString(", "));
        System.out.println(strings.lastIndexOf("First"));
        System.out.println(strings.indexOf("First"));
    }
}