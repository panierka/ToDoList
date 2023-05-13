import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from '../models/task';

@Injectable({
  providedIn: 'root'
})
export class TasksProviderService {
  private baseUrl = '/task';

  constructor(private http: HttpClient) { }
  
  getAllTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.baseUrl}/get-all`);
  }

  updateTask(task: Task): Observable<any>{
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`${this.baseUrl}/update/1`, 
      JSON.stringify(task), 
      { headers: headers }
    );
  }

  reorder(tasks: Task[]): Observable<any> {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    return this.http.put(`${this.baseUrl}/reorder`, 
      JSON.stringify(tasks.map(x => x.id)), 
      { headers: headers }
    );
  }
}
