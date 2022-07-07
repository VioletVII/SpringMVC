package mvc.controller;

import mvc.controller.Bean.Employee;
import mvc.controller.Bean.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;

/**
 * @author
 * @description:
 * @create 2022/5/4-18:50
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDAO employeeDAO;

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String getAllEmployees(Model model){
        Collection<Employee> employeeList = employeeDAO.getAll();
        model.addAttribute("employeeList",employeeList);
        return "Employee_show";
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
//    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDAO.delete(id);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public String addEmployee(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public String UpdateEmployee(Employee employee){
        employeeDAO.save(employee);
        return "redirect:/employee";
    }
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public String getEmployeeId(@PathVariable(value = "id") Integer id,Model model){
        Employee employee = employeeDAO.get(id);
        model.addAttribute("employee",employee);
        return "UpdateEmployee";
    }
    @RequestMapping(value = "/toAdd")
    public String toAdd(){
        return "addEmployee";
    }


}
