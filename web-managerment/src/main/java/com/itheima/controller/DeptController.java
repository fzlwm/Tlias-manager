package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;
//    @RequestMapping(value="/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }
    @DeleteMapping
    public Result delete(Integer id){
        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result Insert(@RequestBody Dept dept){
        deptService.Insert(dept);
        return Result.success();
    }
    @GetMapping("/{id}")
    //id是路径参数
    public Result SelectById(@PathVariable("id") Integer id){
        Dept dept = deptService.SelectById(id);
        return Result.success(dept);
    }
    @PutMapping
    public Result Update(@RequestBody Dept dept){
        deptService.Update(dept);
        return Result.success();
    }
}
