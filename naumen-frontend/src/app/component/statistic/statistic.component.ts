import { Component } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Name} from "../../model/Name";

@Component({
  selector: 'app-statistic',
  templateUrl: './statistic.component.html',
  styleUrls: ['./statistic.component.css']
})
export class StatisticComponent {

  isRequestsStat: boolean = false
  isMaxAgedName: boolean = false
  names: Name[] = []
  maxAgedName: Name = new class implements Name {
    age: number = 0
    id: number = 0
    name: string = ""
    requests: number = 0
  }

  constructor(public http: HttpClient) {
  }

  getRequestStatistic() {
    this.http.get<Name[]>("http://localhost:8099/stats/requests").subscribe(
      value => this.names = value
    )
    this.isRequestsStat = true
    console.log(this.names)
  }

  getMaxAged() {
    this.http.get<Name>("http://localhost:8099/stats/max-age").subscribe(
      value => this.maxAgedName = value
    )
    this.isMaxAgedName = true
  }

}
