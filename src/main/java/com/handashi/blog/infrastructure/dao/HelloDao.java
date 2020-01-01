package com.handashi.blog.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.handashi.blog.domain.model.entity.Hello;

public interface HelloDao extends JpaRepository<Hello, Integer> {

}
