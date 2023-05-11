import { Component, Input } from '@angular/core';
import { Task } from 'src/app/models/task';

@Component({
  selector: 'app-task[task]',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent{
  
  @Input() task!: Task;

}
