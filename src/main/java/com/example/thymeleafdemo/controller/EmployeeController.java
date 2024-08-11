package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Employee;
import com.example.thymeleafdemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/employees")  // API endpoint for retrieving employees
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    // get a list of employees
    @GetMapping("/list")
    public String listEmployee(Model model) {

        List<Employee> theEmployees = employeeService.findAll();
        model.addAttribute("employees", theEmployees);
        return "list-employees";
    }

    @GetMapping("/showFormAdd")
    public String showFormAdd(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "add-employee";
    }

    @PostMapping(value ="/save")
    public String saveEmployee(
            @Valid @ModelAttribute("employee")
                                   Employee employee, BindingResult result  ){


        System.out.println("Binding result :" + result.toString());
        System.out.println("\n\n\n");


        if(result.hasErrors()){
            return "add-employee";
        }
            employeeService.save(employee);
            return "redirect:/employees/list";
    }

    @GetMapping("/showFormUpdate")
    public String showFormUpdate(
            @RequestParam("employeeId")
                                   int theId, Model theModel) {
        Optional<Employee> employee = employeeService.findById(theId);

        theModel.addAttribute("employee", employee);
        return "add-employee";
    }

    @GetMapping("/delete")
    public String deleteEmployee(
            @RequestParam("employeeId")
                                   int theId) {
        employeeService.deleteById(theId);
        return "redirect:/employees/list";
    }
}
