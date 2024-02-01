public class Question3 {
    public static void main(String[] args) {
        String s1 = "Always break ";
        String s2 = "the problem ";
        String s3 = "down.";
        String s4 = s1 + s2 + s3;
        
        System.out.println("s4: " + s4);
        
        s4 = s4.replace('a', '#');
        System.out.println("s4 after replace: " + s4);
        
        // Printing all indices of 'e'
        for (int i = 0; i < s4.length(); i++) {
            if (s4.charAt(i) == 'e') {
                System.out.println("e at index " + i);
            }
        }
    }
}
