package com.example.aggim.controller

import com.example.aggim.common.AggimException
import com.example.aggim.common.ApiResponse
import com.example.aggim.domain.product.Product
import com.example.aggim.domain.product.ProductService
import com.example.aggim.domain.product.registration.ProductImageService
import com.example.aggim.domain.product.registration.ProductRegistrationRequest
import com.example.aggim.domain.product.registration.ProductRegistrationService
import com.example.aggim.domain.product.toProductListItemResponse
import com.example.aggim.domain.product.toProductResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/api/v1")
class ProductApiController @Autowired constructor(
    private val productImageService: ProductImageService,
    private val productRegistration: ProductRegistrationService,
    private val productService: ProductService
) {

    @PostMapping("/product_images")
    fun uploadImage(image: MultipartFile) =
        ApiResponse.ok(productImageService.uploadImage(image))

    @PostMapping("/products")
    fun register(
        @RequestBody request: ProductRegistrationRequest
    ) = ApiResponse.ok(productRegistration.register(request))

    @GetMapping("/products")
    fun search(
        @RequestParam productId: Long,
        @RequestParam(required = false) categoryId: Int?,
        @RequestParam direction: String,
        @RequestParam(required = false) keyword: String?,
        @RequestParam(required = false) limit: Int?
    ) = productService
        .search(categoryId, productId, direction, keyword, limit ?: 10)
        .mapNotNull(Product::toProductListItemResponse)
        .let { ApiResponse.ok(it) }

    @GetMapping("/products/{id}")
    fun get(@PathVariable id: Long) = productService.get(id)?.let {
        ApiResponse.ok(it.toProductResponse())
    } ?: throw AggimException("상품 정보를 찾을 수 없습니다.")
}