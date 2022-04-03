import java.util.Scanner;
import functions.CRUD;
import java.sql.*;
import Enum.Commands;

public class Execution {
    static Scanner order = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        String user_name = "root";
        String password = "MySQL2000";
        String URL = "jdbc:mysql://localhost:3306/Library";

        Connection cnt = null;
        Statement stmt = null;
        ResultSet rslt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try {
            cnt = DriverManager.getConnection(URL, user_name, password);
            stmt = cnt.createStatement();

            System.out.println("Welcome to e-library!!! This is special book database for you to store, edit, search - control your books from one place.");

            other_loop: while (true) {
                System.out.println("Following commands helps you to manage you book collection. Write:\n INSERT - to add book to collection.\n SEARCH - to find book you want (write ALL to search bar to see all available books).\n DELETE - to remove book from collection.\n EDIT - to alter information about selected book.\n\t QUIT - to exit from system.");
                String command = order.next();
                System.out.println("You can write \"EXIT!!!\" to return back.");

                try {
                    switch (Commands.valueOf(command)) {
                        case INSERT -> rslt = CRUD.Insert(stmt);
                        case EDIT -> rslt = CRUD.Update(stmt);
                        case SEARCH -> rslt = CRUD.Read(stmt);
                        case DELETE -> CRUD.Delete(stmt);
                        case QUIT -> {
                            break other_loop;
                        }
                        default -> System.out.println("Unknown commands!!! \n Please check the list of commands and try again.");
                    }

                    if (rslt != null && !rslt.isClosed()){
                        System.out.println("\t\t\t\t\tLIBRARY \n");

                        StringBuilder label = new StringBuilder();
                        for (int i=1; i<=rslt.getMetaData().getColumnCount(); i++){
                            label.append(rslt.getMetaData().getColumnLabel(i)).append("\t\t");
                        }
                        System.out.println(label);

                        while (rslt.next()){
                            StringBuilder buffer = new StringBuilder();
                            for (int i=1; i<=rslt.getMetaData().getColumnCount(); i++){
                                buffer.append(rslt.getString(i)).append("\t\t\t");
                            }
                            System.out.println(buffer);
                        }
                    }

                } catch (SQLException s) {s.printStackTrace();}
            }
        } finally {
            if(cnt != null) try{cnt.close();} catch (SQLException s){s.printStackTrace();}
            if(stmt != null) try{stmt.close();} catch (SQLException s){s.printStackTrace();}
            if(rslt != null) try{rslt.close();} catch (SQLException s){s.printStackTrace();}
        }
    }
}
