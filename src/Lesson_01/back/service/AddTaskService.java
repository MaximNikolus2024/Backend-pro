package Lesson_01.back.service;

import Lesson_01.back.dto.RequestDto;
import Lesson_01.back.dto.ResponseDto;
import Lesson_01.back.entity.Task;
import Lesson_01.back.repository.TaskRepository;

public class AddTaskService {
    private TaskRepository repository;
    private ValidationService validationService;

    public AddTaskService(TaskRepository repository, ValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public ResponseDto<Task> createNewTask(RequestDto request) {

        // выведем на экран информацию о полученном запросе
        // эмуляция лога работы нашей программы
        System.out.println("Received request: " + request);

        // провести проверку корректности данных

        String validationMessage = validationService.validate(request);

        if (validationMessage.isBlank()) {
            Task newTask = new Task(request.getName(), request.getDescription());
            Task savedTask = repository.addTask(newTask);
            return new ResponseDto<>(200, savedTask, validationMessage);
        } else {
            return new ResponseDto<>(400, null, validationMessage);
        }

    }
}
