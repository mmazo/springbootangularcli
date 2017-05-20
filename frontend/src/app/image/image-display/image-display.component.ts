import {Component, OnInit, Input} from '@angular/core';

@Component({
  selector: 'app-image-display',
  templateUrl: './image-display.component.html',
  styleUrls: ['./image-display.component.scss']
})
export class ImageDisplayComponent implements OnInit {

  @Input()
  public id: number;

  constructor() { }

  ngOnInit() {
  }

  public imageUrl(): string {
    return '/api/v1/image/' + this.id;
  }

}
