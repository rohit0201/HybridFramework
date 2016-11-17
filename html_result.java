package DriverScript;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class html_result {
	
	public String ResFilePath;
	//1 st
	//Script dsc=new Script();
	public String CreateResultFileAndPath(String vProjectName) throws Throwable 
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();		
		String TempFileName=dateFormat.format(date);
		String NewFileName1=TempFileName.replace("/","_");
		String NewFileName2=NewFileName1.replace(" ","_");
		String NewFileName=NewFileName2.replace(":","_");
		System.out.println(NewFileName);
		ResFilePath =(System.getProperty("user.dir")+"\\src\\Results\\"+vProjectName+"HtmlResult_"+NewFileName+".html");
		File f = new File(ResFilePath);
		f.createNewFile();
		return ResFilePath;
		
	}
	// 2nd step
	
	public void fg_OpenResultsFile(String ResFilePath,String Projectname) throws Throwable 
	{
		FileWriter w = new FileWriter(ResFilePath);
		BufferedWriter ts = new BufferedWriter(w);
		ts.write ("<HTML>");
		ts.write ("<head><link href='Result_JS_CSS/tablecloth.css' rel='stylesheet' type='text/css' media='screen' />");
		ts.write ("<script type='text/javascript' src='https://www.gstatic.com/charts/loader.js'></script>");
		ts.write ("<script type='text/javascript' src='Result_JS_CSS/tablecloth.js'></script>");
		ts.write ("</head>");
		ts.write ("<BODY>");		
        ts.write ("<TABLE>");
		ts.write ("<TBODY>");
		ts.write ("<TR>");
		ts.write ("<th colspan=8>Automation Result</th>");
		ts.write ("</TR>");
		ts.write ("<TR>");
		ts.write ("<TD colspan=8 id='whiteBG'>");
		ts.write ("<TABLE>");
		ts.write ("<TBODY>");
		ts.write ("<TR>");
		ts.write ("<TD id='whiteBG'>");
		ts.write ("<TABLE BGCOLOR=WHITE>");
		ts.write ("<TBODY>");
		ts.write ("<TR>");
		ts.write ("<th>Project Name</th>");
		ts.write ("<th>"+Script.vProjectName+"</th>"); // changes
		ts.write ("</TR>");
		ts.write ("<TR>");
		ts.write ("<th>Execution Start</th>");
		ts.write ("<th><div id='exestart'></div></th>");
		ts.write ("</TR>");
		ts.write ("<TR>");
		ts.write ("<th>Execution End</th>");	
		ts.write ("<th><div id='exeend'></div></th>");
		ts.write ("</TR>");
		ts.write ("<TR>");
		ts.write ("<th>Total Execution Time</th>");
		ts.write ("<th><div id='totexec'></div></th>");
		ts.write ("</TR>");
		ts.write ("</TBODY>");
		ts.write ("</TABLE>");
		ts.write ("</TD>");
		ts.write ("<TD style='width: 300px; height: 200px;'>");
		ts.write ("<TABLE BGCOLOR=WHITE>");
		ts.write ("<TBODY>");
		ts.write ("<TR>");
		ts.write ("<th colspan=2><div id=piechart style='width: 300px; height: 200px;'></th>");
		ts.write ("</TR>");
		ts.write ("</TBODY>");
		ts.write ("</TABLE>");
		ts.write ("</TD>");
		ts.write ("<TD>");
		ts.write ("<TABLE BGCOLOR=WHITE>");
		ts.write ("<TBODY>");
		ts.write ("<TR>");
		ts.write ("<th>Regression Pace</th>");
		ts.write ("<th>NOV PACE 16</th>");
		ts.write ("</TR>");
		ts.write ("<TR>");
		ts.write ("<th>Total Test Cases</th>");
		ts.write ("<th><div id=ttc></div></th>");
		ts.write ("</TR>");
		ts.write ("<TR>");
		ts.write ("<th>Total Passed Test Cases</th>");
		ts.write ("<th>");
		ts.write ("<div id=tpassed></div></th>");
		ts.write ("</TR>");
		ts.write ("<TR>");
		ts.write ("<th>Total Failed Test Cases</th>");
		ts.write ("<th><div id=tfailed></div></th>");
		ts.write ("</TR>");
		ts.write ("</TBODY>");
		ts.write ("</TABLE>");
		ts.write ("</TD>");
		ts.write ("</TR>");
		ts.write ("</TD>");
		ts.write ("</TBODY>");
		ts.write ("</TABLE>");
		ts.write ("<TABLE>");
		ts.write ("<TBODY>");
		ts.write ("<TR>");
		ts.write ("<th>ProjectName</th>");
		ts.write ("<th>ModuleName</th>");
		ts.write ("<th>TestCaseName</th>");
		ts.write ("<th>ValidationSteps</th>");
		ts.write ("<th>Expected Result</th>");
		ts.write ("<th>Actual Result</th>");
		ts.write("<th>Validation Status</th>");
		ts.write("<th>ExecutionTime</th>");
		ts.write("<th>Test Case_Status</th>");
		ts.write("</TR>");  
		ts.flush();
	}
	
	public void fgInsertStep(String ResFilePath,String vTCName ) throws Throwable
	{
		FileWriter w=new FileWriter(ResFilePath,true);
		BufferedWriter ts = new BufferedWriter(w);
		ts.write("<TR>");
		ts.write ("<TD>" +Script.vProjectName+"</TD>");
		ts.write ("<TD>" +Script.vModuleName+"</TD>");
		ts.write("<TD ><FONT FACE='VERDANA' COLOR='NAVY' SIZE=2><B>" + Script.vTCName + "<B></FONT></TD>");
		ts.write ("<TD>"+" " + "</TD>");
		ts.write ("<TD>"+" " + "</TD>");
		ts.write ("<TD>"+" " + "</TD>");
		ts.write ("<TD>"+" " + "</TD>");
		ts.write ("<TD>"+" " + "</TD>");
		ts.write ("<TD> " + " "+ "</TD>");
		ts.write("</TR>");
		ts.flush();
	}
	
	
	@SuppressWarnings("resource")
	public void fgInsertResult(String ResFilePath,String vActPerform, String usedmethod, String Expected, String Actual, String Result) throws Throwable
	{
		FileWriter w = new FileWriter(ResFilePath,true);
		BufferedWriter ts = new BufferedWriter(w);
		ts.write ("<TR>");
		ts.write ("<TD>" +Script.vProjectName+"</TD>"); // changes
		
	
		ts.write ("<TD>" +Script.vModuleName+"</TD>");  // changes
		ts.write ("<TD>" +vActPerform+"</TD>"); 
		//ts.write ("<TD>" +driver.vActPerform+ " RowNum: # "+driver.StepsExcelRowNum+"</TD>");  // changes
		ts.write ("<TD>" + usedmethod +"</TD>");
		ts.write ("<TD>" + Expected+"</TD>");
		ts.write ("<TD>" +Actual+"</TD>");
		if (Result.equals("PASS"))
		{
			
			 
			ts.write ("<TD><FONT FACE='VERDANA' COLOR='GREEN' SIZE=1><B>"+Result+"</B></Font></TD>");	
			
			Script.passval = Script.passval+1;
			 
		 }	 
		 else if (Result.equals("FAIL"))
		 {
			
			
			 ts.write ("<TD><FONT FACE='VERDANA' COLOR='RED' SIZE=1><B>"+Result+"</B></Font></TD>");	
			 Script.totfailval = Script.totfailval+1;
			 Script.failval =Script.failval+1; 
			
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();		
		String CurrentTime=dateFormat.format(date);	
		ts.write ("<TD>"+CurrentTime+"</TD>");
		ts.write ("<TD>"+" "+"</TD>");
		ts.write ("</TR>");
		ts.flush();
	}
	
	public void fgInsertTcResult(String TC_Status) throws Throwable
	{
		FileWriter w=new FileWriter(Script.ResFilePath,true);
		BufferedWriter ts=new BufferedWriter(w);
		
		
		if(TC_Status.equals("PASS"))
		{
			ts.write("<TR id='passColor'>");
			ts.write ("<TD colspan='8'><FONT FACE='VERDANA' COLOR='BLACK' SIZE=2><B> "+"TestCase Result" + "</B></FONT></TD>");
			ts.write ("<TD BFCOLOR='GREEN'><FONT COLOR='GREEN' SIZE=2><B>" +Script.TC_Status+"</B></FONT></TD>");
			ts.write("</TR>");
		}
		
		else if(TC_Status.equals("FAIL"))
		{
			ts.write("<TR id='failColor'>");
			ts.write ("<TD colspan='8'><FONT FACE='VERDANA' COLOR='BLACK' SIZE=2><B> "+"TestCase Result" + "</B></FONT></TD>");
			ts.write ("<TD BGCOLOR='RED'><FONT COLOR='RED' SIZE=2><B>" +Script.TC_Status+"</B></FONT></TD>");
			ts.write("</TR>");
		}
		
		ts.flush();
		
	}
	
	public void fgCreateSummary(String ResFilePath) throws Throwable
	{
		FileWriter w = new FileWriter(ResFilePath,true);
		BufferedWriter ts = new BufferedWriter(w);
		ts.write ("</TBODY>");
		ts.write ("</TABLE>");
		ts.write ("<TABLE>");
		ts.write ("<TBODY>");
		ts.write ("<TR>");
		ts.write ("<th>Total # of TC's</th>");
		
		ts.write ("<th>Validations Passed</th>");
		ts.write ("<th>Validations Failed</th>");
		ts.write ("<th>Total # of TC's Passed</th>");
		ts.write ("<th>Total # of TC's Failed</th>");
		ts.write ("<th>Execution Start Time</th>");
		ts.write ("<th>Execution End Time</th>");
		ts.write ("<th>Total TimeTaken </th>");
		ts.write ("</TR>");
		ts.flush();
		   
	}
	
	public void fgInsertSummary(String strFilePath,int noofTC,int passval,int failval,int passtc,int failtc,Date StartDate, Date EndDate) throws Throwable
    {
        String TimeDiff= timeDiffernce(StartDate,EndDate);
        FileWriter w = new FileWriter(ResFilePath,true);
        BufferedWriter ts = new BufferedWriter(w);
        ts.write ("<TR>");
        ts.write ("<TD id='total_tc'>"+noofTC+"</TD>");
        ts.write ("<TD>"+passval+"</TD>");
        ts.write ("<TD>"+failval+"</TD>");
        ts.write ("<TD><div id='total_passed' data-value="+passtc+">"+passtc+"</div></TD>");
        ts.write ("<TD><div id='total_failed' data-value="+failtc+">"+failtc+"</div></TD>");                    
        ts.write ("<TD><div id='exe_start' data-value='"+StartDate+"'>"+StartDate+"</div></TD>");    
        ts.write ("<TD><div id='exe_end' data-value='"+EndDate+"'>"+EndDate+"</div></TD>");    
        ts.write ("<TD><div id='tot_exec' data-value='"+TimeDiff+"'>"+TimeDiff+"</div></TD>");
        ts.write ("</TR>");
        ts.write ("</TBODY>");
        ts.write ("</TABLE>");
        ts.flush();
    }
	
	public void WriteTCTime(String ResFilePath,long tctime) throws Throwable
	{
		FileWriter w = new FileWriter(ResFilePath,true);
		BufferedWriter out = new BufferedWriter(w);
		out.write ("<TD WIDTH='10%'><FONT FACE='VERDANA' COLOR='GREEN' SIZE=2><B>"+tctime+"</B></FONT></TD>");
		out.newLine();
		out.flush();
	}
	
	@SuppressWarnings("resource")
	public void fgCloseFile(String ResFilePath) throws Throwable
	{
		FileWriter w = new FileWriter(ResFilePath,true);
		BufferedWriter out = new BufferedWriter(w);
		out.write ("</DIV>");
		out.write ("</BODY></HTML>");
		out.flush();
		
	}
	
	public void ExcelResult(Xls_Reader xres,String status)
	{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();		
		String DateTime=dateFormat.format(date);
		int rownum=xres.getRowCount(Script.vProjectName);
		xres.setCellData(Script.vProjectName, "ModuleName", rownum+1, Script.vModuleName);
		xres.setCellData(Script.vProjectName, "TCName", rownum+1, Script.vTCName);
		xres.setCellData(Script.vProjectName, "Description", rownum+1, Script.vDescription);
		xres.setCellData(Script.vProjectName, "Status", rownum+1, status);
		xres.setCellData(Script.vProjectName, "DateTime", rownum+1, DateTime);
	}
	
	public String timeDiffernce(Date dateStart,Date dateEnd) throws Throwable
    {

        String TimeDiff= null;
        //HH converts hour in 24 hours format (0-23), day calculation
        Date d1 = dateStart;
        Date d2= dateEnd;
        //in milliseconds
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000 % 60;
        long diffMinutes = diff / (60 * 1000) % 60;
        long diffHours = diff / (60 * 60 * 1000) % 24;
        long diffDays = diff / (24 * 60 * 60 * 1000);


        TimeDiff = Long.toString(diffDays) +"D : "+ Long.toString(diffHours) +"H : "+ Long.toString(diffMinutes) +"M : "+ Long.toString(diffSeconds) +"S";
        return TimeDiff;

    }
	
	
}	



