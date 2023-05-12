import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-user-text[model]',
  templateUrl: './user-text.component.html',
  styleUrls: ['./user-text.component.scss']
})
export class UserTextComponent {
  @Input() model!: string;

  @Output()
  unfocus: EventEmitter<Event> = new EventEmitter<Event>();

  onAttemptedNewline(event: Event): void {
    event.preventDefault();
  }
}
