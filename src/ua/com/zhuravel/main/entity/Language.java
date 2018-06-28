package ua.com.zhuravel.main.entity;

/**
 * We consider that there are some custom languages.
 * This interface describes standard behaviour
 */
public abstract class Language {

    /**
     * A code of the language
     */
    protected String code = "";

    /**
     * Default constructor
     */
    public Language(){}

    /**
     * Constructor for field initialization
     *
     * @param code  the code of the language
     *              which has to be compiled
     */
    public Language(String code) {
        this.code = code;
    }

    /**
     * Implementation of the custom language
     */
    public abstract void languageImpl();
}
