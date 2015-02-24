package org.mn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.uima.tokenize.Tokenizer;

public class Tokens {
	public String[] getTokens(String paragraph) throws IOException{
		ClassLoader classLoader = getClass().getClassLoader();
		TokenizerModel tm=new TokenizerModel(new FileInputStream(classLoader.getResource("en-token.bin").getFile()));
		TokenizerME t=new TokenizerME(tm);
		String[] tokens=t.tokenize(paragraph);
		return tokens;
	}
}
