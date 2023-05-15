import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FinishedTasksComponent } from './finished-tasks.component';

describe('FinishedTasksComponent', () => {
  let component: FinishedTasksComponent;
  let fixture: ComponentFixture<FinishedTasksComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FinishedTasksComponent]
    });
    fixture = TestBed.createComponent(FinishedTasksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
