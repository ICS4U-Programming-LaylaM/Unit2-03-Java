import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
* This program generates 250 random numbers in an array
* and allows the user to search the array for a number.
*
* @author Layla Michel
* @version 1.0
* @since 2022-04-05
*/

class RecBinarySearch {
    /**
    * The min number for array.
    */
    public static final int MIN = 0;
    /**
    * The max number for array.
    */
    public static final int MAX = 999;
    /**
    * The number of elements in the array.
    */
    public static final int ARRAY_SIZE = 250;

    /**
    * Default empty constructor.
    */
    RecBinarySearch() { }

    /**
    * Creating function to find the index of a number,
    * using Binary Search recursively.
    *
    * @param userArray as array
    * @param userNumber as int
    * @param low as int
    * @param high as int
    *
    * @return index as int
    */
    public int binary(int[] userArray, int userNumber, int low, int high) {
        // Get the middle index of the array
        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        }

        // Check if the userNumber is at the middle
        if (userArray[mid] == userNumber) {
            return mid;
        // Check if the userNumber is lower than the number at the middle
        } else if (userArray[mid] > userNumber) {
            return binary(userArray, userNumber, low, mid - 1);
        // Check if the userNumber is greater than the number at the middle
        } else if (userArray[mid] < userNumber) {
            return binary(userArray, userNumber, mid + 1, high);
        }

        return -1;
    }

    /**
    * Creating main function.
    *
    * @param args nothing passed in
    */
    public static void main(final String[] args) {
        // Declaring variables
        Scanner myObj;
        int counter;
        String numberString;
        int searchNum;
        int searchResult;

        myObj = new Scanner(System.in);

        // Create a binary search object
        RecBinarySearch binarySearch = new RecBinarySearch();

        // Initializing the random class
        Random randNumber = new Random();

        // Initializing array of numbers
        int[] randomNumberArray = new int[ARRAY_SIZE];

        // Adding numbers to the array
        for (counter = 0; counter < randomNumberArray.length; counter++) {
            randomNumberArray[counter] = randNumber.nextInt(MAX) + 1;
        }

        // Sorting the array
        int[] numberArray = randomNumberArray;
        Arrays.sort(numberArray);

        System.out.println(Arrays.toString(numberArray));
        System.out.println("\n");

        // System.out.print("\nSorted list of numbers:\n");
        // for (int element: numberArray) {
        //     String padded = String.format("%03d", element);
        //     System.out.print(padded + ", ");
        // }
        // System.out.print("\n\n");

        // Getting user input as to what number they wish to search for
        while (true) {
            System.out.print("What number are you searching for "
                + "in the array (integer between 0 and 999): ");
            numberString = myObj.nextLine();
            try {
                searchNum = Integer.parseInt(numberString);

                // Ensuring the user inputs an appropriate integer
                if (searchNum > MAX || searchNum < MIN) {
                    System.out.println("The number must be between "
                        + MIN + " and " + MAX + ".\n");
                } else {
                    // Using binary search to find the user's
                    // chosen number in the array
                    searchResult = binarySearch.binary(numberArray, searchNum,
                        0, numberArray.length - 1);

                    if (searchResult == -1) {
                        System.out.println("\n" + searchNum
                            + " is not in the list.");
                        break;
                    } else {
                        // Outputting the results of the search
                        System.out.println("\n" + searchNum
                            + " is on index: " + searchResult + ".");
                        break;
                    }
                }
            } catch (NumberFormatException ex) {
                // Error message if input isn't a number
                System.out.println("Please enter a valid number.\n");
            }
        }
        myObj.close();
    }
}
