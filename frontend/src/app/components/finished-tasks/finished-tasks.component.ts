import { Component } from '@angular/core';
import { CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import { Task } from 'src/app/models/task';
import { TasksProviderService } from 'src/app/services/tasks-provider.service';

@Component({
  selector: 'app-finished-tasks',
  templateUrl: './finished-tasks.component.html',
  styleUrls: ['./finished-tasks.component.scss']
})
export class FinishedTasksComponent {

  constructor(private taskService: TasksProviderService) {}

  finished: Task[] = [new Task()]

  drop(event: CdkDragDrop<Task[]>) {
    transferArrayItem(
      event.previousContainer.data,
      event.container.data,
      event.previousIndex,
      event.currentIndex,
    );
    var task = this.finished.pop()!;
    var id = task.id!;
    this.taskService.deleteTask(id).subscribe(_ => {});
  }
}


