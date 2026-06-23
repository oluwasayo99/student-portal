package com.studentportal.mapper;

import com.studentportal.dto.request.CreateStudentRequest;
import com.studentportal.dto.response.StudentResponse;
import com.studentportal.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface StudentMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "studentNumber", ignore = true)
    @Mapping(target = "enrollmentDate", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Student toEntity(CreateStudentRequest request);

    StudentResponse toResponse(Student student);
}
