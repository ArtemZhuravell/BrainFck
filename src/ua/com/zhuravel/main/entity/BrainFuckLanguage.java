package ua.com.zhuravel.main.entity;

import java.util.Deque;
import java.util.LinkedList;

/**
 * {@code BrainFuck} language implementation
 */
public final class BrainFuckLanguage extends Language {

    private char[] array = { 0, 0, 0, 0, 0, 0, 0};

    /**
     * A pointer
     */
    private int count = 0;

    /**
     * A collection contains the indexes of open brackets
     */
    private Deque<Integer> indexesOfOpenBracket = new LinkedList<>();

    /**
     * It is not allowed to create an empty instance of the class
     */
    private BrainFuckLanguage(){}

    /**
     * Constructor for field initialization
     *
     * @param code  the code of the language
     *              which has to be compiled
     */
    public BrainFuckLanguage(String code){
        super(code);
    }

    /**
     * {@code BrainFuck} compiler realisation
     */
    @Override
    public final void languageImpl() {

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
                    return;
            }
        }
    }

    /* Command of the BrainFuck language */

    private final void more() { count++; }

    private final void less() { count--; }

    private final void plus() { array[count]++; }

    private final void minus() { array[count]--; }

    private final void point() { System.out.print(array[count]); }

    private final void openBracket(int i) { indexesOfOpenBracket.addLast(i); }

    private final void closeBracket() { indexesOfOpenBracket.removeLast(); }

    private final boolean checkIfZero() { return array[count] == 0 ? true : false; }
}
