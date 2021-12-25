package com.furkanyesilyurt.mongodbstudy.services.entityServices;

import com.furkanyesilyurt.mongodbstudy.converter.ProductCommentConverter;
import com.furkanyesilyurt.mongodbstudy.dto.ProductCommentDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.Product;
import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import com.furkanyesilyurt.mongodbstudy.repository.ProductCommentRepository;
import com.furkanyesilyurt.mongodbstudy.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static com.furkanyesilyurt.mongodbstudy.converter.ProductCommentConverter.INSTANCE;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductCommentEntityService {

    //@Autowired
    private final ProductCommentRepository productCommentRepository;

    public List<ProductCommentDetailDto> findAll(){
        return INSTANCE.convertProductCommentListToProductCommentDetailDtos(productCommentRepository.findAll());
    }

    public ProductComment findById(String id){

        Optional<ProductComment> optional = productCommentRepository.findById(id);

        ProductComment productComment = null;
        if (optional.isPresent()){
            productComment = optional.get();
        }

        return productComment;
    }

    public void deleteById(String id){
        productCommentRepository.deleteById(id);
    }

    public ProductComment save(ProductComment productComment){
        return productCommentRepository.save(productComment);
    }
}
