package com.training.springcore.service;

import com.training.springcore.model.Captor;
import com.training.springcore.model.PowerSource;
import com.training.springcore.model.Site;
import com.training.springcore.utils.OutputCapture;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SiteServiceImplTest.SiteServiceTestConfiguration.class})
public class SiteServiceImplTest {

    @Configuration
    @ComponentScan("com.training.springcore.service")
    static class SiteServiceTestConfiguration{ }

    @Mock
    private CaptorService captorService;

    @InjectMocks
    private SiteServiceImpl siteServiceImpl;

    @Autowired
    private SiteServiceImpl siteService;

    @Rule
    public OutputCapture output = new OutputCapture();

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }
    //@ContextConfiguration(classes = {SiteServiceImplTest.SiteServiceTestConfiguration.class})*/

    @Test
    public void findByIdShouldReturnNullWhenIdIsNull(){
        // Initialisation
        String siteId = null;

        // Appel du SUT
        Site site = siteServiceImpl.findById(siteId);

        // Vérification
        assertThat(site).isNull();
    }

    @Test
    public void findById(){
        // Initialisation
        String siteId = "siteId";
        Set<Captor> expectedCaptors = Collections.singleton(new Captor("Capteur A", PowerSource.FIXED));
        Mockito.when(captorService.findBySite(siteId)).thenReturn(expectedCaptors);

        // Appel du SUT
        Site site = siteServiceImpl.findById(siteId);

        // Vérification
        assertThat(site.getId()).isEqualTo(siteId);
        assertThat(site.getName()).isEqualTo("Florange");
        assertThat(site.getCaptors()).isEqualTo(expectedCaptors);
    }

    @Test
    public void readFileFromUrl(){
        siteService.readFile("url:https://dev-mind.fr/lorem.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }

    @Test
    public void readFileFromClasspath(){
        siteService.readFile("classpath:jesaispascequejefais.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");

    }

    @Test
    public void readFileFromFileSystem(){
        siteService.readFile("file:///C:/Users/Acer/Documents/workspace-java/formation-spring-tp/src/main/resources/jesaispascequejefais.txt");
        assertThat(output.toString()).contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit");
    }
}