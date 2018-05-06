package working.with.files;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IPSExaminatorTest {

	@Test
	void testCountLinesByIP() {

		String[] arr = {

				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP", "sdfadsf", null, null, null, null, null, null,
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "",
				"", "10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP"

		};

		assertEquals("10.0.0.3-23", IPSExaminator.countLinesByIP(arr));

		String[] arr1 = {

				"10.0.0.1 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.3 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP",
				"10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP" };

		assertEquals("10.0.0.1-1", IPSExaminator.countLinesByIP(arr1));

		String[] arr2 = { "10.0.0.2 - Thursday 22 Deb 2018 GET XXX ACCEPT OK HTTP" };

		assertEquals("10.0.0.2-1", IPSExaminator.countLinesByIP(arr2));

		assertEquals(null, IPSExaminator.countLinesByIP(null));

		String[] arr3 = { "" };

		assertEquals(null, IPSExaminator.countLinesByIP(arr3));
	}

}
