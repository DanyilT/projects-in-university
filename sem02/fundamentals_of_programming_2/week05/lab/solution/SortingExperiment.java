import java.util.Random;
import java.util.Arrays;

public class SortingExperiment{
	
	// Method to generate a random array with a seed value
	public static int[] makeRandomArray(int size, int min, int max, int seed){
		// Make a random generator
		Random rnd = new Random(seed);
		// Make a local array variable 
		int[] array = new int[size];
		for(int i = 0; i < array.length; i++){
			array[i] = rnd.nextInt(max - min) + min;
		}
		return array;

	}
	
	// Method to print an integer array
	public static void printArray(int[] array){
		for(int i = 0; i < array.length; i++){
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	// TODO --> DONE
	// Add the selectionSort method here !!
	public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }
	
	// TODO --> DONE
	// Add the bubbleSort method here !!
	public static void bubbleSort(int[] array){
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
  	
	public static void main(String[] args) {
		
		// Generate an array of containing random numbers between 1 - 100 inclusive
		// NOTE: the random number generator will be seeded to produce the same random 
		// array each time.
		
		// TODO --> DONE
		// Modify the calls to makeRandomArray to generate arrays of size 10,0000
        int[] sArray = makeRandomArray(10000, 1, 101, 5);    
        int[] bArray = makeRandomArray(10000, 1, 101, 5);    
        int[] aArray = makeRandomArray(10000, 1, 101, 5);
		
		// Print the arrays - before the sort
		System.out.println("Selection sort array before sorting.....");
		printArray(sArray);
		System.out.println("Bubble sort array before sorting.....");
		printArray(bArray);

		long start, end, sRuntime, bRuntime, aRuntime;

		// TODO
		// Sort the selectionArray array using selectionSort and calculate the runtime
        start = System.nanoTime();
        selectionSort(sArray);
        end = System.nanoTime();
        sRuntime = end - start;
		
		// TODO
		// Sort the bubbleArray array using bubbleSort and calclate the runtime
		start = System.nanoTime();
        bubbleSort(bArray);
        end = System.nanoTime();
        bRuntime = end - start;
		
		// TODO
		// Print arrays to confirm they are sorted
		start = System.nanoTime();
        Arrays.sort(aArray);
        end = System.nanoTime();
        aRuntime = end - start;
		
		// TODO
		// Print the runtimes for each sprting algo
        System.out.println("Runtimes:\nSelectionSort: " + sRuntime + "ns\nBubbleSort: " + bRuntime + "ns\nArrays.sort(): " + aRuntime + "ns");
	}
}
