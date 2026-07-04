package com.springboot.versioning.dto;

import java.util.List;

public record ProductResponseV2(List<ProductV2> products, long count) {
	public record ProductV2(long id, String name, double price, String description, String category) {

	}

}
