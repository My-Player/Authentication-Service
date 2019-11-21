package com.java.authentication.service.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.authentication.service.dto.LoginResponse;
import com.java.authentication.service.dto.UserLoginDTO;
import com.java.authentication.service.service.LoginService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.servlet.http.HttpServletResponse;

import static com.java.authentication.service.constant.StatusConstant.SUCCESS;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @InjectMocks
    LoginController loginController;

    @Mock
    LoginService loginService;

    @Autowired
    MockMvc mockMvc;

    HttpServletResponse response;

    LoginResponse loginResponse;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void testGetLoginToken() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        UserLoginDTO dto = new UserLoginDTO();
        dto.setEmail("test@gmail.com");
        dto.setPassword("pwd");
        loginResponse = new LoginResponse(200,SUCCESS.getMessage(),"token");


        when(loginService.loginUser(dto,response)).thenReturn(loginResponse);
        this.mockMvc.perform(post("/v1/login").contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(mapper.writeValueAsString(dto))).andExpect(status().isOk()).andDo(print());
    }

}
