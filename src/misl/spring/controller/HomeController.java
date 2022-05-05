package misl.spring.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import misl.spring.model.JsonResponseModel;
import misl.spring.model.StudentModel;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	public ModelAndView homepage(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

		ModelAndView model = new ModelAndView("index");

		return model;
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public JsonResponseModel EditDebt(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html;charset=UTF-8");
		JsonResponseModel res = new JsonResponseModel();
		try {
			System.out.println("TEST");
		} catch (Exception e) {  
			e.printStackTrace();
			res.setStatus("error");
		}
		return res;
	}

}
