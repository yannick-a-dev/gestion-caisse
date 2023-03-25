package com.bcaisse.bcaisse.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcaisse.bcaisse.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
