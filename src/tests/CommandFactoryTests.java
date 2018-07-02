package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import com.fmi.uni.Commands.Command;
import com.fmi.uni.Commands.CommandFactory;
import com.fmi.uni.Commands.Totals;
import com.fmi.uni.Commands.Winrate;
import com.fmi.uni.Commands.WinrateLastNMatches;

public class CommandFactoryTests {

	@Test
	public void getCommandInstanceTest() {
		Command command = CommandFactory.getCommandInstance("winrate", 555);
		assertTrue("should be instance of Winrate", command.getClass() == Winrate.class);
	}
	
	@Test
	public void getCommandInstanceTest2() {
		Command command = CommandFactory.getCommandInstance("winrate last 555", 555);
		assertTrue("should be instance of Winrate", command.getClass() == WinrateLastNMatches.class);
	}
	
	@Test
	public void getCommandInstanceTest3() {
		Command command = CommandFactory.getCommandInstance("totals", 555);
		assertTrue("should be instance of Winrate", command.getClass() == Totals.class);
	}
	
	@Test
	public void getCommandInstanceTest4() {
		Command command = CommandFactory.getCommandInstance("total", 555);
		assertTrue("should be null", command == null);
		
	}
	
	@Test
	public void getCommandInstanceTest5() {
		Command command = CommandFactory.getCommandInstance("winratee", 555);
		assertTrue("should be null", command == null);
		
	}
	
	@Test
	public void getCommandInstanceTest6() {
		Command command = CommandFactory.getCommandInstance("winrate lasst", 555);
		assertTrue("should be null", command == null);
		
	}
	
	@Test
	public void getCommandInstanceTest7() {
		Command command = CommandFactory.getCommandInstance("winrate last", 555);
		assertTrue("should be null", command == null);
		
	}

}
