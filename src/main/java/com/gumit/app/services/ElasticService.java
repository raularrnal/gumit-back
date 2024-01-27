package com.gumit.app.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gumit.app.elastic.RestaurantSearch;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.elasticsearch.core.search.HitsMetadata;
import co.elastic.clients.elasticsearch.core.search.TotalHits;
import co.elastic.clients.elasticsearch.core.search.TotalHitsRelation;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ElasticService {
	
	@Autowired
	private ElasticsearchClient elasticClient;

	
	public List<RestaurantSearch> getRestaurantFromElastic(String text) throws ElasticsearchException, IOException{
		
		List<RestaurantSearch> restaurantSearchList= new ArrayList<>();
		
		SearchResponse<RestaurantSearch> response = elasticClient.search(s -> s
		        .index("restaurants")
		        .query(q -> q
		            .queryString(t -> t
		                .fields("name")
		                .query(text)
		            )
		        ),
		        RestaurantSearch.class
		);

		TotalHits total = response.hits().total();
		boolean isExactResult = total.relation() == TotalHitsRelation.Eq;

		if (isExactResult) {
		    log.info("There are {}  results", total.value());
		} else {
			log.info("There are more than {} results", total.value());
		}

		List<Hit<RestaurantSearch>> hits = response.hits().hits();
		for (Hit<RestaurantSearch> hit: hits) {
			RestaurantSearch restaurantSearch = hit.source();
			restaurantSearchList.add(restaurantSearch);
			log.info("Found product {} , score {} ",restaurantSearch.getName(), hit.score());
		}
		return restaurantSearchList;	
	}
}
