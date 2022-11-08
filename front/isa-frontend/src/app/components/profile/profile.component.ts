import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user.model';
import { ProfileService } from 'src/app/services/profile.service';
import { HttpErrorResponse } from '@angular/common/http';
import { Donor } from 'src/app/model/donor.model';
import { AccountService } from 'src/app/services/account.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  public user: Donor;
  public email: string;
  public showDialog: boolean;
  constructor(
    public profileService: ProfileService,
    private accountService: AccountService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.getData();
  }

  onClick() {
    this.profileService.showDialog = true;
  }

  public getData(): void {
    this.accountService.currentUserName.subscribe((val) => (this.email = val));
    console.log(this.email);
    this.profileService.getData(this.email).subscribe(
      (response: Donor) => {
        this.user = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
