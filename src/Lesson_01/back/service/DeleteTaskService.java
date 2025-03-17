package Lesson_01.back.service;

import Lesson_01.back.dto.ResponseDto;
import Lesson_01.back.entity.Task;
import Lesson_01.back.repository.TaskRepository;

import java.util.Optional;

public class DeleteTaskService {
    private TaskRepository taskRepository;
    private ValidationService validationService;

    public DeleteTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
        this.validationService = validationService;
    }
  public ResponseDto<Task> deleteTaskById(Integer id){
      Optional<Task> deletedTask = taskRepository.deleteById(id);

      if (deletedTask.isPresent()){
          return new ResponseDto<>(200,deletedTask.get(),"");
      } else {
          return new ResponseDto<>(404,null,"Task with id = " + id + " not found");
      }
      }

  }
