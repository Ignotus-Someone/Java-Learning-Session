package functions;

import java.sql.*;
import java.util.*;

public class CRUD {

    static Scanner get = new Scanner(System.in);

    static String book_title;
    static String author;
    static String page;
    static String publish_year;
    static String edition;

    /* Normalda bunlari ResultSet clasindaki methodlarla etmek olardi
    amma men qerara geldim ki manual edim.*/

    public static ResultSet Insert(Statement stmt) throws SQLException {

        while(true){
            System.out.println("Please enter the book title:");
            book_title = get.nextLine();

            if (book_title.equals("EXIT!!!")) return null;
            if (!book_title.equals("")) break;
            System.out.println("This field cannot be empty!!! If you want to exit write \"EXIT!!!\"");
        }

        while(true){
            System.out.println("Please enter the Author name:");
            author = get.nextLine();

            if (author.equals("EXIT!!!")) return null;
            if (!author.equals("")) break;
            System.out.println("This field cannot be empty!!! If you want to exit write \"EXIT!!!\"");
        }

        System.out.println("Please enter the edition:");
        edition = get.nextLine();
        if (edition.equals("EXIT!!!")) return null;

        System.out.println("Please enter the publish year:");
        publish_year = get.nextLine();
        if (String.valueOf(publish_year).equals("EXIT!!!")) return null;

        System.out.println("Please enter the total number of page of book:");
        page = get.nextLine();
        if (String.valueOf(page).equals("EXIT!!!")) return null;

        stmt.execute("INSERT INTO books(book_title, author, edition, publish_year, page) VALUES ('" +book_title+ "','" +author+"','"+edition+"',"+publish_year+","+page+");");
        System.out.println("Book is successfully added to your library");
        return stmt. executeQuery("SELECT * FROM books ORDER BY book_id DESC LIMIT 1;");
    }

    public static ResultSet Read(Statement stmt) throws SQLException{
        System.out.println("Enter the book title to search it:");
        book_title = get.nextLine();
        if (book_title.equals("EXIT!!!")) return null;
        if(book_title.equals("ALL")) return stmt.executeQuery("SELECT * FROM books");
        return stmt.executeQuery("SELECT * FROM books WHERE book_title = '"+book_title+"';");
    }

    public static ResultSet Update(Statement stmt) throws SQLException{
        System.out.println("Enter the identification of book you want to edit:");
        String edit_book = get.nextLine();
        if (String.valueOf(edit_book).equals("EXIT!!!")) return null;

        System.out.println("Enter the property (book_title, author, page, publish_year, edition) you want to alter:");
        String what = get.nextLine();
        if (what.equals("EXIT!!!")) return null;

        System.out.println("Enter the new value:");
        String new_value = get.nextLine();
        if (new_value.equals("EXIT!!!")) return null;

        String pass;
        if (what.equals(publish_year) || what.equals(page))
            pass = new_value;
        else
            pass = "'"+new_value+"'";

        stmt.executeUpdate("UPDATE books SET "+what+" = "+pass+" WHERE book_id = "+edit_book+";");
        System.out.println("Book is successfully edited");
        return stmt.executeQuery("SELECT * FROM books WHERE book_id = "+edit_book+";");
    }

    public static void Delete(Statement stmt) throws SQLException{
        System.out.println("Enter the book ID to delete it:");
        String book_id = get.nextLine();
        if (String.valueOf(book_id).equals("EXIT!!!")) return;
        stmt.executeUpdate("DELETE FROM books WHERE book_id = "+book_id+";");
        System.out.println("Book has successfully deleted!");
    }
}
