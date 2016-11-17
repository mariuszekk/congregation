package com.congregation.model;

import java.util.List;

public interface RecommendationRepository {

    public List<Recommendation> findAll();
}
