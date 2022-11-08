import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Donor } from 'src/app/model/donor.model';
import { ProfileService } from 'src/app/services/profile.service';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css'],
})
export class ModalComponent implements OnInit {
  insertForm: FormGroup;

  Name: FormControl;
  Surname: FormControl;
  Address: FormControl;
  City: FormControl;
  Country: FormControl;
  PhoneNumber: FormControl;
  Profession: FormControl;
  Institution: FormControl;

  @Input() inputFromParent: Donor;
  constructor(
    private profileService: ProfileService,
    private fb: FormBuilder,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.Name = new FormControl(this.inputFromParent.name, [
      Validators.required,
    ]);
    this.Surname = new FormControl(this.inputFromParent.surname, [
      Validators.required,
    ]);
    this.Address = new FormControl(this.inputFromParent.address, [
      Validators.required,
    ]);
    this.City = new FormControl(this.inputFromParent.city, [
      Validators.required,
    ]);
    this.Country = new FormControl(this.inputFromParent.country, [
      Validators.required,
    ]);
    this.PhoneNumber = new FormControl(this.inputFromParent.phoneNumber, [
      Validators.required,
    ]);

    this.Profession = new FormControl(this.inputFromParent.profession, [
      Validators.required,
    ]);
    this.Institution = new FormControl(this.inputFromParent.institution, [
      Validators.required,
    ]);
    this.insertForm = this.fb.group({
      name: this.Name,
      surname: this.Surname,
      address: this.Address,
      city: this.City,
      country: this.Country,
      phoneNumber: this.PhoneNumber,
      profession: this.Profession,
      institution: this.Institution,
    });
  }
  onClose() {
    console.log(this.profileService.showDialog);
    this.profileService.showDialog = false;
  }

  onSubmit() {
    let updatedDonor: Donor = this.insertForm.value;
    this.profileService.update(updatedDonor).subscribe();
  }
}
