package ua.com.zhuravel.main.factory;

import ua.com.zhuravel.main.entity.BrainFuckLanguage;
import ua.com.zhuravel.main.entity.Language;

public class BrainFuckFactory implements LanguageFactory {

    @Override
    public Language createObject() {
        return new BrainFuckLanguage();
    }
}
