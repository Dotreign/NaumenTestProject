import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-load-file',
  templateUrl: './load-file.component.html',
  styleUrls: ['./load-file.component.css']
})
export class LoadFileComponent {
  selectedFile: File | null | undefined;

  onFileSelected(event: any) {
    this.selectedFile = event.target.files[0];
  }
  constructor(private http: HttpClient) {
  }

  sendFile() {

    if (this.selectedFile) {
      const formData: FormData = new FormData();

      formData.append('file', this.selectedFile);

      let req = this.http.post("http://localhost:8099/load-file/", formData)
      req.subscribe()
    }

  }

}
