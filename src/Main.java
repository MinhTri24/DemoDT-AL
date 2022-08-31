import java.io.IOException;
import java.util.Scanner;


public class Main {
    static Stack<String> stack = new Stack<>();
    static Queue2<String> queue = new Queue2<>();
    static String[] messages;

    private static void enterMessages(){
        System.out.print("Enter messages: ");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        messages = input.split(",");
    }

    private static void transfer(){
        //long startTime1 = System.currentTimeMillis();
        try {
            for(int i = 0; i < messages.length; i++){
                if(messages[i].equals(" ")){
                    throw new IOException();
                }else if(messages[i].length() > 250){
                    throw new ArrayIndexOutOfBoundsException("The message characters must be " +
                            "less than 250 character!!! Please retype");
                } else {
                    queue.offer(messages[i]);
                    System.out.println("Transferring " + messages[i] + " ...");
                }
            }
        } catch (IndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.out.println(arrayIndexOutOfBoundsException.getMessage());
        } catch (IOException exception){
            System.out.println("You haven't typed anything yet!!! Please retype");
        }
        //long endTime1 = System.currentTimeMillis();
        //System.out.println("Time " + (endTime1 - startTime1) + "ms");
    }

    private static void process(){
        //long startTime2 = System.currentTimeMillis();
        while (!queue.isEmpty()){
            stack.push(queue.poll());
            System.out.println("Message has been sent successfully!!!");
        }
        //long endTime2 = System.currentTimeMillis();
        //System.out.println("Time " + (endTime2 - startTime2) + "ms");
    }

    private static void result(){
        //long startTime3 = System.currentTimeMillis();
        while (!stack.isEmpty()){
            System.out.println("Message receive: " + stack.pop());
        }
        //long endTime3 = System.currentTimeMillis();
        //System.out.println("Time " + (endTime3 - startTime3) + "ms");
    }

    public static void main(String[] args){
        enterMessages();
        long startTime = System.currentTimeMillis();
        transfer();
        process();
        result();
        long endTime = System.currentTimeMillis();
        System.out.println("The system took " + (endTime - startTime) + "ms to run...");
    }

    public static int multiplyEvens(int x){
        if (x <= 0){
            throw new IllegalArgumentException();
        } else if (x == 1) {
            return 2;
        } else {
            return 2 * x * multiplyEvens(x - 1);
        }
    }

    public static void writeChars(int x){
        if (x < 1){
            throw new IllegalArgumentException();
        } else if (x == 1) {
            System.out.print("*");
        } else if (x == 2) {
            System.out.print("**");
        } else {
            System.out.print("<");
            writeChars(x - 2);
            System.out.print(">");
        }
    }

    public static void writeSquares(int x){
        if (x < 1){
            throw new IllegalArgumentException();
        } else if (x == 1) {
            System.out.println("1, ");
        }else {
            if (x % 2 != 0){
                System.out.print(x * x + ", ");
            }
            writeSquares(x - 1);
            if (x % 2 == 0){
                System.out.print(", " + x * x);
            }
        }
    }
    public static void writeSequence(int x){
        if (x < 1) {
            throw new IllegalArgumentException();
        } else if (x == 1) {
            System.out.print("1 ");
        } else {
            System.out.print((x + 1) / 2 + " ");
            if (x != 2) {
                writeSequence(x - 2);
            }
            System.out.print((x + 1) / 2 + " ");
        }
    }
    public static String starString(int x) {
        if (x < 0) {
            throw new IllegalArgumentException("abc");
        } else if (x == 0) {
            return "*";
        } else {
            return starString(x - 1) + starString(x - 1);
        }
    }
    public static String writeNums(int x){
        if (x == 1){
            return "1";
        } else if (x < 1) {
            throw new IllegalArgumentException("abc");
        }else {
            return writeNums(x - 1) + ", " + x;
        }
    }
    public static void writeNum(int x){
        if (x == 1){
            System.out.print(1);
        } else if (x > 1) {
            writeNum(x - 1);
            System.out.print(", " + x);
        }else {
            throw new IllegalArgumentException("abc");
        }
    }
    
}

