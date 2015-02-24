<script language="javascript" type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
 <script  language="javascript" type="text/javascript"  src="../js/jquery.min.js"></script> 
<style> 
 label {
    width:180px;
    clear:left;
    text-align:right;
    font-size:14pt;
    font-family:sans-serif;
    padding-right:10px;
}

p{
	 width:180px;
    clear:left;
    text-align:right;
    font-size:14pt;
    font-family:sans-serif;
    padding-right:10px;
}
</style>

<form name="para_form" action="./mn" target="_balnk">
<label for="para"> Enter the Text Here :</label>

<input type="text" name="data" id="data" class="p" placeholder="Write some thing"/>
<input type="submit" value="Analyze" class="submitbutton" />

</form>

<%if(request.getParameter("data") !=null){ %>
<br>
<p>Num of Sentences : <%=request.getAttribute("noOfSentences")  %></p>
<p>Number of Words : <%=request.getAttribute("noOfwords") %></p>
<p>Names : <%=request.getAttribute("names") %></p>
<%} %>