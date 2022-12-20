package lk.ijse.dep9.dao.custom;

import lk.ijse.dep9.dao.CrudDAO;
import lk.ijse.dep9.entity.Task;

import java.util.List;

public interface TaskDAO extends CrudDAO<Task,Integer> {
    List<Task> findAllTaskByProjectId(Integer projectId);
}
