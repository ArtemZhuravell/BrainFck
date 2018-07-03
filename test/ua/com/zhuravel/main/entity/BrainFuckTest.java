package ua.com.zhuravel.main.entity;

import org.junit.Assert;
import org.junit.Test;

import ua.com.zhuravel.main.Context;
import ua.com.zhuravel.main.factory.BrainFuckFactory;
import ua.com.zhuravel.main.factory.LanguageFactory;

public class BrainFuckTest {

	Language lang = null;

	private static final LanguageFactory brainFuckFactory = new BrainFuckFactory();

	@Test
	public void testLanguageImpl() {
		final String code = "++++++++[>++++[>++>+++>+++>+<<<<-]"
				+ ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++."
				+ "------.--------.>>+.>++.";
        lang = brainFuckFactory.createObject();
        lang.setCode(code);
        Context context = new Context();
        context.setLanguage(lang);
        char[] expected = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!', '\n'};
        char[] actual = (char[]) context.executeLanguage();
		Assert.assertArrayEquals(expected, actual);
	}

}
