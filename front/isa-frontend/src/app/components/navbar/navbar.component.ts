import { Component, OnInit } from '@angular/core';
import { AccountService } from 'src/app/services/account.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  displaylogedIn: any = false;

  constructor(private acct: AccountService) {}

  onClick() {
    this.acct.logout();
  }

  ngOnInit(): void {
    this.acct.isLoggedIn.subscribe((val) => (this.displaylogedIn = val));
    console.log(this.displaylogedIn);
  }
}
