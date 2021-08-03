package cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.application;

import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.DaoFactory;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.dao.DepartmentDao;
import cursoUdemyNelio.exerciciosFixacao.jdbc.dao_jdbc.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("==== TEST #1: department findById ====");
        Department department = departmentDao.findById(7);
        System.out.println(department);

        System.out.println("==== TEST #2: department findAll ====");
        List<Department> departmentList = departmentDao.findAll();
        for (Department dep : departmentList) {
            System.out.println(dep);
        }

        System.out.println("==== TEST #3: department insertDepartment ====");
        department.setId(null);
        department.setName("Management");
        departmentDao.insert(department);

        System.out.println(department.getId());

        System.out.println("==== TEST #4: department updateDepartment ====");
        department.setId(4);
        department.setName("Lost And Found");
        departmentDao.update(department);

        System.out.println("==== TEST #5: department deleteDepartment ====");
        departmentDao.deleteById(8);


    }
}
