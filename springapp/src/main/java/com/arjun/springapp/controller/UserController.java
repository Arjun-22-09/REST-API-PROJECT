package com.arjun.springapp.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjun.springapp.Entity.user;
import com.arjun.springapp.service.userService;
@RestController
@RequestMapping("/users")
public class UserController 
{
    @Autowired
    userService obj;
    @PostMapping
    public ResponseEntity<user> Addnewuser(@RequestBody user a)
    {
        return new ResponseEntity<>(obj.AddNewuser(a),HttpStatus.ACCEPTED);
    }

    @GetMapping
    public ResponseEntity<List<user>> GetAlluser()
    {
        return new ResponseEntity<>(obj.GiveAlluser(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<user> GetSingleuser(@PathVariable int id)
    {
        Optional<user> user = obj.GiveSingleuser(id);
        if(user.isPresent())
        {
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<user> UpdateSingleuser(@PathVariable int id,@RequestBody user a)
    {
        Optional<user> user = obj.GiveSingleuser(id);
        if(user.isPresent())
        {
            return new ResponseEntity<>(obj.Updateuser(id, a),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<user> DeleteSingleuser(@PathVariable int id)
    {
        Optional<user> user = obj.GiveSingleuser(id);
        if(user.isPresent())
        {
            obj.Deleteuser(id);
            return new ResponseEntity<>(user.get(),HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/SORT/users/{field}")
    public ResponseEntity<List<user>> Sorting(@PathVariable String field)
    {
        return new ResponseEntity<>(obj.Sorting(field),HttpStatus.OK);
    }

    @GetMapping("/PAGE/users/{pagenumber}/{pagesize}")
    public ResponseEntity<List<user>> Pagination(@PathVariable int pagenumber , @PathVariable int pagesize)
    {
        return new ResponseEntity<>(obj.Pagination(pagenumber,pagesize),HttpStatus.OK);
    }
}