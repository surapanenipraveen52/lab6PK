package org.mn;

import java.io.FileInputStream;
import java.io.IOException;

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.Span;

public class Names {
	public Span[] getPersonNames(String paragraph, String binName) throws IOException{
		String[] tokens=new Tokens().getTokens(paragraph);
		TokenNameFinderModel model=new TokenNameFinderModel(new FileInputStream(binName));
		NameFinderME nmf=new NameFinderME(model);
		Span[] namespSpans=nmf.find(tokens);
		return namespSpans;
	}
}
