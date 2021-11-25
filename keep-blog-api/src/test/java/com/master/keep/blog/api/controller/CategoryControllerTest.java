package com.master.keep.blog.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.master.keep.blog.api.helper.Oauth2AccessTokenBuilder.visitUri;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("local")
@AutoConfigureMockMvc
@Slf4j
public class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadAll() {
    }


    @Test
    public void loadById() throws Exception {
        String url = "/category/load/abc";
        visitUri(mockMvc, url, "lily", "abc", status().isOk());
        visitUri(mockMvc, url, "jay", "abc", status().isForbidden());
    }

    @Test
    public void delete() {
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
    }

}