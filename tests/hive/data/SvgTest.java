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
		assertEquals("m324.29 388.08-111.81-120.64 48.57-157.14 160.38-36.509 111.8 120.64-48.57 157.14z", Svg.LOGO_HEXAGON.path().getContent());
	}

	/**
	 * Tests Svg#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Svg[path=m324.29 388.08-111.81-120.64 48.57-157.14 160.38-36.509 111.8 120.64-48.57 157.14z]", Svg.LOGO_HEXAGON.toString());
	}

}