package org.mn;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

public class Sentenses {
	public  String[] getSentences(String paragraph) throws IOException{
		ClassLoader classLoader = getClass().getClassLoader();
		InputStream bin=new FileInputStream(classLoader.getResource("en-sent.bin").getFile());
		SentenceModel sm= new SentenceModel(bin);
		SentenceDetectorME st= new SentenceDetectorME(sm);
		String[] sentences= st.sentDetect(paragraph);
		return sentences;
	}

}
