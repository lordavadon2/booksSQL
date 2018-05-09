package com.company;

import java.sql.*;

public class Main {

    private static final String url = "jdbc:mysql://localhost:3306/socksdb";
    private static final String user = "root";
    private static final String password = "grafitZP_2010";

    private static Connection con;
    private static PreparedStatement psmt;
    private static ResultSet rs;

    static String selectQuery = "SELECT type_sock_type, sock_size,  sock_color FROM socksdb.socks\n" +
            "left join type_socks ON socks.sock_type = type_socks.id_type_socks";

    static String insertQuery = "Insert into socks (color_socks,size_socks,type_socks) values (?,?,?)";

    public static void selectSocks(PreparedStatement pstm)throws SQLException
    {
        rs = pstm.executeQuery();

        while (rs.next())
        {
            String color= rs.getString(1);
            int size =  rs.getInt(2);
            String type = rs.getString(3);
            System.out.println(color+" | " + size + " | " + type);
        }
    }

    public static void insertSock(PreparedStatement pstm)throws SQLException
    {
        psmt.setString(1,"Gray");
        psmt.setInt(2,33);
        psmt.setInt(3,1);

        psmt.executeUpdate();
    }

    public static void main(String[] args) throws SQLException {

        con = DriverManager.getConnection(url, user, password);
        psmt = con.prepareStatement(selectQuery);
        // psmt = con.prepareStatement(insertQuery);
        selectSocks(psmt);
        //insertSock(psmt);
    }
}