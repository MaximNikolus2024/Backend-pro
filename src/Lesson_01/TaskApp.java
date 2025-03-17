package Lesson_01;

import Lesson_01.back.repository.TaskRepository;
import Lesson_01.back.service.AddTaskService;
import Lesson_01.back.service.DeleteTaskService;
import Lesson_01.back.service.FindTaskService;
import Lesson_01.back.service.ValidationService;
import Lesson_01.front.menu.UserInput;
import Lesson_01.front.menu.UserMenu;

public class TaskApp {
    public static void main(String[] args) {
        TaskRepository repository = new TaskRepository();
        ValidationService validationService = new ValidationService();

        AddTaskService addTaskService = new AddTaskService(repository, validationService);
        FindTaskService findTaskService = new FindTaskService(repository);
        DeleteTaskService deleteTaskService = new DeleteTaskService(repository);
        UserInput userInput = new UserInput();

        UserMenu userMenu = new UserMenu(addTaskService,findTaskService,userInput,deleteTaskService);

        userMenu.menu();
    }
}
