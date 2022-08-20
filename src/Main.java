import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    MyStack processStack = new MyStack(100);
    MyQueue transferQueue = new MyQueue();

    public void menu(){
        String choice = "";
        while (!"0".equals(choice)){
            Scanner sc = new Scanner(System.in);

            System.out.println("1. Send Messages");
            System.out.println("2. Show All Messages");
            System.out.println("0. Exit");

            System.out.println("====Please input choice====");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    transfer();
                    break;
                case "2":
                    process();
                    break;
                case "0":
                    System.exit(0);
            }
        }
    }

    private void transfer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Transfering ....");
        String messages;

        do {
            messages = sc.nextLine();
            if (!messages.equals("finish")){
                transferQueue.enQueue(messages);
            }
        }while (!messages.equals("finish"));

        while (!transferQueue.isEmpty()){
            try {
                String x = transferQueue.deQueue();
                processStack.push(x);
                System.out.println("messages: " + x + " ");
            }catch (Exception exception){
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, exception);
            }
        }
    }

    private void process(){
        System.out.println("Processing");
        while (!processStack.isEmpty()){
            try {
                System.out.println("Messages " + processStack.pop());
            }catch (Exception exception){

            }
        }
    }

    public static void main(String[] args) {
//        multiplyEvens(1);
        Main main = new Main();
        main.menu();
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

