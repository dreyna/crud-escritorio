/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.daoimpl;

import com.config.Conexion;
import com.dao.PostDao;
import com.entity.Post;
import java.util.List;

/**
 *
 * @author dreyna
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class PostDaoImpl implements PostDao{
    private Connection cx = null;
    private final Conexion conex = new Conexion();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public int create(Post p) {
        String SQL = "INSERT INTO post(titulo, descripcion) VALUES(?,?)";
        int x= 0;
        try {
            cx = conex.conectado();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDescripcion());
           x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return x;       
    }

    @Override
    public int update(Post p) {
        String SQL = "UPDATE post SET titulo=?, descripcion=? WHERE idpost=?";
        int x= 0;
        try {
            cx = conex.conectado();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDescripcion());
            ps.setInt(3, p.getIdpost());
           x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return x;
    }

    @Override
    public int delete(int id) {
        String SQL = "DELETE FROM post WHERE idpost=?";
        int x= 0;
        try {
            cx = conex.conectado();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
           x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return x;
    }

    @Override
    public Post read(int id) {
        String SQL = "SELECT *FROM post WHERE idpost=?";
        Post post = new Post();
        int x= 0;
        try {
            cx = conex.conectado();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
           rs = ps.executeQuery();
           while(rs.next()){
               post.setIdpost(rs.getInt("idpost"));
               post.setTitulo(rs.getString("titulo"));
               post.setDescripcion(rs.getString("descripcion"));
           }
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return post;
    }

    @Override
    public List<Post> readAll() {
        String SQL = "SELECT *FROM post";
        List<Post> lista =new ArrayList<>();
        int x= 0;
        try {
            cx = conex.conectado();
            ps = cx.prepareStatement(SQL);
           rs = ps.executeQuery();
           while(rs.next()){
               Post post = new Post();
               post.setIdpost(rs.getInt("idpost"));
               post.setTitulo(rs.getString("titulo"));
               post.setDescripcion(rs.getString("descripcion"));
               lista.add(post);
           }
        } catch (SQLException e) {
            System.out.println("error: "+e);
        }
       return lista;
    }
    
}
