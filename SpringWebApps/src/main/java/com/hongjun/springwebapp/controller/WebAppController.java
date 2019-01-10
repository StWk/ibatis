package com.hongjun.springwebapp.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hongjun.springwebapp.common.ComResDto;
import com.hongjun.springwebapp.model.UserCreateReqDto;
import com.hongjun.springwebapp.model.UserCreateResDto;
import com.hongjun.springwebapp.model.UserDeleteResDto;
import com.hongjun.springwebapp.model.UserModifyReqDto;
import com.hongjun.springwebapp.model.UserModifyResDto;
import com.hongjun.springwebapp.model.UserReadListResDto;
import com.hongjun.springwebapp.model.UserReadResDto;
import com.hongjun.springwebapp.service.WebAppService;

@Controller
public class WebAppController {
   private static final Logger logger = LoggerFactory.getLogger(WebAppController.class);

   @Autowired
   private WebAppService service;
   
   @ResponseBody
   @RequestMapping(value = "/user", method = RequestMethod.POST)
   public ComResDto userCreate(@RequestBody UserCreateReqDto reqDto, Model model){
      logger.debug("userCreate");
      logger.debug(reqDto.toString());
      
      UserCreateResDto resDto= service.userCreate(reqDto, model);
      ComResDto res = new ComResDto("OK", resDto);
      
      return res;
   }

   @ResponseBody
   @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
   public ComResDto userRead(@PathVariable String userId, Model model){
      logger.debug("userRead");
      logger.debug(userId);
      
      UserReadResDto resDto= service.userRead(userId, model);
      ComResDto res = new ComResDto("OK", resDto);
      return res;
   }

   @ResponseBody
   @RequestMapping(value = "/user", method = RequestMethod.GET)
   public ComResDto userList(Model model){
      logger.debug("userList");
      
      ArrayList<UserReadListResDto> resDto= service.userList(model);
      ComResDto res = new ComResDto("OK", resDto);
      return res;
   }

   @ResponseBody
   @RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
   public ComResDto userModify(@RequestBody UserModifyReqDto reqDto, @PathVariable String userId, Model model){
      logger.debug("userModify");
      logger.debug(reqDto.toString());
      logger.debug(userId);
      
      UserModifyResDto resDto= service.userModify(reqDto, userId, model);
      ComResDto res = new ComResDto("OK", resDto);
      return res;
   }

   @ResponseBody
   @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
   public ComResDto userDelete(@PathVariable String userId, Model model){
      logger.debug("userDelete");
      logger.debug(userId);
      
      UserDeleteResDto resDto= service.userDelete(userId, model);
      ComResDto res = new ComResDto("OK", resDto);
      return res;
   }
}
