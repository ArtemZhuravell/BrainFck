package ua.com.zhuravel.main;

import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static char[] array = { 0, 0, 0, 0, 0, 0, 0};

    /**
     A pointer
     */
    public static int count = 0;

    /**
     * A collection contains the indexes of open brackets
     */
    public static Deque<Integer> indexesOfOpenBracket = new LinkedList<>();

    public static void main(String[] args) {
        String code = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        brainFuck(code);
    }

    /**
     * "Brainfuck" task implementation
     *
     * @param code  a code which has to be executed
     */
    public static void brainFuck(String code) {

        //  We're iterating trough the commands and executing them
        for(int i = 0; i < code.length(); i++) {
            switch (code.charAt(i)) {
                case '>':
                    more();
                    break;
                case '<':
                    less();
                    break;
                case '+':
                    plus();
                    break;
                case '-':
                    minus();
                    break;
                case '.':
                    point();
                    break;
                case '[':
                    //  while we're starting a loop we should be convinced
                    //  that a number is not a zero otherwise we skipping
                    //  a loop
                    if(checkIfZero()) {
                        int tempoBracket = 1;
                        while(tempoBracket != 0) {
                            i++;
                            //  after skipping all nested loops we have to
                            //  get to the last bracket
//                            if(tempoBracket == 0) {
//                                tempoBracket++;
//                            }

                            //  during skipping a loop there is a chance of existing another loop
                            //  that is why we count a number of nested loops and skip them
                            if(code.charAt(i) == '[') {
                                tempoBracket++;
                            }
                            if(code.charAt(i) == ']') {
                                tempoBracket--;
                            }
                        }
                        break;
                    }
                    openBracket(i);
                    break;
                case ']':
                    if(checkIfZero()) {
                        closeBracket();
                        break;
                    }
                    i = indexesOfOpenBracket.getLast();
                    break;
                default:
                    break;
            }
        }
    }

    public static void more() {
        count++;
    }

    public static void less() {
        count--;
    }

    public static void plus() {
        array[count]++;
    }

    public static void minus() {
        array[count]--;
    }

    public static void point() {
        System.out.print(array[count]);
    }

    public static void openBracket(int i) {
        indexesOfOpenBracket.addLast(i);
    }

    public static void closeBracket() {
        indexesOfOpenBracket.removeLast();
    }

    public static boolean checkIfZero() {
        return array[count] == 0 ? true : false;
    }

}