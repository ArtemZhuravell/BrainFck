package ua.com.zhuravel.main.entity;

/**
 * We consider that there are some custom languages.
 * This interface describes standard behaviour
 */
public interface Language {

    /**
     * Implementation of the custom language
     */
    char[] compile();

    /**
     * A code of a language
     *
     * @param code  new code
     */
    void setCode(String code);
}
