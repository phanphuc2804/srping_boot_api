package com.example.spring_boot_api.repository;

import com.example.spring_boot_api.entity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    //read
    //JPQL
    @Query("select e from Employee e where e.lastName=?1")
    public List<Employee> findEmployeeByLastNameJPQL(String lastName);
    //Native
    @Query(value = "select * from tbl_employee e", nativeQuery = true)
    public List<Employee> findEmployeeNative();

    //update
    //JPQL
    @Transactional
    @Modifying
    @Query("update Employee e set e.firstName=?2 where e.employeeId =?1")
    public void updateFirstnameByEmployeeID(Long id, String firstName);
    //Native
    @Transactional
    @Modifying
    @Query(value = "update tbl_employee set last_name=?2 where employee_id=?1", nativeQuery = true)
    public void updateLastnameByEmployeeIDNative(Long id, String lastName);

    //delete
    //CRUD
    @Transactional
    @Modifying
    public void deleteByEmployeeId(Long employeeId);
    //JPQL
    @Transactional
    @Modifying
    @Query("delete from Employee e where e.employeeId=?1")
    public void deleteStudentByIdJPQL(Long id);
    //Native
    @Transactional
    @Modifying
    @Query(value = "delete from tbl_employee where employee_id=?1", nativeQuery = true)
    public void deleteStudentByIdNative(Long id);
}