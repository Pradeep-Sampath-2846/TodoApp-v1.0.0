package lk.ijse.dep9.dao.custom;

import lk.ijse.dep9.dao.CrudDAO;
import lk.ijse.dep9.entity.Project;

import java.util.List;

public interface ProjectDAO extends CrudDAO<Project,Integer> {

    List<Project> findAllProjectsByUsername(String username);
}
