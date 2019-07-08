/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.ui;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author eroot
 */
public class conek {
    private static Connection koneksi = null;
    
    public static Connection GetConnection() throws SQLException{
        return koneksi;
    }
}
    

