import java.util.Scanner;
class Operation{
    // Method that use to append a string in the given string.
    public String append(String currentString){
        Scanner userInput = new Scanner(System.in);
        String string = "";
        while(true){
            System.out.print("Enter a string(if don't append then single sapce) : ");
            string = userInput.nextLine();
            if(string.equals(" ")) break;
            currentString = currentString + string;
            System.out.println("New string is : " + (currentString));
        }
        return currentString;
    }

    // Method that is use to replace the string by given string.
    public String replace(String string){
        Scanner userInput = new Scanner(System.in);

        System.out.print("Enter a string which is to be replace : ");
        String replacingString = userInput.nextLine();
    
        System.out.print("Enter a string by which replacing : ");
        String newString = userInput.nextLine();
        String newString1 = string.replace(replacingString, newString);
        
        return newString1;
    }

    // Method that is use to sort the given string.
    public String sort(String string){
        char character[] = new char[string.length()];
        for(int i=0; i<string.length(); i++){
            character[i] = string.charAt(i);
        }
        boolean flag = true;
        for(int i=0; i<character.length-1; i++){
            for(int j=i+1; j<character.length; j++){
                if(character[j] < character[i]){
                    char temp = character[i];
                    character[i] = character[j];
                    character[j] = temp;
                    flag = false;
                }
            }
            if(flag == true) break;
        }
    String newString = "";
        for(int i=0; i<character.length; i++){
            newString += character[i];
        }
    return newString;    
    }

    // Method that is use to reverse the given string.
    public String reverse(String string){
        String newString = "";
        for(int i=string.length()-1; i>=0; i--){
            newString += string.charAt(i);
        }
        return newString;
    }
}

public class StringOperation{
    public static void main(String args[]){
        Scanner userInput = new Scanner(System.in);
        String newString = " ";
        try{
            int operation = -1;
            while(operation != 0){
                System.out.print("Enter a string (if don't perform operation then single space) : ");
                String string = userInput.nextLine();
                if(string.equals(" ")) break;
                Operation object1 = new Operation();    // object creation to perform operation.
                String txt = """
                            0. If not perform any kind of operation.
                            1. Append in the string.
                            2. Replacing the character in the string.
                            3. Sort the string.
                            4. Reverse the string.
                            """;
                System.out.print(txt);
                System.out.print("Enter a operation : ");
                operation = userInput.nextInt();
                userInput.nextLine();
                switch(operation){
                    case 0 : break;
                    case 1 : newString = object1.append(string);
                            break;
                    case 2 : newString = object1.replace(string);
                            break;
                    case 3 : newString = object1.sort(string);
                            break;
                    case 4 : newString = object1.reverse(string);
                            break;
                    default : System.out.println("Enter invalid operation.");
                }
                if(operation != 0)
                System.out.println("Resultant string is : " + newString);
            }
        }
        catch(Exception e){
            System.out.print("Invalid input.");
        }
        finally{
            userInput.close();
        }
    }
}