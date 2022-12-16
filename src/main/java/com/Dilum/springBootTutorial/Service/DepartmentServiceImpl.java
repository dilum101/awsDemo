package com.Dilum.springBootTutorial.Service;

import com.Dilum.springBootTutorial.Entity.Department;
import com.Dilum.springBootTutorial.Exception.DepartmentNotFoundException;
import com.Dilum.springBootTutorial.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmemts() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmemtById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department = departmentRepository.findById(departmentId);

        if(!department.isPresent())
        {
            throw new DepartmentNotFoundException("Department Not Found");
        }
        else
        {
            return department.get();
        }
    }

    @Override
    public void deleteDepartmentById(Long departmentId)
    {
        departmentRepository.deleteById(departmentId);

    }

    @Override
    public Department updateDepartment(Long departmentId,Department department)
    {
        Department newDepartment = departmentRepository.findById(departmentId).get();

        if(Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName()) )
        {
            newDepartment.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepatmentCode()) && !"".equalsIgnoreCase(department.getDepatmentCode()) )
        {
            newDepartment.setDepatmentCode(department.getDepatmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress()) )
        {
            newDepartment.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(newDepartment);
    }

    @Override
    public Department fetchDepartmentByName(String departmentName)
    {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }
}
