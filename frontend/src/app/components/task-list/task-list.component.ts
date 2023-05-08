import { Component, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})
export class TaskListComponent implements OnInit {
  
  tasks: Task[] = []

  ngOnInit(): void {
    this.tasks = [
      {
        content: "test1",
        isCompleted: false,
      },
      {
        content: "test2",
        isCompleted: false,
      }
    ]
  }
}
