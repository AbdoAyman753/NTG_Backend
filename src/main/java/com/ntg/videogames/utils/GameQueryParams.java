package com.ntg.videogames.utils;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class GameQueryParams {
    private Double minPrice;
    private Double maxPrice;
    private List<Long> categoryIds;
}
