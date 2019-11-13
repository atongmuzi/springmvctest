package junit;

import controller.SpittleController;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.DTO.Spittle;
import spittr.Service.SpittleResposiory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

public class shouldShowRecentSpittles {

    @Mock  private   SpittleResposiory spittleResposiory;
    @Mock private  List list;
    @Mock private Request request;

    private  SpittleController spittleController;
    @Autowired
    Response response;

    @Test
    public void testmock() throws Exception {


        MockitoAnnotations.initMocks(this);

        List<Spittle> spittleList = createSpitleList(20);
        when(spittleResposiory.findSpittles(anyLong(),anyInt())).thenReturn(spittleList).thenReturn(null);
        //when(request.Get(anyString()).e.thenReturn("foo");
        List<Spittle> spittles =  spittleResposiory.findSpittles(Long.MAX_VALUE,20);
        List<Spittle> spittles1 =  spittleResposiory.findSpittles(Long.MAX_VALUE,19);
        List<Spittle> spittles2 =  spittleResposiory.findSpittles(Long.MAX_VALUE,18);
        verify(spittleResposiory,times(3)).findSpittles(anyLong(),anyInt());

        spittleController = new SpittleController(spittleResposiory);
        MockMvc mockMvc = standaloneSetup(spittleController).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
        mockMvc.perform(get("/spittles")).andExpect(view().name("spittles"));
    }


    public List<Spittle>  createSpitleList(int count){
        List<Spittle> list = new ArrayList<>();
        for (int i=0;i<count;i++) {
            list.add(new Spittle("Spittle"+i,new Date()));
        }
        return  list;
    }
}
