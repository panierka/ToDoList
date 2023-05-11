import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-user-text[model]',
  templateUrl: './user-text.component.html',
  styleUrls: ['./user-text.component.scss']
})
export class UserTextComponent {
  @Input() model!: string;

  onAttemptedNewline(event: Event): void {
    event.preventDefault();
  }
}
