# AccioSearchEngineAndWebCrawler
Search Engine and WebCrawler, major project made for acciojob assignment

# Search Engine:
  Allow uer to search images, videos, information, etc.
# Web Crawler: 
  A web crawler is a bot that crawls over the Internet to gather page data. The bot uses an algorithm called DFS (Depth-First Search) to navigate through web pages. Saves all the data to database

Objective: implement simple search engine and functions behind it
 1. perform search, give top 30 results
 2. User serach history

# Web Applications:
1. Frontend
2. Backend
3. Database

Frontend =>Client
Backend =>server
client  --makes request-->server
server --handel request,generate response-->client

user  --(interacts with)--> FrontEnd(ClientSide) --sends request -->BackEnd(ServerSide)
      <--  response     <--                    <--fulfills request<--

# Tech Stack:
FrontEnd: HTML, CSS (Cascading Style Sheet), JSP(Java Server Pages) help us to write java inside HTML file which connects the webpage to backend. Diveide the backend server to several small servers 

Backend: Java Servlets(help create several miniservers)

DataBase: MySQL

Maven Archtype : dependency management framework

Dependencies: Project depends upon other projects/libraries
Maven Archtype WebApp

Plugin: The SmartTomcat will auto load the Webapp classes and libs from project and module The Smart Tomcat plugin will auto config the classpath for tomcat server.

host server --> Apache Tomcat --> host web application on my local system
user -->(keyword)--> FrontEnd --> Search(keyword) -->BackEnd

# DataBase Connection
MySQL(RDBMS-Data stored in tabular form). Attribute: table heading, tuple: data rows
  Database "searchengineapp" = myTable()

Interact with mySql data using JDBC() which connect java with database. MySQLconnector/jlibrary is used to set up the interaction. create connection instance

DatabaseConnection (singleton class) : class with only single object. One connection for multiple query.

# Indexer:
1. get www pages from crawler
2. It select the important part of the webpage, 1. page Title, 2. Page link, 3. Page text(complete text uset to find the relevance of the page)
3. Save all of the important things to the database

# Ranking: find top 30 results
count number of occurances of the keyword in the page text
occurance = {textBefore.length() - textAfter.length()} /keyword.length()

# Displaying Search Result:
  FrontEnd file "search.jsp" is an HTML file with embedded java code to display the result in tabular format
	The request and response is forwarderd to the search.jsp using request.setAttribute("results", results); request.getRequestDispatcher("search.jsp").forward(request, response);
	The Java code retrieves the results ArrayList using `request.getAttribute("results")`.

# History Feature: 
Store of all previously searched quries
History Servlet: Display all of the queries
search servlet will store the history

GetHistoryButton --> history servlet --(sql query)-->Historytable

# CSS (Cascading Styling Sheets)
Three ways(selector) to specify styling
  1. By class: make a one or more block of code belong to a class and apply css accordingly
    .class_name {property : value}
  2. By id: same as class but should be unique
    #id_name{}
  3. By HTML element: for each element like button styling for every button
    button{}

padding-internal spacing with inside element, margin-external spacing with other element
