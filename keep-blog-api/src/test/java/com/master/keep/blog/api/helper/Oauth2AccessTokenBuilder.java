package com.master.keep.blog.api.helper;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
public class Oauth2AccessTokenBuilder {

    private static String tokenUrl = "http://localhost:7001/auth/oauth/token";
    private static String scope = "all";
    private static String grantType = "password";

    private static final RestTemplate restTemplate;
    private static final HttpHeaders headers;

    static
    {
        restTemplate = new RestTemplateBuilder().build();
        headers  = new HttpHeaders();
        headers.set("Authorization", "Basic " + Base64Utils.encodeToString("client-1:secret-1".getBytes()));
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class Oauth2AccessToken {
        @JsonProperty("access_token")
        public String accessToken;
    }

    public static String buildToken(String username, String password) {
        MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
        params.add("scope", scope);
        params.add("grant_type", grantType);
        params.add("username", username);
        params.add("password", password);
        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<>(params, headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange(tokenUrl, HttpMethod.POST, httpEntity, String.class);
        String responseBody = responseEntity.getBody();
        log.debug("Access token detail for {}: {}", username, responseBody);
        try {
            return new ObjectMapper().readValue(responseBody, Oauth2AccessToken.class).accessToken;
        } catch (IOException e) {
            log.error("{}", e);
            throw new RuntimeException("Unable to get access token.");
        }
    }

    public static void visitUri(MockMvc mockMvc, String url, String username, String password, ResultMatcher resultMatcher) throws Exception {
        String accessToken = buildToken(username, password);
        MvcResult mvcResult = mockMvc.perform(get(url)
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(resultMatcher)
                //.andDo(print())
                .andReturn();
        log.info("{} visit {} get response: {}", username, url, mvcResult.getResponse().getContentAsString());
    }

}