package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.User;
   
@Controller
public class UserController {

   public HttpHeaders setHeaders(){
	   HttpHeaders headers = new HttpHeaders();
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, "POST");
	   headers.add(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "Content-Type");
	   headers.add(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
	   return headers;
   }

   @RequestMapping(value = "/AddNewUser", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> addNewUser(@RequestBody String req) {
       ObjectMapper mapper = new ObjectMapper();
       String body;
	   
       try{ 
		    body = mapper.writeValueAsString(APIMethods.addNewUser(mapper.readValue(req, User.class)));
		    return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
   
   @RequestMapping(value = "/UpdateUser", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> updateUser(@RequestBody String req) {
       ObjectMapper mapper = new ObjectMapper();
	   String body;
       try{ 
		    body = mapper.writeValueAsString(APIMethods.updateUser(mapper.readValue(req, User.class)));
		    return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
	
   @CrossOrigin()
   @RequestMapping(value = "/GetAllUsers", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getAllUsers() {
       List<User> userList = APIMethods.getAllUsers();
       ObjectMapper mapper = new ObjectMapper();
       List<String> body = new ArrayList<String>();
       try{ 
		for(User u : userList)body.add(mapper.writeValueAsString(u));
			return new ResponseEntity<>(body.toString(), setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
	   
   @CrossOrigin()
   @RequestMapping(value = "/GetUserByID", method = RequestMethod.POST)
   public @ResponseBody ResponseEntity<String> getUserByID(@RequestBody String req) {
//	   System.out.println(req);
       ObjectMapper mapper = new ObjectMapper();
	   Map<String, Object> user = new HashMap<String, Object>();
	   String body;
       try{ 
			user = mapper.readValue(mapper.writeValueAsString(mapper.readValue(req, User.class)), new TypeReference<Map<String, String>>(){});
		    body = mapper.writeValueAsString(APIMethods.getUserByID(Integer.parseInt(user.get("userId").toString())));
		    return new ResponseEntity<>(body, setHeaders(), HttpStatus.OK);
		}catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
   }
}

