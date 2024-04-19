package org.example.springsecuritybasicday1842024.restcontrollers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    @GetMapping
    public String getAllArticles() {
        return "Getting All articles from the database";
    }

    @GetMapping("/read/{id}")
    public String readSingleArticle(@PathVariable int id) {
        return "Reading a single article from the database";
    }

    @PostMapping("/write")
    public String createArticle() {
        return "Creating an article in the database";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteArticle(@PathVariable int id) {
        return "Deleting an article from the database";
    }
}
