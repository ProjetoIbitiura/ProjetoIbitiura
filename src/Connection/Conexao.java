/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danilo
 */
public class Conexao {
    private Connection con;
    private PreparedStatement stmt;
    private String sql;
    
    public Conexao()
    {  
    }
 
    public Connection RetornaConexao()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/patrimonio", "root", "admin");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
        
    public void CriaConexaoNova()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost", "root", "admin");
            
            sql = "CREATE DATABASE IF NOT EXISTS patrimonio;";
            stmt = con.prepareStatement(sql);
            stmt.execute();
            sql="";
            stmt.clearParameters();
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
        }
    }
    
    public void CriaConexao()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/patrimonio", "root", "admin");
            
            sql = "CREATE TABLE IF NOT EXISTS login (id_login INT NOT NULL AUTO_INCREMENT,nome_login VARCHAR(50),"+
                    "senha_login VARCHAR(15),tipo_login INT(2),PRIMARY KEY (id_login));";
            stmt = con.prepareStatement(sql);
            stmt.execute();
            sql="";
            stmt.clearParameters();
            
            sql = "CREATE TABLE IF NOT EXISTS setor (id_setor INT NOT NULL AUTO_INCREMENT,nome_setor VARCHAR(50),"+
                    "PRIMARY KEY (id_setor));";
            stmt = con.prepareStatement(sql);
            stmt.execute();
            sql="";
            stmt.clearParameters();
            
            sql = "CREATE TABLE IF NOT EXISTS item (id_item INT NOT NULL AUTO_INCREMENT,numero_plaq INT,afixado INT,"+
                    "valor DOUBLE,nome_item VARCHAR(200),tipo VARCHAR(8),modo INT,empenho VARCHAR(20),nota_fiscal VARCHAR(60),"+
                    "data_aquis DATE,id_setor INT,iduser INT NOT NULL,baixado INT,"+
                    "CONSTRAINT pk_id_item PRIMARY KEY(id_item),"+
                    "CONSTRAINT fk_id_setor FOREIGN KEY (id_setor)"+
                    "REFERENCES setor (id_setor));";
            stmt = con.prepareStatement(sql);
            stmt.execute();
            sql="";
            stmt.clearParameters();
            
            con.close();
        }
        catch(ClassNotFoundException | SQLException e){
        }
    }
}
