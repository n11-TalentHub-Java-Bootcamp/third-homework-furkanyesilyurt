package com.furkanyesilyurt.mongodbstudy.controller;

import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import com.furkanyesilyurt.mongodbstudy.repository.ProductCommentRepository;
import com.furkanyesilyurt.mongodbstudy.services.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/comments/")
@RequiredArgsConstructor
// generates a constructor with 1 parameter for each field that requires special handling.
// All non-initialized final fields get a parameter, as well as any fields that are
// marked as @NonNull that aren't initialized where they are declared.
public class ProductCommentController {

    //@Autowired
    private final ProductCommentService productCommentService;

    @GetMapping("")
    public List<ProductComment> findAll() {
        return productCommentService.findAll();
    }

    @GetMapping("/{id}")
    public ProductComment findById(@PathVariable String id) {
        return productCommentService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductComment productComment) {

        productComment = productCommentService.save(productComment);

        return new ResponseEntity<>(productComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productCommentService.delete(id);
    }



}
