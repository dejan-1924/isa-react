import { BrowserModule } from '@angular/platform-browser';
import { APP_INITIALIZER, NgModule } from '@angular/core';

import { AppConfig } from './services/app.config.service';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './components/home/home.component';
import { RegisterComponent } from './components/register/register.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { CentersComponent } from './components/centers/centers.component';
import { LoginComponent } from './components/login/login.component';
import { ProfileComponent } from './components/profile/profile.component';
import { CenterRegistrationComponent } from './components/center-registration/center-registration.component';
import { CenterAdminRegistrationComponent } from './components/center-admin-registration/center-admin-registration.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { ModalComponent } from './components/modal/modal.component';
import { Ng2SearchPipeModule } from 'ng2-search-filter';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    RegisterComponent,
    HomeComponent,
    RegisterComponent,
    NavbarComponent,
    CentersComponent,
    LoginComponent,
    ProfileComponent,
    CenterRegistrationComponent,
    CenterAdminRegistrationComponent,
    EditProfileComponent,
    ModalComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    Ng2SearchPipeModule,
  ],
  providers: [
    AppConfig,
    {
      provide: APP_INITIALIZER,
      useFactory: initConfig,
      deps: [AppConfig],
      multi: true,
    },
  ],
  bootstrap: [AppComponent],
})
export class AppModule {}

export function initConfig(config: AppConfig) {
  return () => config.load();
}
