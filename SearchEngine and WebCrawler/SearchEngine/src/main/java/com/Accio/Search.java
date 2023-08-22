package com.Accio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/Search") //it should always be /Search and /com.Accio.Search
public class Search extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // we are getting keyword from frontend
        String keyword = request.getParameter("keyword");
        //  setting up connections to database
        Connection connection = DatabaseConnection.getConnection();
        try{
            //store the query of user in the history table
            PreparedStatement preparedStatement = connection.prepareStatement("Insert into history value(?, ?);");
            preparedStatement.setString(1, keyword);
            preparedStatement.setString(2, "http://localhost:8080/SearchEngine/Search?keyword="+keyword);
            preparedStatement.executeUpdate();


            // getting results after running the ranking query
            ResultSet resultSet = connection.createStatement().executeQuery("select pageTitle, pageLink, (length(lower(pageText)) - length(replace(lower(pageText), '" + keyword.toLowerCase() + "', '')))/length('" + keyword.toLowerCase() + "') as count from pages order by count desc limit 30;");
            ArrayList<SearchResult> results = new ArrayList<>();
            // transferring values from resultSet to result arraylist
            while (resultSet.next()) {
                SearchResult searchResult = new SearchResult();
                searchResult.setLink(resultSet.getString("pageLink"));
                searchResult.setTitle(resultSet.getString("pageTitle"));
                results.add(searchResult);
            }
            // Displaying results arraylist in console
            for(SearchResult result: results){
                System.out.println(result.getTitle()+"\n"+result.getLink());
            }
            request.setAttribute("results", results);
            request.getRequestDispatcher("search.jsp").forward(request, response);

            response.setContentType("text/html");

            PrintWriter out = response.getWriter();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        catch(ServletException servletException){
            servletException.printStackTrace();
        }

    }
}
