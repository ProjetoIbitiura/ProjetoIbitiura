/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package patrimonio;

/**
 *
 * @author Danilo
 */
import Connection.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;

public class SplashScreen extends JWindow {
    
    private Connection conexao;
    private final int duration;

    
    public SplashScreen(int d) throws SQLException {
        duration = d;
        
        Conexao nova = new Conexao();
        nova.CriaConexaoNova();
        
        conexao = nova.RetornaConexao();   
        Statement stm = conexao.createStatement();
        
        nova.CriaConexao();
        
        conexao.close();
   }
    
// Este é um método simples para mostrar uma tela de apresentção

// no centro da tela durante a quantidade de tempo passada no construtor

    public void showSplash() throws SQLException {  
        JPanel jPanel1 = new javax.swing.JPanel();
        JLabel jLabel1 = new javax.swing.JLabel();
        JLabel jLabel2 = new javax.swing.JLabel();
        JLabel jLabel3 = new javax.swing.JLabel();
        JLabel jLabel4 = new javax.swing.JLabel();
        JLabel jLabel5 = new javax.swing.JLabel();
        JLabel jLabel6 = new javax.swing.JLabel();

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/patrimonio/img/Brasão Municipio.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("PREFEITURA MUNICIPAL DE IBITIÚRA DE MINAS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 0));
        jLabel3.setText("SISTEMA DE CONTROLE PATRIMONIAL");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("V 1.0");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Todos os direitos reservados - 2014");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Desenvolvido por Danilo Liparini Moraes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(194, 194, 194))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(225, 225, 225))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack(); 
        setLocationRelativeTo(null);
        // Torna visível
        setVisible(true);
        
        // Espera ate que os recursos estejam carregados
        try { Thread.sleep(duration); } catch (InterruptedException e) {}        
        setVisible(false);        
    }
    
    public void showSplashAndExit() throws SQLException {  
        showSplash();
        dispose();
        Login login= new Login();
        login.setVisible(true);
    }
    
    
    public static void main(String[] args) throws SQLException {        
        // Mostra uma imagem com o título da aplicação 
        SplashScreen splash = new SplashScreen(8000);
        splash.showSplashAndExit(); 
    }
}

