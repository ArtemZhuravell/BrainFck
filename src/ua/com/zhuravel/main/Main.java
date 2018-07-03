package ua.com.zhuravel.main;

import ua.com.zhuravel.main.entity.BrainFuckLanguage;
import ua.com.zhuravel.main.entity.Language;

/**
 * Main  class
 */
public final class Main {

    /**
     * Enter point
     *
     * @param args  unused
     */
    public static void main(String[] args) {
    		Language lang = null;
        final String code = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        lang = new BrainFuckLanguage();
        lang.setCode(code);
        lang.compile();
    }
}