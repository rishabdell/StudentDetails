package com.example.studentdetails.service;

import com.example.studentdetails.Exception.ResourceNotFoundException;
import com.example.studentdetails.entity.Department;
import com.example.studentdetails.entity.StudentEntity;
import com.example.studentdetails.repository.DepartmentDAO;
import com.example.studentdetails.repository.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDAO studentDAO;

   @Autowired
   private DepartmentDAO departmentDAO;

    public Department insertDetailDep(Department departments)
   {
       return departmentDAO.save(departments);
   }

    public List<StudentEntity> getAllDetails(){
        return studentDAO.findAll();
    }

    public StudentEntity getDetailsById (long id) throws ResourceNotFoundException{
      Optional<StudentEntity> studentEntity = studentDAO.findById(id);
       if(!studentEntity.isPresent()){ throw new ResourceNotFoundException("Resource Not Found!!!!");}

        return studentDAO.findById(id).get();
    }

    public List<StudentEntity> insertDetails(List<StudentEntity> studentEntity)
    {
        return studentDAO.saveAll(studentEntity);
    }

    public StudentEntity updateDetails (StudentEntity studentEntity) throws ResourceNotFoundException {
        Optional<StudentEntity> studentEntityOptional = studentDAO.findById(studentEntity.getId());
        if(!studentEntityOptional.isPresent()){throw new ResourceNotFoundException("Resource Not Found!!!!");}
        else
        {
            StudentEntity studentEntity1 =  studentEntityOptional.get();
            studentEntity1.setName(studentEntity.getName());
            studentEntity1.setCity(studentEntity.getCity());
            studentEntity1.setCourse(studentEntity.getCourse());
            studentDAO.save(studentEntity1);
            return studentEntity1;
        }
    }

    public void deleteDetail(long id) throws ResourceNotFoundException {
        Optional<StudentEntity> studentEntity = studentDAO.findById(id);
        if(!studentEntity.isPresent()){throw new ResourceNotFoundException("Resource Not Found!!!!");} ;
         studentDAO.delete(studentEntity.get());
    }

    public void deleteAllDetails(){

        studentDAO.deleteAll();
    }

}
