package com.example.boardapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.boardapp.domain.ArticleDto;
import com.example.boardapp.util.Criteria;



// Mapper interface
// 1. SQL 매핑
// XML 매퍼 파일 또는 어노테이션을 통해 SQL문과 메서드를 매핑합니다
// 2. Spring 컨테이너에 자동으로 Bean으로 등록됩니다
// 3. MyBatis가 이 인터페이스의 구현체를 자동으로 생성합니다
@Mapper
public interface ArticleMapper {

 
    List<ArticleDto> selectArticleList();
    
    // @Insert("INSERT INTO articles (title, content) VALUES (#{title}, #{content})")
    void insertArticle(ArticleDto article);
    
    // @Select("SELECT * FROM articles WHERE id = #{id}")
    ArticleDto selectArticleById(int id);

    // @Update("UPDATE articles SET title = #{title}, content = #{content} WHERE id = #{id}")
    void updateArticle(ArticleDto articleDto);

    List<ArticleDto> findArticleList(Criteria criteria);

}
