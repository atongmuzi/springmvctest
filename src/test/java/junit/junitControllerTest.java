//package junit;
//
//import config.DatasourceConfig;
//import controller.IndexController;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import spittr.SpittrWebApplication;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = SpittrWebApplication.class)
//public class junitControllerTest {
//    @Test
//    public void testHomePage() throws Exception{
//        IndexController indexController = new IndexController();
//        MockMvc mockMvc = standaloneSetup(indexController).build();
//        mockMvc.perform(get("/request")).andExpect(view().name("home"));
//    }
//}
