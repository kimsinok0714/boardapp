package com.example.boardapp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.boardapp.domain.ArticleDto;
import com.example.boardapp.service.ArticleService;
import com.example.boardapp.util.Criteria;
import io.micrometer.core.ipc.http.HttpSender.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class ArticleController {
    // field
    private final ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<ArticleDto> getArticleList() {
        return new ResponseEntity(articleService.retrieveArticleList(), HttpStatus.OK);   
    }
    
    @PostMapping("/articles")
    public ResponseEntity<ArticleDto> postArticle(@RequestBody ArticleDto articleDto) {
        
            LocalDateTime now = LocalDateTime.now();
            articleDto.setRegDate(now);

            int id = articleService.createArtcile(articleDto);
            articleDto.setId(id);
            
            return new ResponseEntity<>(articleDto, HttpStatus.CREATED);
    }   


    @GetMapping("/articles/{id}")
    public ResponseEntity<ArticleDto> getMethodName(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(articleService.retrieveArticleById(id), HttpStatus.OK);
    }
    
    
    @PutMapping("/articles/{id}")
    public ResponseEntity<String> putMethodName(@PathVariable("id") int id, @RequestBody ArticleDto articleDto) {

        articleDto.setId(id);
        articleService.modifyArticle(articleDto);
        
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }


    @GetMapping("/search")
    public ResponseEntity<List<ArticleDto>> search(
            @RequestParam(required = false, defaultValue = "") String keyfield, 
            @RequestParam(required = false, defaultValue = "") String keyword) {
            articleService.searchArticleList(new Criteria(keyfield, keyword));

            return new ResponseEntity<>( articleService.searchArticleList(new Criteria(keyfield, keyword)), HttpStatus.OK);
    }
    

}
