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
        final String code = "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
        final Language lang = new BrainFuckLanguage(code);
        lang.languageImpl();
    }
}