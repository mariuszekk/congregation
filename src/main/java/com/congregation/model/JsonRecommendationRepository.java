package com.congregation.model;

import static com.google.common.collect.Lists.newArrayList;

import com.congregation.util.ToImmutableListCollector;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import javax.annotation.PostConstruct;

@Repository
class JsonRecommendationRepository implements RecommendationRepository {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ClientRepository clientRepository;

    private ImmutableList<Recommendation> recommendations;

    @Override
    public List<Recommendation> findAll() {
        return newArrayList(recommendations);
    }

    @PostConstruct
    void init() {
        List<Client> clients = clientRepository.findAll();
        recommendations = clients.stream().flatMap(client -> client.getRecommendations().stream()).distinct().collect(ToImmutableListCollector.toImmutableList());
        logger.debug("loaded recommendations: {}", recommendations);
    }
}
