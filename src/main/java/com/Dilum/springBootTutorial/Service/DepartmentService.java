package com.Dilum.springBootTutorial.Service;

import com.Dilum.springBootTutorial.Entity.Department;
import com.Dilum.springBootTutorial.Exception.DepartmentNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmemts();

    public Department fetchDepartmemtById(Long departmentId) throws DepartmentNotFoundException;

    public void deleteDepartmentById(Long departmentId);

    public Department updateDepartment(Long departmentId, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
