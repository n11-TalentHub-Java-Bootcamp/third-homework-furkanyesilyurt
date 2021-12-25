package com.furkanyesilyurt.mongodbstudy.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.furkanyesilyurt.mongodbstudy.converter.ProductCommentConverter;
import com.furkanyesilyurt.mongodbstudy.dto.ProductCommentDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import com.furkanyesilyurt.mongodbstudy.repository.ProductCommentRepository;
import com.furkanyesilyurt.mongodbstudy.services.ProductCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    public List<ProductCommentDetailDto> findAll() {
        return productCommentService.findAll();
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findById(@PathVariable String id) {

        ProductComment productComment = productCommentService.findById(id);

        if(productComment == null){
            System.out.println("ProductComment is not found.");
        }

        WebMvcLinkBuilder linkToProductComment = WebMvcLinkBuilder.linkTo(
                WebMvcLinkBuilder.methodOn(this.getClass())
                        .findAll()
        );

        ProductCommentDetailDto productCommentDetailDto = ProductCommentConverter.INSTANCE.convertProductCommentToProductCommentDetailDto(productComment);

        String filterName = "ProductCommentDtoFilter";

        SimpleFilterProvider filters = getProductCommentFilterProvider(filterName);

        EntityModel entityModel = EntityModel.of(productCommentDetailDto);

        entityModel.add(linkToProductComment.withRel("All-Product-Comments"));

        MappingJacksonValue mapping = new MappingJacksonValue(entityModel);

        mapping.setFilters(filters);

        return mapping;

    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody ProductCommentDetailDto productCommentDetailDto) {

        ProductComment productComment = ProductCommentConverter.INSTANCE.convertProductCommentDetailDtoToProductComment(productCommentDetailDto);

        productComment = productCommentService.save(productComment);

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(productComment.getId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        productCommentService.delete(id);
    }

    private SimpleFilterProvider getProductCommentFilterProvider(String filterName) {
        SimpleBeanPropertyFilter filter = getProductCommentFilter();
        return new SimpleFilterProvider().addFilter(filterName, filter);
    }

    private SimpleBeanPropertyFilter getProductCommentFilter() {
        return SimpleBeanPropertyFilter.filterOutAllExcept("id", "name", "lastName", "email","phoneNumber","userName");
    }

}
