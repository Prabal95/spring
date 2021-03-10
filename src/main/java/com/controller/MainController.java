package com.controller;

import com.employeedao.EmployeeDao;
import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping("/")
    public String home(Model m){
        List<Employee> employees = employeeDao.getProducts();
        m.addAttribute("employees", employees);
        return "index";
    }

    @RequestMapping("/add-employee")
    public String addEmployee(Model m){
        m.addAttribute("title","Add Employee");
        return "add_employee_form";
    }

    @RequestMapping(value = "/handle-employee", method = RequestMethod.POST)
    public RedirectView handleEmployee(@ModelAttribute Employee employee, HttpServletRequest request){
        System.out.println(employee);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+"/");
        return redirectView;
    }

    @RequestMapping("/delete/{employeeId}")
    public RedirectView deleteEmployee(@PathVariable("employeeId") int employeeId ,HttpServletRequest request){
        this.employeeDao.deleteProduct(employeeId);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(request.getContextPath()+ "/");
        return redirectView;
    }
}
