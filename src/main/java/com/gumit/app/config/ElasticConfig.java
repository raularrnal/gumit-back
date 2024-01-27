package com.gumit.app.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;

@Configuration
public class ElasticConfig {
	
	
	@Value("${elasticServer}")
	private String elasticServer;
	

	@Bean
	public ElasticsearchClient  elasticClient() {
		
		RestClient restClient = RestClient
			    .builder(HttpHost.create(elasticServer))
			  
			    .build();

			ElasticsearchTransport transport = new RestClientTransport(
			    restClient, new JacksonJsonpMapper());

			// And create the API client
			return new ElasticsearchClient(transport);

	}
	
}
