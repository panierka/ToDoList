import { Component, Input } from '@angular/core';
import { Task } from 'src/app/models/task';
import { TasksProviderService } from 'src/app/services/tasks-provider.service';

@Component({
  selector: 'app-task[task]',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent{
  
  @Input() task!: Task;

  constructor(private taskService: TasksProviderService) {}
  
  submitStateUpdate(_: Event): void{
    console.log('state change submitted to server');
    this.taskService.updateTask(this.task);
  } 
}
