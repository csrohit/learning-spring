package io.csrohit.jpasearchpageable;

import org.hibernate.NonUniqueResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("")
public class EmployeeController {

    private EmployeeRepository employeeRepository;


    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return new ResponseEntity<List<Employee>>(employeeRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("")
    public Employee createEmployee(@RequestBody Employee employee){
        Employee saved = employeeRepository.save(employee);
        return saved;
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return  employee.get();
        }else{
            return null;
        }
    }

    @GetMapping("/firstname")
    public List<Employee> getByFirstName(@RequestParam String firstName){
        try{

            List<Employee> employee = employeeRepository.findByFirstName(firstName);
            return employee;
        }catch (NonUniqueResultException nonUniqueResultException){
            System.out.println("No unique result found");
            return null;
        }

    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> search(@RequestParam String key, @RequestParam String value){
        ResponseEntity responseEntity = null;
        List<Employee> employees;
        try{
            switch (key){
                case "firstName":
                    employees = employeeRepository.findByFirstNameContaining(value);
                    break;
                case "lastName":
                    employees = employeeRepository.findByLastNameContaining(value);
                    break;
                case "email":
                    employees = employeeRepository.findByEmailContaining(value);
                    break;
                default:
                    return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
            }
            responseEntity = new ResponseEntity(employees, HttpStatus.OK);
        }catch (Exception e){
            responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }finally {
            return responseEntity;
        }
    }
}
