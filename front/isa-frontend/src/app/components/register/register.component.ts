import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { RegistrationService } from 'src/app/services/registration.service';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  insertForm: FormGroup;
  Name: FormControl;
  Surname: FormControl;
  Email: FormControl;
  Address: FormControl;
  City: FormControl;
  Country: FormControl;
  PhoneNumber: FormControl;
  SSN: FormControl;
  Password: FormControl;
  Password2: FormControl;
  Gender: FormControl;

  constructor(
    private regSer: RegistrationService,
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {

    this.insertForm = this.fb.group({
      Name: this.Name,
      Surname: this.Surname,
      Email: this.Email,
      Address: this.Address,
      City: this.City,
      Country: this.Country,
      PhoneNumber: this.PhoneNumber,
      SSN: this.SSN,
      Password: this.Password,
      Password2: this.Password2,
      Gender: this.Gender
    });
  }
  onSubmit() {
    let userLogin = this.insertForm.value;
    if(userLogin.Password !== userLogin.Password2){
      alert("Passwords did not match!")
      return
    }
    if(isNaN(userLogin.SSN)){
      alert("SSN must be a number!")
      return
    }
    if(isNaN(userLogin.PhoneNumber)){
      alert("Phone number must be a number!")
      return
    }
    if(userLogin.Email == "" || userLogin.Password == ""
    || userLogin.Name == "" || userLogin.Surname == ""
    || userLogin.Address == "" || userLogin.City == ""
    || userLogin.Country == "" || userLogin.PhoneNumber == ""
    || userLogin.SSN == "" || userLogin.Gender == null){
      alert("Every field is required!")
      return
    }
    let isMale: boolean = userLogin.Gender == "male"
    //console.log("JERI MUSKO: ", isMale)
    this.regSer.register(userLogin.Email, userLogin.Password, userLogin.Name, userLogin.Surname, 
                                      userLogin.Address, userLogin.City, userLogin.Country, userLogin.PhoneNumber,
                                      userLogin.SSN, isMale).subscribe(
                                        (result) => {
                                          if (!result.isSuccess) {
                                            alert(result.responseMessage);
                                          } else {
                                            this.router.navigate(['/home']);
                                          }
                                        },
                                        (error) => {
                                          console.log("Something wierd happened...");
                                        }
                                      );
  }

}
