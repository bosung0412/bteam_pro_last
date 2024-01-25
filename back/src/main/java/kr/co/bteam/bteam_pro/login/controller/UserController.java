package kr.co.bteam.bteam_pro.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.bteam.bteam_pro.login.entity.UserEntity;
import kr.co.bteam.bteam_pro.login.service.UserService;



@RestController
@RequestMapping("/api/admin/")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/userList")
    public ResponseEntity<?> getUserList() {
        List<UserEntity> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }

     @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok("사용자 삭제가 성공적으로 수행되었습니다.");
    }

}
