package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fmi.uni.Parsers.CommandParser;

public class CommandParserTests {

	@Test
	public void parseCommandTest() {
		assertTrue("return value should be winrate", CommandParser.parseCommand("winrate").equals("winrate"));
	}
	
	@Test
	public void parseCommandTest7() {
		assertTrue("return value should be winrate last", CommandParser.parseCommand("winrate last 100").equals("winrate last"));
	}
	
	@Test
	public void parseCommandTest3() {
		assertTrue("return value should be totals", CommandParser.parseCommand("totals").equals("totals"));
	}
	
	//Mistakes in all of these, should be null
	@Test
	public void parseCommandTest2() {
		assertTrue("return value should be null", CommandParser.parseCommand("totals asd") == null);	
	}
	
	@Test
	public void parseCommandTest4() {
		assertTrue("return value should be null", CommandParser.parseCommand("winrate lastt 10") == null);
	}

	@Test
	public void parseCommandTest5() {
		assertTrue("return value should be null", CommandParser.parseCommand("winrate last 10 a") == null);
	}
	
	@Test
	public void parseCommandTest6() {
		assertTrue("return value should be null", CommandParser.parseCommand("winrate last 10 5") == null);
	}
	
	@Test
	public void parseCommandTest8() {
		assertTrue("return value should be null", CommandParser.parseCommand("winrate next 10") == null);
	}
	
	@Test
	public void parseCommandTest9() {
		assertTrue("return value should be null", CommandParser.parseCommand("winrite last 10") == null);
	}
}
