package ua.com.zhuravel.main.entity;

import java.util.Deque;
import java.util.LinkedList;

/**
 * {@code BrainFuck} language implementation
 */
public final class BrainFuckLanguage implements Language {

    private char[] array = { 0, 0, 0, 0, 0, 0, 0};

    /**
     * A code which has to be compiled
     */
    private String code = new String("");

    /**
     * A pointer
     */
    private int count = 0;

    /**
     * A collection contains the indexes of open brackets
     */
    private Deque<Integer> indexesOfOpenBracket = new LinkedList<>();

    /**
     * Default constructor
     */
    public BrainFuckLanguage(){}

    /**
     * {@code BrainFuck} compiler realization
     */
    @Override
    public final char[] compile() {
    		String result = "";
    		char[] res = null;
    		int countOfCharacters = 0;
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
                    result += String.valueOf(point());
                    countOfCharacters++;
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
                    return new char[0];
            }
        }
        //a copy loop for test
        res = new char[countOfCharacters];
        for(int i = 0; i < result.length(); i++) {
        		res[i] = result.charAt(i);
        }
        return res;
    }

    /**
     * Getter
     *
     * @return  an array which represents a memory domain
     */
    public char[] getArray() {
        char[] getArray = new char[array.length];
        for(int i = 0; i < getArray.length; i++) {
            getArray[i] = array[i];
        }
        return getArray;
    }

    /**
     * Setter
     *
     * @param code  a new code
     */
    @Override
    public void setCode(String code) {
        this.code = code;
    }

    /* Command of the BrainFuck language */

    private final void more() { count++; }

    private final void less() { count--; }

    private final void plus() { array[count]++; }

    private final void minus() { array[count]--; }

    private final char point() {
    		System.out.print(array[count]);
    		return array[count];
    	}

    private final void openBracket(int i) { indexesOfOpenBracket.addLast(i); }

    private final void closeBracket() { indexesOfOpenBracket.removeLast(); }

    private final boolean checkIfZero() { return array[count] == 0 ? true : false; }
}
