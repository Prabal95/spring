package com.employeedao;

import com.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class EmployeeDao {

    @SuppressWarnings({"SpringJavaInjectionPointsAutowiringInspection", "SpringJavaAutowiredFieldsWarningInspection"})
    @Autowired
    private HibernateTemplate hibernateTemplate;

    // create
    @Transactional
    public void createProduct(Employee employee) {

        this.hibernateTemplate.save(employee);

    }

    // get all products
    public List<Employee> getProducts() {
        List<Employee> products = this.hibernateTemplate.loadAll(Employee.class);
        return products;
    }

    // delete the single product
    @Transactional
    public void deleteProduct(int pid) {
        Employee emp = this.hibernateTemplate.load(Employee.class, pid);
        this.hibernateTemplate.delete(emp);
    }

    // get the single product
    public Employee getProduct(int pid) {
        return this.hibernateTemplate.get(Employee.class, pid);
    }
}
