/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.inf.unideb.test.service.user;

import hu.inf.unideb.test.entity.User;

/**
 *
 * @author gjula
 */
public interface UserService {
    public void save(User user);
    public void delete(User user);
    public Iterable<User> getAllUsers();
    public User findByUsername(String username);
}
