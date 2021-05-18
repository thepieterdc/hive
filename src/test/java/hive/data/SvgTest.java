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
		assertEquals("m205.37 1665.1-12.829 7.1295q-0.22219 0.1256-0.38159 0.029-0.16 0-0.16-0.2v-14.22q0-0.2512 0.1594-0.3478 0.1594-0.097 0.38159 0.029l12.829 7.1295q0.22219 0.1256 0.22219 0.2995t-0.22219 0.2995z", Svg.MOVEBUTTON_PLAY.path().getContent());
	}

	/**
	 * Tests Svg#toString().
	 *
	 * @throws Exception
	 */
	@Test
	public void testToString() throws Exception {
		assertEquals("Svg[path=m205.37 1665.1-12.829 7.1295q-0.22219 0.1256-0.38159 0.029-0.16 0-0.16-0.2v-14.22q0-0.2512 0.1594-0.3478 0.1594-0.097 0.38159 0.029l12.829 7.1295q0.22219 0.1256 0.22219 0.2995t-0.22219 0.2995z]", Svg.MOVEBUTTON_PLAY.toString());
	}

}