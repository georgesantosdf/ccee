import { Component , EventEmitter, OnInit, Output } from '@angular/core';

@Component({
  selector: 'app-upload',
  templateUrl: './upload.component.html',
  styleUrls: ['./upload.component.css']
})
export class UploadComponent implements OnInit{

  @Output() valueChange = new EventEmitter<any>();

  ngOnInit(): void {
  }

  onValueChange(event: any) {
    console.log(event)
    this.valueChange.emit(event);
  }


}
