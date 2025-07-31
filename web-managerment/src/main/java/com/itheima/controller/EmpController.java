package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.Result;
import com.itheima.pojo.ResultPage;
import com.itheima.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;
    @GetMapping
    public Result list(EmpQueryParam empQueryParam) {
        ResultPage<Emp> resultPage= empService.list(empQueryParam);
        return Result.success(resultPage);
    }
    @PostMapping
    public Result Insert(@RequestBody Emp emp) {
        empService.Insert(emp);
        return Result.success();
    }
    @DeleteMapping
    public Result delete(@RequestParam("ids")List<Integer> ids) {
        empService.delete(ids);
        return Result.success();
    }
    @GetMapping("/list")
    public Result listAll() {
        List<Emp> list= empService.listALl();
        return Result.success(list);
    }
    @GetMapping("/{id}")
    public Result selectById(@PathVariable("id") Integer id) {
        Emp emp = empService.selectById(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
