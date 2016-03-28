package hive.data;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for hive.data.Svg.
 * <p>
 * Created at 26/03/16 23:21
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class SvgTest {
	/**
	 * Tests Svg#path().
	 *
	 * @throws Exception
	 */
	@Test
	public void testPath() throws Exception {
		assertEquals("m143 1649.6v13.75q0 0.2539-0.18555 0.4395-0.18 0.2-0.43 0.2h-13.75q-0.25391 0-0.43945-0.1855-0.19-0.2-0.19-0.4v-13.75q0-0.2539 0.18555-0.4395 0.18-0.2 0.43-0.2h13.75q0.25391 0 0.43945 0.1855 0.19 0.2 0.19 0.4z", Svg.MOVEBUTTON_STOP.path().getContent());
	}

	/**
	 * Tests Svg#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Svg[path=m143 1649.6v13.75q0 0.2539-0.18555 0.4395-0.18 0.2-0.43 0.2h-13.75q-0.25391 0-0.43945-0.1855-0.19-0.2-0.19-0.4v-13.75q0-0.2539 0.18555-0.4395 0.18-0.2 0.43-0.2h13.75q0.25391 0 0.43945 0.1855 0.19 0.2 0.19 0.4z]", Svg.MOVEBUTTON_STOP.toString());
	}

}