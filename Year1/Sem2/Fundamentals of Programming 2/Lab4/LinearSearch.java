public class LinearSearch{
	
	public static void main(String[] args){
		// Declare an string array
        String[] words = {"cat", "hat", "mat", "bat", "hat", "sat"};

        // Print the entire array
        System.out.print("Array: ");
        for (String word : words) {
            System.out.print(word + " ");
        }

        if (rightmostSearch(words, "hat") == -1) {
        	System.out.println("\nNot found: " + rightmostSearch(words, "hat"));
        } else {
	        System.out.println("\nThe rightmost 'hat' is at index: " + rightmostSearch(words, "hat"));
        }
    }

    public static int rightmostSearch(String[] array, String searchKey) {
        int rightmostIndex = -1; // If not found, return -1
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(searchKey)) {
                rightmostIndex = i; // Update each time searchKey is found
            }
        }
        return rightmostIndex;
    }
}