/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.inf.unideb.test.service.user;

import hu.inf.unideb.test.entity.Authorities;
import hu.inf.unideb.test.repository.AuthoritiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService{

    @Autowired
    AuthoritiesRepository authoritiesRepository;
    @Override
    public void save(Authorities auth) {
        authoritiesRepository.saveAndFlush(auth);
    }

    @Override
    public void delete(Authorities auth) {
        authoritiesRepository.delete(auth);
    }
}
