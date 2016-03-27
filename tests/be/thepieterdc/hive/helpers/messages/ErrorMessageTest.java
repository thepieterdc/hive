package be.thepieterdc.hive.helpers.messages;

import be.thepieterdc.hive.JavaFXThreadingRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Description here
 * <p>
 * Created at 27/03/16 14:01
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class ErrorMessageTest {
	@Rule
	public final JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();

	private ErrorMessage msg;

	@Before
	public void setUp() throws Exception {
		this.msg = new ErrorMessage("Test");
	}

	@After
	public void tearDown() throws Exception {
		this.msg = null;
	}

	/**
	 * Tests Message#shutdown().
	 *
	 * @throws Exception
	 */
	@Test
	public void testShutdown() throws Exception {
		assertTrue(this.msg.shutDown());
	}
}