package Regex;
import java.util.regex.*;
public class RegexPlayground {
    public static void test(String description, String regex, String text) {
        System.out.println("\n--- " + description + " ---");
        System.out.println("Regex : " + regex);
        System.out.println("Text  : " + text);

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println("Match ---> " + m.group());
        }
//        System.out.println();
    }

    public static void main(String[] args) {

        // 1. Exact characters
        test("Exact word", "cat", "cat bat scatter catalog");

        // 2. Any character (.)
        test("Dot means any one character", "c.t", "cat cut cot coat");

        // 3. Digit (\\d)
        test("Digit", "\\d", "a1b2c3");

        // 4. Non digit (\\D)
        test("Non Digit", "\\D", "a1b2c3");

        // 5. Word character (\\w)
        test("Word character", "\\w", "hi!_7");

        // 6. Non word (\\W)
        test("Non word", "\\W", "hi!_7");

        // 7. Space (\\s)
        test("Whitespace", "\\s", "hi there\tfriend");

        // 8. Non space (\\S)
        test("Non Whitespace", "\\S", "hi there");

        // 9. Start of line ^
        test("Start of line", "^Hello", "Hello world\nHi Hello");

        // 10. End of line $
        test("End of line", "end$", "the end\nendless");

        // 11. One or more +
        test("One or more", "a+", "a aa aaa b");

        // 12. Zero or more *
        test("Zero or more", "ba*", "b ba baa baaa");

        // 13. Optional ?
        test("Optional u", "colou?r", "color colour colouur");

        // 14. Exact count {n}
        test("Exactly 3 digits", "\\d{3}", "12 123 1234");

        // 15. Range {n,m}
        test("2 to 4 digits", "\\d{2,4}", "1 12 123 1234 12345");

        // 16. Character set []
        test("Either a b or c", "[abc]", "apple banana cat dog");

        // 17. Negated set [^]
        test("Not a b or c", "[^abc]", "abcxyz");

        // 18. OR |
        test("cat or dog", "cat|dog", "cat dog cow");

        // 19. Group ()
        test("Group repetition", "(ab)+", "ab abab ababab ac");

        // 20. Escape special char \\
        test("Literal dot", "\\.", "file.txt end.");

        // 21. Beginning word boundary \\b
        test("Word boundary", "\\bcat\\b", "cat scatter catty cat");

        // 22. Not word boundary \\B
        test("Not word boundary", "\\Bcat\\B", "scatcat cat");

        // 23. Lookahead (?= )
        test("Number before kg", "\\d+(?=kg)", "5kg 10kg 20g");

        // 24. Negative lookahead (?! )
        test("Number not before kg", "\\d+(?!kg)", "5kg 10kg 20g");

        // 25. Capturing group retrieval
        System.out.println("\n--- Capturing Groups ---");
        Pattern p = Pattern.compile("(\\d{2})-(\\d{2})-(\\d{4})");
        Matcher m = p.matcher("Date: 14-02-2026");
        if(m.find()){
            System.out.println("Day   : " + m.group(1));
            System.out.println("Month : " + m.group(2));
            System.out.println("Year  : " + m.group(3));
        }
    }
}

