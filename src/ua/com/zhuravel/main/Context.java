package ua.com.zhuravel.main;

import ua.com.zhuravel.main.entity.Language;

/**
 * Works with Languages by the common interface
 *
 * @author ZhuravelArtem
 *
 */
public class Context {

	private Language language;

	public Context() {}

	public Context(Language language) {
		this.setLanguage(language);
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Object executeLanguage() {
		return language.compile();
	}
}
