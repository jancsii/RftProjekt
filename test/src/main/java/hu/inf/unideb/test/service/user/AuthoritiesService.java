/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.inf.unideb.test.service.user;

import hu.inf.unideb.test.entity.Authorities;import hu.inf.unideb.test.entity.User;

/**
 *
 * @author gjula
 */
public interface AuthoritiesService {
    public void save(Authorities auth);
    public void delete(Authorities auth);
}
