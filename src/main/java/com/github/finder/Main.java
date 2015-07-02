package com.github.finder;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

public class Main{
	public Main(String[] arguments){
		Args args = parseArguments(arguments);

        Finder finder = new Finder(args);
        for(String base: args){
            String[] items = finder.find(base);
            for(String item: items){
                System.out.println(item);
            }
        }
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
