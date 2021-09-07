/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.madhis.optimed.repository;

import com.madhis.optimed.entity.Script;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hoosain
 */
public interface ScriptRepository extends JpaRepository<Script, Long>{
    
}
