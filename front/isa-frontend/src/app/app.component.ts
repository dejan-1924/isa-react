import { Component } from '@angular/core';
import { TestService } from './services/test.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  test: string = 'pv';
  selectedMenu: any = 'Home';
  constructor(private testService: TestService) {}

  goTo(paramText: string) {
    this.selectedMenu = paramText;
  }
}
