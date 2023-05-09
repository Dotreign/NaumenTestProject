import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { StatisticComponent } from './component/statistic/statistic.component';
import { AgeFormComponent } from './component/age-form/age-form.component';
import { LoadFileComponent } from './component/load-file/load-file.component';
import {AgeService} from "./service/age.service";
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";

@NgModule({
  declarations: [
    AppComponent,
    StatisticComponent,
    AgeFormComponent,
    LoadFileComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [
    AgeService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
