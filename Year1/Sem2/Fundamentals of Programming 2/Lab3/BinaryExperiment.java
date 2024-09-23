public class BinaryExperiment{
	// Sort data set
	static final int[] data = {0,1,2,6,8,9,15,17,18,25,26,29,30,32,33,36,38,43,44,45,55,56,59,60,61,62,
	                           63,64,65,77,84,85,86,90,94,96,100,103,104,108,109,112,114,122,123,124,
	                           128,130,131,141,147,154,155,164,166,169,170,174,175,178,180,185,187,
	                           190,194,196,206,209,210,211,214,218,222,225,228,235,240,241,244,245,
	                           248,250,252,253,255,258,259,260,267,268,270,276,278,279,280,284,286,
	                           289,292,302,326,332,336,338,348,359,365,367,368,371,373,376,377,378,
	                           379,382,386,387,392,405,407,409,414,415,419,426,428,431,433,434,438,
	                           439,443,444,447,448,455,457,459,460,468,469,477,479,480,481,486,487,
	                           489,492,495,498,499,501,505,506,510,511,513,521,531,532,533,537,538,
	                    	   539,543,545,547,548,554,559,561,563,564,566,577,580,581,589,592,594,
	                    	   595,597,599,600,604,605,609,614,617,618,621,623,624,625,627,632,634,
	                    	   636,641,642,644,645,646,649,650,652,654,659,661,663,671,672,674,677,
	                           680,682,683,688,689,692,694,696,700,703,705,706,707,708,714,716,718,
	                           725,730,732,734,737,740,741,742,752,754,755,757,760,762,763,764,765};

	// Method to calculate log of N to base 2
	// Average number of steps taken
	// by binary search should be O(log2(N))
	public static double log2(int N){
        double result = (Math.log(N) / Math.log(2));
        return result;
    }

	// This static method uses a binary search to 
	// search for a key value in an integer array.
	// The search algorithm keeps track of the 
	// number of loop steps taken and the index
	// of the key if found.
	// If the key is not found, a value of -1 is returned
	// along with the number of steps.
	// The return value takes the form of an integer array
	// of size 2 where the first value is the index and the 
	// second value is the number of loop steps taken
	public static int[] binarySearch(int[] array, int k){
		// Set the initial high and low
		int low = 1;
		int high = array.length - 1;
		// Loop until low > high
        int steps = 0;
        int[] result = new int[2];
		while(low <= high){
			// Increment the number of loop steps
			steps++;
			// Calculate the midway index
			int mid = (low + high) / 2;
            if (k > array[mid])
				// k in the upper part
				low = mid + 1;
			else if (k < array[mid])
				// k in the lower part
				high = mid - 1;
			else if (k == array[mid]){
				// We found k
				// Fill the results array and return it
				result[0] = mid; result[1] = steps;
				return result;
			}
		}
        // We have not found k
        // Fill the results array and return it
        result[0] = -1; result[1] = steps;
		return result;
	}

	public static void main(String[] args) {
		int totalSteps = 0;
	    int N = 1000; // Number of times to run the search trial

	    for (int i = 0; i < N; i++) {
	        int k = (int) (Math.random() * (data[data.length - 1] - data[0] + 1) + data[0]);
	        int[] result = binarySearch(data, k);
	        totalSteps += result[1]; // Add the number of steps for this trial
	    }

	    double averageSteps = (double) totalSteps / N; // Calculate the average steps taken by search

    	// Print the average number of steps taken
	    System.out.printf("Average steps taken: %.2f, expected O(log2(N)) = %.2f\n", averageSteps, log2(data.length));
	}
}