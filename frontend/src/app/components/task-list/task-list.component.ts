import { Component, Injectable, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task';
import { TasksProviderService } from 'src/app/services/tasks-provider.service';
import { CdkDragDrop, moveItemInArray} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})

@Injectable()
export class TaskListComponent implements OnInit {
  
  tasks: Task[] = []
  greeting: string = ""
  
  constructor(private taskService: TasksProviderService) {}


  ngOnInit(): void {
    
    this.taskService
      .getAllTasks()
      .subscribe((tasks: Task[]) => this.tasks = tasks);
  }
  
  drop(event: CdkDragDrop<Task[]>) {
    moveItemInArray(this.tasks, event.previousIndex, event.currentIndex);
    this.tasks.forEach((task, index) => task.order = index + 1);
    this.taskService.reorder(this.tasks).subscribe(res => {});
  }
}
