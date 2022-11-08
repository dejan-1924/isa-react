import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { CenterAdminRegistrationService } from 'src/app/services/center-admin-registration.service';
import { ActivatedRoute, Router } from '@angular/router';
import { CenterAdmin } from 'src/app/model/center-admin.model';

@Component({
  selector: 'app-center-admin-registration',
  templateUrl: './center-admin-registration.component.html',
  styleUrls: ['./center-admin-registration.component.css']
})
export class CenterAdminRegistrationComponent implements OnInit {
  insertForm: FormGroup;
  email: FormControl;
  password: FormControl;
  name: FormControl;
  surname: FormControl;
  address: FormControl;
  city: FormControl;
  country: FormControl;
  phoneNumber: FormControl;
  ssn: FormControl;
  gender: FormControl;
  centerId: FormControl;

  constructor(
    private cars: CenterAdminRegistrationService,
    private router: Router,
    private route: ActivatedRoute,
    private fb: FormBuilder
  ) { }

  onSubmit() {
    let centerAdminRegistration : CenterAdmin = this.insertForm.value;
    this.cars.register(centerAdminRegistration).subscribe(
      (result) => {
        console.log("Registrovan");
      },
      (error) => {
        console.log("Greska");
      }
    );
  }

  ngOnInit(): void {
    this.email = new FormControl('', [Validators.required]);
    this.password = new FormControl('', [Validators.required]);
    this.name = new FormControl('', [Validators.required]);
    this.surname = new FormControl('', [Validators.required]);
    this.address = new FormControl('', [Validators.required]);
    this.city = new FormControl('', [Validators.required]);
    this.country = new FormControl('', [Validators.required]);
    this.phoneNumber = new FormControl('', [Validators.required]);
    this.ssn = new FormControl('', [Validators.required]);
    this.gender = new FormControl('', [Validators.required]);
    this.centerId = new FormControl('', [Validators.required]);
    
    this.insertForm = this.fb.group({
      email: this.email,
      password: this.password,
      name: this.name,
      surname: this.surname,
      address: this.address,
      city: this.city,
      country: this.country,
      phoneNumber: this.phoneNumber,
      ssn: this.ssn,
      gender: this.gender,
      centerId: this.centerId,
    });
  }

}
