package hive.helpers.messages;

import hive.JavaFXThreadingRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

/**
 * Tests for hive.helpers.messages.ErrorMessageTest.
 * <p>
 * Created at 27/03/16 14:01
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ErrorMessageTest {
	@Rule
	public final JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	private ErrorMessage msg;

	/**
	 * Set-up the test environment.
	 *
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.msg = new ErrorMessage("Test");
	}

	/**
	 * Tear-down the test environment.
	 *
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.msg = null;
	}

	/**
	 * Tests Message#render().
	 *
	 * @throws Exception
	 */
	@Test
	public void testRender() throws Exception {
		this.msg.render();
	}
}