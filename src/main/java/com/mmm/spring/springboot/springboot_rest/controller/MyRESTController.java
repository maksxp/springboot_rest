package com.mmm.spring.springboot.springboot_rest.controller;



import com.mmm.spring.springboot.springboot_rest.entity.Employee;
import com.mmm.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List <Employee> showAllEmployees () {
        List <Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

        return employee;
    }

//    //two methods below we can use for all controllers with another separate class which has annotation @ControllerAdvice and
//    @ExceptionHandler
//    public ResponseEntity <EmployeeIncorrectData> handleException (NoSuchEmployeeException exception){
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler
//    public ResponseEntity <EmployeeIncorrectData> handleException (Exception exception){
//        EmployeeIncorrectData data = new EmployeeIncorrectData();
//        data.setInfo(exception.getMessage());
//
//        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
//    }

    @PostMapping("/employees")
    public Employee addNewEmployee (@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee (@RequestBody Employee employee) {

        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {

        Employee employee = employeeService.getEmployee(id);

        employeeService.deleteEmployee(id);


        return "Employee with ID = "+id+" was deleted";
    }
}
