package controller;

import dto.User;
import dto.UserCredit;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import service.RoleTest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@Controller
public class IndexController {

    @Autowired
    HttpServletRequest request;
    @Autowired
    private ServletContext servletContext;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @RoleTest(role = "test")
    public ModelAndView test(String name,String pass){
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("name",name);
        modelAndView.addObject("pass",pass);
        return modelAndView;
    }

    @RequestMapping(value = "/request",method = RequestMethod.GET)
    public String test2(HttpServletRequest request){
        request.setAttribute("pass","123");
        return  "home";
    }
    @RequestMapping(value = "/model")
    public String model(Model model,String name){
        model.addAttribute("key","value");
        //model.addAttribute("name",name);
        return "home";
    }

    @GetMapping(value = "/getbean")
    public String getbean(User user){
        request.setAttribute("name",user.getName());
        request.setAttribute("pass",user.getPass());
        return "home";
    }

    @PostMapping(value = "/postbean")
    @ResponseBody
    public String postbean(User user){
        request.setAttribute("user",user);
        return "home";
    }

    @RequestMapping(value = "/postJson",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Object postJson(@RequestBody User user){
        return user;
    }


    @GetMapping(value = "/mapjson",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public Map<String, String> map() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "1");
        return map;
    }
    @RequestMapping(value = "/postJsonFile",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public String jsonFile(){
        try {
            File directory = new File("");
            String absolutePath = directory.getAbsolutePath();
            //对字符串进行拼接，具体要自己测试下
          //  InputStream is = new FileInputStream(absolutePath+"\\src\\jdbc.properties");
            String home = System.getProperty("user.home");
            String path = System.getProperty("user.dir") + File.separator + "data" + File.separator + "jsonFile1.json";
            String contextpath = servletContext.getContextPath() + File.separator + "jsonFile1.json";
            String path1 = servletContext.getRealPath("jsonFile1.json");
            String x = servletContext.getRealPath("/");
            URL y = servletContext.getResource("/jsonFile1.json");
            return FileUtils.readFileToString(new File(y.getFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  "false";
    }
    @RequestMapping(value = "/testjdbc",produces = {"application/json;charset=utf-8"})
    @ResponseBody
    public UserCredit jdbctest(){
        String sql = "select * from user_credit where id = ?";
        RowMapper<UserCredit> result = new BeanPropertyRowMapper<>(UserCredit.class);
        UserCredit  userCredit = jdbcTemplate.queryForObject(sql,result,82);
        System.out.println(userCredit.toString());
        return  userCredit;
    }
}
