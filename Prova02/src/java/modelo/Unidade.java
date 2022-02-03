/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;

public class Unidade {
    private String cnpj;
    private String nome;       
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;        
    private String cep;
    private String telefone;
    private String microregiao;
    private String email;

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * @param logradouro the logradouro to set
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the microregiao
     */
    public String getMicroregiao() {
        return microregiao;
    }

    /**
     * @param microregiao the microregiao to set
     */
    public void setMicroregiao(String microregiao) {
        this.microregiao = microregiao;
    }
    
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void Inserir(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = null;
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prova02", "root", "Alexandre3");

            PreparedStatement pstmt = null;

            pstmt = con.prepareStatement("insert into unidades (cnpj, nome, logradouro, numero, complemento, bairro, cep, telefone, microregiao, email) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1,this.getCnpj());
            pstmt.setString(2, this.getNome());
            pstmt.setString(3, this.getLogradouro());
            pstmt.setString(4, this.getNumero());
            pstmt.setString(5, this.getComplemento());
            pstmt.setString(6, this.getBairro());
            pstmt.setString(7, this.getCep());
            pstmt.setString(8, this.getTelefone());
            pstmt.setString(9, this.getMicroregiao());
            pstmt.setString(10, this.getEmail());
            

            pstmt.execute();

            if (pstmt != null) pstmt.close();
            if (con != null) con.close();

 
            
        } catch (Exception e) {
            
        }
    }

   
    
}

