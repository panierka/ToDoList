import { Component, Injectable, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task';
import { HttpClient } from '@angular/common/http';
import { TasksProviderService } from 'src/app/services/tasks-provider.service';

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
}
