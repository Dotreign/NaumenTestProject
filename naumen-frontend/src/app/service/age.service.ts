import {HttpClient, HttpParams} from "@angular/common/http";
import {Injectable} from "@angular/core";

@Injectable({
  providedIn: "root"
})
export class AgeService {
  constructor(private http : HttpClient) {
  }

  getAge(name : string) {
    const url = "http://localhost:8099/name/";

    let queryParams = new HttpParams();
    queryParams = queryParams.append("name", name);
    return this.http.get(url , {params : queryParams})
  }

}
