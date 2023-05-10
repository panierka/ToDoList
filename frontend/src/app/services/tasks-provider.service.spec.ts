import { TestBed } from '@angular/core/testing';

import { TasksProviderService } from './tasks-provider.service';

describe('TasksProviderService', () => {
  let service: TasksProviderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TasksProviderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
