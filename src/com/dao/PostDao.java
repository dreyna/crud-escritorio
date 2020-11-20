/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.entity.Post;
import java.util.List;

/**
 *
 * @author dreyna
 */
public interface PostDao {
    int create(Post p);
    int update(Post p);
    int delete(int id);
    Post read(int id);
    List<Post> readAll();
}
