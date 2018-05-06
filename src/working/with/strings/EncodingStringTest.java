package working.with.strings;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class EncodingStringTest {

	@Test
	void testEncode() {

		assertEquals("s1d2", EncodingString.encode("sdd"));
		assertEquals("a2b2c2", EncodingString.encode("aabbcc"));
		assertEquals("a3", EncodingString.encode("aaa"));
		assertEquals("a2b2a2", EncodingString.encode("aabbaa"));
		assertEquals(null, EncodingString.encode(null));
		assertEquals("", EncodingString.encode(""));
		
		
		//assertEquals("d45", EncodingString.encodeWithMap("ddddddddddddddddddddddddddddddddddddddddddddd"));
		//assertEquals("a2b3c2", EncodingString.encodeWithMap("aabbbcc"));
		//assertEquals("a2b2c2s1d5f1r131", EncodingString.encodeWithMap("aabbccsdfr3dddd"));

	}
}
