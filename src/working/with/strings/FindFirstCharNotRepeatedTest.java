package working.with.strings;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class FindFirstCharNotRepeatedTest {

	@Test
	void testTest1() {
		assertEquals('z', FindFirstCharNotRepeated.test1("zaabbccddeefg"));
		assertEquals('0', FindFirstCharNotRepeated.test1("aabbcc"));
		assertEquals('a', FindFirstCharNotRepeated.test1("asdfasdfas"));
		assertEquals('0', FindFirstCharNotRepeated.test1("ggtttttttttttttyy")); 
		assertEquals('d', FindFirstCharNotRepeated.test1("ggtttttttttttttyyd")); 
		assertEquals('a', FindFirstCharNotRepeated.test1("adf")); 
	}

}

