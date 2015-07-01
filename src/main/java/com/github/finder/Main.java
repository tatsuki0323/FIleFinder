package com.github.finder;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main{
	public Main(String[] arguments){
	}
	
	public static void main(String[] args){
		new Main(args);
	}
	
	private Args parseArguments(String[] arguments){
		Args args = new Args();
		try {
			CmdLineParser parser = new CmdLineParser(args);
			parser.parseArgument(arguments);
		} catch (CmdLineException e) {
		}
		return args;
	}
}
