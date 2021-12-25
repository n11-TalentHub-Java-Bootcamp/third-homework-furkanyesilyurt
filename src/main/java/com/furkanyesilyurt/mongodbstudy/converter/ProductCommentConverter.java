package com.furkanyesilyurt.mongodbstudy.converter;

import com.furkanyesilyurt.mongodbstudy.dto.ProductCommentDetailDto;
import com.furkanyesilyurt.mongodbstudy.entities.ProductComment;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductCommentConverter {

    ProductCommentConverter INSTANCE = Mappers.getMapper(ProductCommentConverter.class);

    List<ProductCommentDetailDto> convertProductCommentListToProductCommentDetailDtos(List<ProductComment> productCommentList);

    ProductCommentDetailDto convertProductCommentToProductCommentDetailDto(ProductComment productComment);

    ProductComment convertProductCommentDetailDtoToProductComment(ProductCommentDetailDto productCommentDetailDto);
}
