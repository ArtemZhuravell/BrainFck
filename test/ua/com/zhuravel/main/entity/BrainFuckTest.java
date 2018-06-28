package ua.com.zhuravel.main.entity;

import org.junit.Assert;
import org.junit.Test;

public class BrainFuckTest {

	@Test
	public void testLanguageImpl() {
		final String code = "++++++++[>++++[>++>+++>+++>+<<<<-]"
				+ ">+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++."
				+ "------.--------.>>+.>++.";
        final Language lang = new BrainFuckLanguage(code);
        final String actual = lang.languageImpl();
        System.out.println("1 - " + actual);
		Assert.assertEquals("Hello World!", actual);
	}

}
