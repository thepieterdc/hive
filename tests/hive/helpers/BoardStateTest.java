package hive.helpers;

import hive.TransferPiece;
import hive.data.Orientation;
import hive.exceptions.UnmarshalException;
import hive.helpers.moves.StartMove;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Tests for hive.helpers.BoardState.
 * <p>
 * Created at 27/03/16 22:37
 *
 * @author <a href="mailto:pieterdeclercq@outlook.com">Pieter De Clercq</a>
 */
public class BoardStateTest {

	/**
	 * Tests the entire BoardState class; due to the complex structure of this class everything had to be tested at once.
	 *
	 * @throws Exception
	 */
	@Test
	public void testBoardState() throws Exception {
		//Test BoardState#unmarshal().
		Map<Integer, BoardState> onlyStart = BoardState.unmarshal(Collections.singletonList(new StartMove()));
		Map<Integer, BoardState> threeMoves = BoardState.unmarshal(Arrays.asList(new StartMove(), Move.fromRepresentation("wQ"), Move.fromRepresentation("bA1 wQ-")));

		//Test BoardState#coordinates().
		HexCoordinate center = new HexCoordinate(0, 0);
		assertTrue(onlyStart.get(0).freeHexagons().size() == 1 && onlyStart.get(0).freeHexagons().contains(center));
		assertTrue(threeMoves.get(0).freeHexagons().size() == 1 && threeMoves.get(0).freeHexagons().contains(center));
		assertTrue(threeMoves.get(1).freeHexagons().size() == 6 && threeMoves.get(1).units().size() == 1);
		Collection<HexCoordinate> surrounds = new ArrayList<>(7);
		surrounds.add(center);
		for (Orientation o : Orientation.values()) {
			surrounds.add(HexCoordinate.fromOrientation(center, o));
		}
		surrounds.forEach(h -> assertTrue(threeMoves.get(1).freeHexagons().contains(h)));


		//Test BoardState#toString().
		assertEquals("BoardState[hexagons=1, units=0]", onlyStart.get(0).toString());
		assertEquals("BoardState[hexagons=1, units=0]", threeMoves.get(0).toString());
		assertEquals("BoardState[hexagons=7, units=1]", threeMoves.get(1).toString());
		assertEquals("BoardState[hexagons=10, units=2]", threeMoves.get(2).toString());

		//Test BoardState#transferPieces().
		assertTrue(onlyStart.get(0).transferPieces().isEmpty());
		assertTrue(threeMoves.get(0).transferPieces().isEmpty());
		assertTrue(threeMoves.get(1).transferPieces().size() == 1 && threeMoves.get(1).transferPieces().get(0).toString().equals(new TransferPiece('Q', 'w', 1, 0, 0).toString()));
	}

	/**
	 * Tests BoardState#unmarshal() with invalid parameter: moves (null).
	 *
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testUnmarshalMovesNull() throws Exception {
		BoardState.unmarshal(null);
	}

	/**
	 * Tests BoardState#unmarshal() with invalid parameter: moves (empty).
	 *
	 * @throws Exception
	 */
	@Test(expected = UnmarshalException.class)
	public void testUnmarshalMovesEmpty() throws Exception {
		BoardState.unmarshal(new ArrayList<>(0));
	}

	/**
	 * Tests BoardState#unmarshal() with invalid parameter: move 0 is not instance of StartMove.
	 *
	 * @throws Exception
	 */
	@Test(expected = UnmarshalException.class)
	public void testUnmarshalIllegalFirstMove() throws Exception {
		BoardState.unmarshal(Collections.singletonList(Move.fromRepresentation("bQ")));
	}

	/**
	 * Tests BoardState#unmarshal() with invalid parameter: move 1 is not instance of FirstMove.
	 *
	 * @throws Exception
	 */
	@Test(expected = UnmarshalException.class)
	public void testUnmarshalIllegalSecondMove() throws Exception {
		BoardState.unmarshal(Arrays.asList(new StartMove(), new StartMove()));
	}

	/**
	 * Tests BoardState#unmarshal() with invalid parameter: unit not found on the board.
	 *
	 * @throws Exception
	 */
	@Test(expected = UnmarshalException.class)
	public void testUnmarshalIllegalUnit() throws Exception {
		BoardState.unmarshal(Arrays.asList(new StartMove(), Move.fromRepresentation("bQ"), Move.fromRepresentation("bA1 wQ-")));
	}
}