import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { AccountService } from 'src/app/services/account.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  insertForm: FormGroup;
  Username: FormControl;
  Password: FormControl;
  invalidLogin: boolean;
  ErrorMessage: string;

  constructor(
    private acct: AccountService,
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  onSubmit() {
    let userLogin = this.insertForm.value;
    this.acct.login(userLogin.Username, userLogin.Password).subscribe(
      (result) => {
        if(result.role == 'notValidated'){
          alert('Account is not verified, check your email!');
        }else if (result.role != 'unauthorized') {
          this.invalidLogin = false;
          console.log(result.email, ' ', result.role);
          this.router.navigate(['/home']);
        } else  {
          alert('Login failed');
        }
      },
      (error) => {
        this.invalidLogin = true;
        this.ErrorMessage = 'Invalid';
        console.log(this.ErrorMessage);
      }
    );
  }

  ngOnInit(): void {
    this.Username = new FormControl('', [Validators.required]);
    this.Password = new FormControl('', [Validators.required]);

    this.insertForm = this.fb.group({
      Username: this.Username,
      Password: this.Password,
    });
  }
}
