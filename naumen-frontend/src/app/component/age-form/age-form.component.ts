import {Component} from '@angular/core';
import {AgeService} from "../../service/age.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-age-form',
  templateUrl: './age-form.component.html',
  styleUrls: ['./age-form.component.css']
})
export class AgeFormComponent {
  age_toggle : boolean = false
  age = "undefined"
  error_message : string = "Still all is done"
  name : string = ""
  getAgeForm = new FormGroup({
    name: new FormControl<string>('')
  })

  constructor(private ageService: AgeService) {
  }

  public getAge() {
    let name = this.getAgeForm.value.name
    if (name != null) {
      this.name = name
      this.ageService.getAge(<string>name).subscribe({
        next: (value) => this.age = value.toString()
    });
      this.age_toggle = true
    }

  }

}
