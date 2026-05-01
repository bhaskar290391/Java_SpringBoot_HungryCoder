package com.springboot.practise.dto;

import com.springboot.practise.model.ProductV2;

import java.util.List;

public record ProductResponseV2(List<ProductV2> product2, int totalCount) {
}
