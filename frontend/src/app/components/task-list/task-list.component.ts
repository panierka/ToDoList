import { Component, Injectable, OnInit } from '@angular/core';
import { Task } from 'src/app/models/task';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.scss']
})

@Injectable()
export class TaskListComponent implements OnInit {
  
  tasks: Task[] = []
  greeting: string = ""
  
  constructor(private http: HttpClient) {}


  ngOnInit(): void {
    this.http.get('/hello', {responseType: 'text'}).subscribe(res => this.greeting = res);

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
