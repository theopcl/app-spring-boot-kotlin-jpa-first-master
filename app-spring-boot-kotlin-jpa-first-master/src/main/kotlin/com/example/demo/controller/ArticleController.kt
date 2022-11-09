package com.example.demo.controller

import com.example.demo.domain.Article
import com.example.demo.repository.ArticleRepository
import com.example.demo.toDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import javax.servlet.http.HttpServletRequest

@Controller
class ArticleController @Autowired constructor(private val articleRepository: ArticleRepository, private val auteurRepository: ArticleRepository){

    @GetMapping("/articles")
    fun index(model: Model): String {
        model["title"] = "Les articles"
        model["articles"] = articleRepository.findAll()
        return "article/index"
    }


    @GetMapping("/articles/detail")
    fun detail(request: HttpServletRequest, model: Model): String {
        val id = (request.getParameter("id") ?:"").toLong()
        model["title"] = "Details"
        model["detail"] = articleRepository.findById(id)
        model["id"] = id
        return "article/detail"
    }

}