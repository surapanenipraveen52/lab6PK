package org.mn;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import opennlp.tools.util.Span;

public class Mn extends HttpServlet {
	public void  doGet(HttpServletRequest req, HttpServletResponse resp)    throws IOException, ServletException{
		doPost(req, resp);
	}
	public void  doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String paragraph=(String) req.getParameter("data");
		String[] sentences=new Sentenses().getSentences(paragraph);
		/*for(String s :sentences)
		{
			System.out.println(s); 
		}*/
		if(null==sentences || sentences.length==0)
		{
			req.setAttribute("noOfSentences", "0");
		}else{
			req.setAttribute("noOfSentences",  sentences.length);
		}
		ClassLoader classLoader = getClass().getClassLoader();
		req.setAttribute("noOfwords", new Tokens().getTokens(paragraph).length);
		Span[] namespSpans= new Names().getPersonNames(paragraph,classLoader.getResource("en-ner-person.bin").getFile());
		System.out.println("size is "+namespSpans.length);
		if(namespSpans.length==0){
			req.setAttribute("names","No Names in the sentence");
			System.out.println("in if loop");
		}else{
			String names=" Count ="+namespSpans.length+"     ";
			for(Span s : namespSpans){
				names=names+s.toString();
			}
			req.setAttribute("names",names);
			System.out.println(req.getAttribute("names"));
		}
		req.getRequestDispatcher("home.jsp").forward(req, resp); 
	}

}
