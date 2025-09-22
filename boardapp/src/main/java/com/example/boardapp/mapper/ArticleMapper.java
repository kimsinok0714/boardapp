package com.example.boardapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.boardapp.domain.ArticleDto;
import com.example.boardapp.util.Criteria;




/*
@Mapper 어노테이션
- @Mapper는 MyBatis 프레임워크에서 사용되는 어노테이션입니다.

주요 기능
1. MyBatis 매퍼 인터페이스 표시
- 해당 인터페이스가 MyBatis의 매퍼 인터페이스임을 Spring에게 알려줍니다
- MyBatis가 이 인터페이스의 구현체를 자동으로 생성합니다
2. Spring Bean 등록
- Spring 컨테이너에 자동으로 Bean으로 등록됩니다
- 다른 클래스에서 @Autowired로 주입받아 사용할 수 있습니다
3. SQL 매핑
- XML 매퍼 파일 또는 어노테이션을 통해 SQL문과 메서드를 매핑합니다
*/
@Mapper
public interface ArticleMapper {


    List<ArticleDto> selectArticleList();

    void insertArticle(ArticleDto article);

    ArticleDto selectArticleById(int id);

    void updateArticle(ArticleDto articleDto);

    List<ArticleDto> findArticleList(Criteria criteria);

}
