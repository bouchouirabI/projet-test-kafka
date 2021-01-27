package com.project.app.cucumber;

import com.project.app.AppApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@CucumberContextConfiguration
@SpringBootTest(classes = AppApplication.class)
@ActiveProfiles("test")
@AutoConfigureMockMvc
@Slf4j
public class CucumberContextConfig {}
