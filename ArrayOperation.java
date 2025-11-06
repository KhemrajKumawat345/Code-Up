import java.util.Scanner;
public class ArrayOperation{

    // Efficient Traveler with the given energy.
    public static int toVisit(int city[], int energy){
        int count = 0;
        for(int i=1; i<city.length; i++){
            city[i] += city[i-1];
        }
        for(int i=0; i<city.length; i++){
            if(city[i] < energy) count++;
        }
        return count;
    }

    // Index where prefix and suffix sum are equal.
    public static int equalSum(int array[]){
        // prefix of array.
        for(int i=1; i<array.length; i++){
            array[i] += array[i-1];
        }
        // sum of this array.
        int total = array[array.length-1];
        int index = -1;
        int suffSum = 0;
        // find the index where prefix and suffix sum are equal.
        for(int i=0; i<array.length; i++){
            if(i == 0) suffSum = total;
            else suffSum = total - array[i-1];
            if(array[i] == suffSum){
                index = i;
            }
        }
        return index;
    }

    // Minimum no. of flips to make all elements same.
    public static int flips(int array[]){
        // check element should be only 0 or 1.
        for(int i=0; i<array.length; i++){
            if(array[i] != 0 || array[i] != 1) return -1;
        }
        // find the sum of array.
        int sum = 0;
        for(int i=0; i<array.length; i++){
            sum += array[i];
        }
        int difference = array.length - sum;
        int ans;
        if(sum > difference) ans = difference;
        else ans = sum;
        return ans;
    }

    // Sum is present in array or not.
    public static boolean targetSum(int array[], int target){
        // check target present or not.
        boolean flag = false;
        for(int i=0; i<array.length; i++){
            for(int j=i+1; j<array.length; i++){
                if((array[i] + array[j]) == target){
                    flag = true;
                    break;
                }
                if(flag == true) break;
            }
        }
        return flag;
    }

    // Unique element in array
    public static int unique(int array[]){
        // Check unique element
        boolean flag = true;
        for(int i=0; i<array.length; i++){
            flag = true;
            for(int j=0; j<array.length; j++){
                if(i != j && array[i] == array[j]){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                return array[i];
            }
        }
        return 0;
    }

    // Reduce the painting time by remove the maximum size wall.
    public static int reducingWall(int array[]){
        // calculate total time to paint the walls and maximum size wall.
        int time = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<array.length; i++){
            time += array[i];
            if(array[i] > max) max = array[i];
        }
        time -= max;    // remove maximum size wall.
        return time;
    }

    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        ArrayOperation object = new ArrayOperation();
        String text = """   
                            0. If not perform any operation.
                            1. Find the no. of city visited by the given energy.
                            2. Find index where prefix and suffix sum are equal.
                            3. Minimum no. of flips to make all elements same.
                            4. Find the sum is present in array or not.
                            5. Find the unique element in array.
                            6. Find the maximum size wall to reduce the painting time.""";
        System.out.println(text);
        int operation = 1;
        int result;
        boolean flag;
        try{
            while(operation != 0){
                System.out.print("Enter a operation : ");
                operation = userInput.nextInt();
                if(operation == 0) return;

                System.out.print("Enter a size of array : ");
                int size = userInput.nextInt();
                int array[] = new int[size];

                // input the element of array.
                for(int i=0; i<array.length; i++){
                    System.out.print("Enter " + (i+1) + " element : ");
                    array[i] = userInput.nextInt();
                }

                // perform operation.
                switch(operation){
                    case 1 : System.out.print("Enter a energy : ");
                             int energy = userInput.nextInt();
                             result = object.toVisit(array, energy);
                             System.out.println("Visited city : " + result);
                             break;
                    case 2 : result = equalSum(array);
                             System.out.println("At index " + result + " prefix and suffix sum are equal");
                             break;
                    case 3 : result = flips(array);
                             if(result == -1) System.out.println("Invalid input");
                             else System.out.println(result + " flips are required to make all elements same.");
                             break;
                    case 4 : System.out.print("Enter a target value : ");
                             int target = userInput.nextInt();
                             flag = targetSum(array, target);
                             System.out.println("Is target present : " + flag);
                             break;
                    case 5 : result = unique(array);
                             if(result == 0) System.out.println("There is no unique element in array.");
                             else System.out.println(result + " is a unique element.");
                             break;
                    case 6 : result = reducingWall(array);
                             System.out.println("Minimum time : " + result);
                             break;
                    default : System.out.println("Invalid input");
                }
            }
        }
        catch(Exception e){
            System.out.println("Invalid input");
        }
    }
}