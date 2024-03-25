package com.turkcell.rentacar.core.adapter.concretes;

import com.turkcell.rentacar.core.adapter.abstracts.CustomerFindexService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PersonCustomerFindexManager implements CustomerFindexService {
    private static final String FINDEX_API_URL = "https://example.com/findex";
    @Override
    public int calculateFindexScore(String identifier) {
        RestTemplate restTemplate = new RestTemplate();
        String url = FINDEX_API_URL + "?userId=" + identifier;
        int score = restTemplate.getForObject(url, Integer.class);
        return score;
    }
}
